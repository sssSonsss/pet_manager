package petfarm.repository;

import petfarm.db.SQLiteConnectionManager;
import petfarm.model.CareSchedule;
import petfarm.util.DateUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CareScheduleRepository {

    public List<CareSchedule> findAll() {
        String sql = "SELECT * FROM care_schedule ORDER BY schedule_date DESC";
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<CareSchedule> schedules = new ArrayList<>();
            while (rs.next()) {
                schedules.add(mapRow(rs));
            }
            return schedules;
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to read schedules", e);
        }
    }

    public Optional<CareSchedule> findById(int id) {
        String sql = "SELECT * FROM care_schedule WHERE id = ?";
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRow(rs));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to read schedule " + id, e);
        }
    }

    public int create(CareSchedule schedule) {
        String sql = """
            INSERT INTO care_schedule (pet_id, caretaker_id, activity, schedule_date, notes)
            VALUES (?, ?, ?, ?, ?)
            """;
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            bind(ps, schedule);
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
            throw new IllegalStateException("Insert succeeded but no ID returned");
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create schedule", e);
        }
    }

    public boolean update(CareSchedule schedule) {
        if (schedule.getId() == null) {
            throw new IllegalArgumentException("Schedule ID required for update");
        }
        String sql = """
            UPDATE care_schedule
            SET pet_id=?, caretaker_id=?, activity=?, schedule_date=?, notes=?
            WHERE id=?
            """;
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            bind(ps, schedule);
            ps.setObject(6, schedule.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to update schedule " + schedule.getId(), e);
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM care_schedule WHERE id = ?";
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to delete schedule " + id, e);
        }
    }

    private void bind(PreparedStatement ps, CareSchedule schedule) throws SQLException {
        ps.setObject(1, schedule.getPetId());
        ps.setObject(2, schedule.getCaretakerId());
        ps.setString(3, schedule.getActivity());
        ps.setString(4, schedule.getScheduleDate() != null ? schedule.getScheduleDate().toString() : null);
        ps.setString(5, schedule.getNotes());
    }

    private CareSchedule mapRow(ResultSet rs) throws SQLException {
        LocalDate date = null;
        String dateStr = rs.getString("schedule_date");
        if (dateStr != null) {
            date = DateUtils.parseDate(dateStr).orElse(null);
        }
        return new CareSchedule(
            rs.getInt("id"),
            rs.getInt("pet_id"),
            rs.getInt("caretaker_id"),
            rs.getString("activity"),
            date,
            rs.getString("notes")
        );
    }
}

