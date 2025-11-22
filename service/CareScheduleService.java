package petfarm.service;

import petfarm.model.CareSchedule;
import petfarm.repository.CareScheduleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CareScheduleService {

    private final CareScheduleRepository repository;

    public CareScheduleService() {
        this(new CareScheduleRepository());
    }

    public CareScheduleService(CareScheduleRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    public List<CareSchedule> listSchedules() {
        return repository.findAll();
    }

    public CareSchedule addSchedule(CareSchedule schedule) {
        validate(schedule, false);
        int id = repository.create(schedule);
        schedule.setId(id);
        return schedule;
    }

    public CareSchedule updateSchedule(CareSchedule schedule) {
        validate(schedule, true);
        repository.update(schedule);
        return schedule;
    }

    public void deleteSchedule(int id) {
        repository.delete(id);
    }

    public Optional<CareSchedule> findById(int id) {
        return repository.findById(id);
    }

    private void validate(CareSchedule schedule, boolean requireId) {
        if (schedule == null) {
            throw new IllegalArgumentException("Schedule cannot be null");
        }
        if (requireId && schedule.getId() == null) {
            throw new IllegalArgumentException("Schedule ID is required");
        }
        if (schedule.getPetId() == null || schedule.getCaretakerId() == null) {
            throw new IllegalArgumentException("Phải chọn thú cưng và nhân viên phụ trách");
        }
        if (schedule.getActivity() == null || schedule.getActivity().isBlank()) {
            throw new IllegalArgumentException("Hoạt động không được trống");
        }
        LocalDate date = schedule.getScheduleDate();
        if (date == null) {
            throw new IllegalArgumentException("Ngày chăm sóc không được trống");
        }
    }
}

