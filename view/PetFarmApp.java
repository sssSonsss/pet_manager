package petfarm.view;

import petfarm.db.DatabaseInitializer;
import petfarm.model.CareSchedule;
import petfarm.model.Caretaker;
import petfarm.model.Pet;
import petfarm.service.CareScheduleService;
import petfarm.service.CaretakerService;
import petfarm.service.PetService;
import petfarm.util.DateUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PetFarmApp extends JFrame {

    private final PetService petService = new PetService();
    private final CaretakerService caretakerService = new CaretakerService();
    private final CareScheduleService scheduleService = new CareScheduleService();

    private PetPanel petPanel;
    private CaretakerPanel caretakerPanel;
    private SchedulePanel schedulePanel;

    public PetFarmApp() {
        super("Pet Farm Management");
        DatabaseInitializer.initialize();
        initUi();
    }

    private void initUi() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        petPanel = new PetPanel();
        caretakerPanel = new CaretakerPanel();
        schedulePanel = new SchedulePanel();

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Quản lý thú cưng", petPanel);
        tabs.addTab("Nhân viên chăm sóc", caretakerPanel);
        tabs.addTab("Lịch chăm sóc", schedulePanel);
        add(tabs, BorderLayout.CENTER);

        setPreferredSize(new Dimension(1000, 600));
        pack();
        setLocationRelativeTo(null);
    }

    private void showError(String message, Exception ex) {
        JOptionPane.showMessageDialog(this, message + "\n" + ex.getMessage(),
            "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    private class PetPanel extends JPanel {
        private final DefaultTableModel model;
        private final JTable table;
        private final JTextField idField = new JTextField(5);
        private final JTextField nameField = new JTextField(15);
        private final JTextField speciesField = new JTextField(10);
        private final JTextField ageField = new JTextField(5);
        private final JTextField healthField = new JTextField(12);
        private final JTextField intakeField = new JTextField(10);
        private final JTextField dietField = new JTextField(15);
        private final JTextField caretakerIdField = new JTextField(5);

        PetPanel() {
            setLayout(new BorderLayout());
            model = new DefaultTableModel(
                new Object[]{"ID", "Tên", "Loài", "Tuổi", "Sức khỏe", "Ngày nhập", "Khẩu phần", "NV"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table = new JTable(model);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    fillFormFromSelection();
                }
            });
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(buildForm(), BorderLayout.SOUTH);
            reload();
            if (schedulePanel != null) {
                schedulePanel.reloadCombos();
            }
        }

        private JPanel buildForm() {
            JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT));
            idField.setEditable(false);
            form.add(new JLabel("ID:"));
            form.add(idField);
            form.add(new JLabel("Tên:"));
            form.add(nameField);
            form.add(new JLabel("Loài:"));
            form.add(speciesField);
            form.add(new JLabel("Tuổi:"));
            form.add(ageField);
            form.add(new JLabel("Sức khỏe:"));
            form.add(healthField);
            form.add(new JLabel("Ngày nhập (yyyy-MM-dd):"));
            form.add(intakeField);
            form.add(new JLabel("Khẩu phần:"));
            form.add(dietField);
            form.add(new JLabel("ID NV:"));
            form.add(caretakerIdField);

            JButton addBtn = new JButton("Thêm");
            addBtn.addActionListener(e -> {
                try {
                    Pet pet = buildPetFromForm();
                    petService.addPet(pet);
                    clearForm();
                    reload();
                    if (schedulePanel != null) {
                        schedulePanel.reloadCombos();
                    }
                } catch (Exception ex) {
                    showError("Không thể thêm thú cưng", ex);
                }
            });
            JButton updateBtn = new JButton("Cập nhật");
            updateBtn.addActionListener(e -> {
                if (idField.getText().isBlank()) {
                    JOptionPane.showMessageDialog(PetPanel.this, "Chọn một bản ghi để cập nhật");
                    return;
                }
                try {
                    Pet pet = buildPetFromForm();
                    pet.setId(Integer.parseInt(idField.getText()));
                    petService.updatePet(pet);
                    reload();
                    if (schedulePanel != null) {
                        schedulePanel.reloadCombos();
                    }
                } catch (Exception ex) {
                    showError("Không thể cập nhật thú cưng", ex);
                }
            });
            JButton deleteBtn = new JButton("Xóa");
            deleteBtn.addActionListener(e -> {
                if (idField.getText().isBlank()) {
                    JOptionPane.showMessageDialog(PetPanel.this, "Chọn một bản ghi để xóa");
                    return;
                }
                int confirm = JOptionPane.showConfirmDialog(PetPanel.this,
                    "Bạn có chắc chắn muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        petService.deletePet(Integer.parseInt(idField.getText()));
                        clearForm();
                        reload();
                        if (schedulePanel != null) {
                            schedulePanel.reloadCombos();
                        }
                    } catch (Exception ex) {
                        showError("Không thể xóa thú cưng", ex);
                    }
                }
            });
            JButton clearBtn = new JButton("Làm mới");
            clearBtn.addActionListener(e -> {
                clearForm();
                table.clearSelection();
                reload();
            });

            form.add(addBtn);
            form.add(updateBtn);
            form.add(deleteBtn);
            form.add(clearBtn);
            return form;
        }

        private Pet buildPetFromForm() {
            Pet pet = new Pet();
            pet.setName(nameField.getText());
            pet.setSpecies(speciesField.getText());
            pet.setHealthStatus(healthField.getText());
            pet.setDiet(dietField.getText());
            DateUtils.parseDate(intakeField.getText()).ifPresent(pet::setIntakeDate);
            if (!ageField.getText().isBlank()) {
                pet.setAge(Integer.parseInt(ageField.getText()));
            }
            if (!caretakerIdField.getText().isBlank()) {
                pet.setCaretakerId(Integer.parseInt(caretakerIdField.getText()));
            }
            return pet;
        }

        private void fillFormFromSelection() {
            int row = table.getSelectedRow();
            if (row == -1) {
                return;
            }
            idField.setText(model.getValueAt(row, 0).toString());
            nameField.setText(value(row, 1));
            speciesField.setText(value(row, 2));
            ageField.setText(value(row, 3));
            healthField.setText(value(row, 4));
            intakeField.setText(value(row, 5));
            dietField.setText(value(row, 6));
            caretakerIdField.setText(value(row, 7));
        }

        private String value(int row, int col) {
            Object val = model.getValueAt(row, col);
            return val == null ? "" : val.toString();
        }

        private void reload() {
            model.setRowCount(0);
            List<Pet> pets = petService.listPets();
            for (Pet pet : pets) {
                model.addRow(new Object[]{
                    pet.getId(),
                    pet.getName(),
                    pet.getSpecies(),
                    pet.getAge(),
                    pet.getHealthStatus(),
                    DateUtils.format(pet.getIntakeDate()),
                    pet.getDiet(),
                    pet.getCaretakerId()
                });
            }
        }

        private void clearForm() {
            idField.setText("");
            nameField.setText("");
            speciesField.setText("");
            ageField.setText("");
            healthField.setText("");
            intakeField.setText("");
            dietField.setText("");
            caretakerIdField.setText("");
        }
    }

    private class CaretakerPanel extends JPanel {
        private final DefaultTableModel model;
        private final JTable table;
        private final JTextField idField = new JTextField(5);
        private final JTextField nameField = new JTextField(15);
        private final JTextField phoneField = new JTextField(12);
        private final JTextField shiftField = new JTextField(10);

        CaretakerPanel() {
            setLayout(new BorderLayout());
            model = new DefaultTableModel(new Object[]{"ID", "Tên", "Điện thoại", "Ca làm"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table = new JTable(model);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    fillForm();
                }
            });
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(buildForm(), BorderLayout.SOUTH);
            reload();
            if (schedulePanel != null) {
                schedulePanel.reloadCombos();
            }
        }

        private JPanel buildForm() {
            JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT));
            idField.setEditable(false);
            form.add(new JLabel("ID:"));
            form.add(idField);
            form.add(new JLabel("Tên:"));
            form.add(nameField);
            form.add(new JLabel("Điện thoại:"));
            form.add(phoneField);
            form.add(new JLabel("Ca làm:"));
            form.add(shiftField);

            JButton add = new JButton("Thêm");
            add.addActionListener(e -> {
                try {
                    Caretaker caretaker = buildCaretaker();
                    caretakerService.addCaretaker(caretaker);
                    clear();
                    reload();
                    if (schedulePanel != null) {
                        schedulePanel.reloadCombos();
                    }
                } catch (Exception ex) {
                    showError("Không thể thêm nhân viên", ex);
                }
            });
            JButton update = new JButton("Cập nhật");
            update.addActionListener(e -> {
                if (idField.getText().isBlank()) {
                    JOptionPane.showMessageDialog(CaretakerPanel.this, "Chọn bản ghi");
                    return;
                }
                try {
                    Caretaker caretaker = buildCaretaker();
                    caretaker.setId(Integer.parseInt(idField.getText()));
                    caretakerService.updateCaretaker(caretaker);
                    reload();
                    if (schedulePanel != null) {
                        schedulePanel.reloadCombos();
                    }
                } catch (Exception ex) {
                    showError("Không thể cập nhật nhân viên", ex);
                }
            });
            JButton delete = new JButton("Xóa");
            delete.addActionListener(e -> {
                if (idField.getText().isBlank()) {
                    JOptionPane.showMessageDialog(CaretakerPanel.this, "Chọn bản ghi");
                    return;
                }
                int confirm = JOptionPane.showConfirmDialog(CaretakerPanel.this,
                    "Chắc chắn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        caretakerService.deleteCaretaker(Integer.parseInt(idField.getText()));
                        clear();
                        reload();
                        if (schedulePanel != null) {
                            schedulePanel.reloadCombos();
                        }
                    } catch (Exception ex) {
                        showError("Không thể xóa nhân viên", ex);
                    }
                }
            });
            JButton clearBtn = new JButton("Làm mới");
            clearBtn.addActionListener(e -> {
                clear();
                table.clearSelection();
                reload();
            });

            form.add(add);
            form.add(update);
            form.add(delete);
            form.add(clearBtn);
            return form;
        }

        private Caretaker buildCaretaker() {
            Caretaker caretaker = new Caretaker();
            caretaker.setName(nameField.getText());
            caretaker.setPhone(phoneField.getText());
            caretaker.setShift(shiftField.getText());
            return caretaker;
        }

        private void fillForm() {
            int row = table.getSelectedRow();
            if (row == -1) return;
            idField.setText(value(row, 0));
            nameField.setText(value(row, 1));
            phoneField.setText(value(row, 2));
            shiftField.setText(value(row, 3));
        }

        private String value(int row, int col) {
            Object val = model.getValueAt(row, col);
            return val == null ? "" : val.toString();
        }

        private void reload() {
            model.setRowCount(0);
            List<Caretaker> caretakers = caretakerService.listCaretakers();
            for (Caretaker caretaker : caretakers) {
                model.addRow(new Object[]{
                    caretaker.getId(),
                    caretaker.getName(),
                    caretaker.getPhone(),
                    caretaker.getShift()
                });
            }
        }

        private void clear() {
            idField.setText("");
            nameField.setText("");
            phoneField.setText("");
            shiftField.setText("");
        }
    }

    private class SchedulePanel extends JPanel {
        private final DefaultTableModel model;
        private final JTable table;
        private final JComboBox<PetOption> petCombo = new JComboBox<>();
        private final JComboBox<CaretakerOption> caretakerCombo = new JComboBox<>();
        private final JTextField activityField = new JTextField(15);
        private final JTextField dateField = new JTextField(10);
        private final JTextField notesField = new JTextField(15);
        private Integer editingId;

        SchedulePanel() {
            setLayout(new BorderLayout());
            model = new DefaultTableModel(new Object[]{"ID", "Thú cưng", "Nhân viên", "Hoạt động", "Ngày", "Ghi chú"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table = new JTable(model);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) fillForm();
            });
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(buildForm(), BorderLayout.SOUTH);
            reloadCombos();
            reload();
        }

        private JPanel buildForm() {
            JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT));
            petCombo.setPreferredSize(new Dimension(150, 25));
            caretakerCombo.setPreferredSize(new Dimension(150, 25));
            form.add(new JLabel("Thú cưng:"));
            form.add(petCombo);
            form.add(new JLabel("Nhân viên:"));
            form.add(caretakerCombo);
            form.add(new JLabel("Hoạt động:"));
            form.add(activityField);
            form.add(new JLabel("Ngày (yyyy-MM-dd):"));
            form.add(dateField);
            form.add(new JLabel("Ghi chú:"));
            form.add(notesField);

            JButton save = new JButton("Lưu");
            save.addActionListener(e -> saveSchedule());
            JButton delete = new JButton("Xóa");
            delete.addActionListener(e -> deleteSchedule());
            JButton clear = new JButton("Làm mới");
            clear.addActionListener(e -> {
                editingId = null;
                table.clearSelection();
                activityField.setText("");
                dateField.setText("");
                notesField.setText("");
            });

            form.add(save);
            form.add(delete);
            form.add(clear);
            return form;
        }

        private void saveSchedule() {
            PetOption pet = (PetOption) petCombo.getSelectedItem();
            CaretakerOption caretaker = (CaretakerOption) caretakerCombo.getSelectedItem();
            if (pet == null || caretaker == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn thú cưng và nhân viên");
                return;
            }
            try {
                CareSchedule schedule = new CareSchedule();
                schedule.setPetId(pet.id());
                schedule.setCaretakerId(caretaker.id());
                schedule.setActivity(activityField.getText());
                Optional<LocalDate> dateOpt = DateUtils.parseDate(dateField.getText());
                if (dateOpt.isEmpty()) {
                    throw new IllegalArgumentException("Ngày không hợp lệ");
                }
                schedule.setScheduleDate(dateOpt.get());
                schedule.setNotes(notesField.getText());
                if (editingId == null) {
                    scheduleService.addSchedule(schedule);
                } else {
                    schedule.setId(editingId);
                    scheduleService.updateSchedule(schedule);
                }
                editingId = null;
                reload();
            } catch (Exception ex) {
                showError("Không thể lưu lịch chăm sóc", ex);
            }
        }

        private void deleteSchedule() {
            if (editingId == null) {
                JOptionPane.showMessageDialog(this, "Chọn một bản ghi để xóa");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(this, "Xóa lịch chăm sóc?", "Xác nhận",
                JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    scheduleService.deleteSchedule(editingId);
                    editingId = null;
                    reload();
                } catch (Exception ex) {
                    showError("Không thể xóa lịch chăm sóc", ex);
                }
            }
        }

        private void fillForm() {
            int row = table.getSelectedRow();
            if (row == -1) {
                editingId = null;
                return;
            }
            editingId = (Integer) model.getValueAt(row, 0);
            PetOption petOption = (PetOption) model.getValueAt(row, 1);
            CaretakerOption caretakerOption = (CaretakerOption) model.getValueAt(row, 2);
            selectCombo(petCombo, petOption.id());
            selectCombo(caretakerCombo, caretakerOption.id());
            activityField.setText(value(row, 3));
            dateField.setText(value(row, 4));
            notesField.setText(value(row, 5));
        }

        private String value(int row, int col) {
            Object val = model.getValueAt(row, col);
            return val == null ? "" : val.toString();
        }

        private void reload() {
            model.setRowCount(0);
            List<CareSchedule> schedules = scheduleService.listSchedules();
            for (CareSchedule schedule : schedules) {
                PetOption petOption = petService.findById(schedule.getPetId())
                    .map(p -> new PetOption(p.getId(), p.getName()))
                    .orElse(new PetOption(schedule.getPetId(), "Pet #" + schedule.getPetId()));
                CaretakerOption caretakerOption = caretakerService.findById(schedule.getCaretakerId())
                    .map(c -> new CaretakerOption(c.getId(), c.getName()))
                    .orElse(new CaretakerOption(schedule.getCaretakerId(), "NV #" + schedule.getCaretakerId()));
                model.addRow(new Object[]{
                    schedule.getId(),
                    petOption,
                    caretakerOption,
                    schedule.getActivity(),
                    DateUtils.format(schedule.getScheduleDate()),
                    schedule.getNotes()
                });
            }
        }

        public void reloadCombos() {
            petCombo.removeAllItems();
            caretakerCombo.removeAllItems();
            for (Pet pet : petService.listPets()) {
                petCombo.addItem(new PetOption(pet.getId(), pet.getName()));
            }
            for (Caretaker caretaker : caretakerService.listCaretakers()) {
                caretakerCombo.addItem(new CaretakerOption(caretaker.getId(), caretaker.getName()));
            }
        }

        private <T extends ComboOption> void selectCombo(JComboBox<T> combo, Integer id) {
            if (id == null) {
                combo.setSelectedIndex(-1);
                return;
            }
            for (int i = 0; i < combo.getItemCount(); i++) {
                if (combo.getItemAt(i).id().equals(id)) {
                    combo.setSelectedIndex(i);
                    return;
                }
            }
            combo.setSelectedIndex(-1);
        }
    }

    private interface ComboOption {
        Integer id();
        String label();
    }

    private record PetOption(Integer id, String label) implements ComboOption {
        @Override
        public String toString() {
            return label + " (#" + id + ")";
        }
    }

    private record CaretakerOption(Integer id, String label) implements ComboOption {
        @Override
        public String toString() {
            return label + " (#" + id + ")";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PetFarmApp().setVisible(true));
    }
}

