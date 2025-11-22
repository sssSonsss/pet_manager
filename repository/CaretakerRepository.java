package petfarm.repository;

import petfarm.db.SQLiteConnectionManager;
import petfarm.model.Caretaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CaretakerRepository {

    public List<Caretaker> findAll() {
        String sql = "SELECT * FROM caretakers ORDER BY name";
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<Caretaker> caretakers = new ArrayList<>();
            while (rs.next()) {
                caretakers.add(mapRow(rs));
            }
            return caretakers;
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to read caretakers", e);
        }
    }

    public Optional<Caretaker> findById(int id) {
        String sql = "SELECT * FROM caretakers WHERE id = ?";
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRow(rs));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to read caretaker " + id, e);
        }
    }

    public int create(Caretaker caretaker) {
        String sql = "INSERT INTO caretakers (name, phone, shift) VALUES (?, ?, ?)";
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            bind(ps, caretaker);
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
            throw new IllegalStateException("Insert succeeded but no ID returned");
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create caretaker", e);
        }
    }

    public boolean update(Caretaker caretaker) {
        if (caretaker.getId() == null) {
            throw new IllegalArgumentException("Caretaker ID required for update");
        }
        String sql = "UPDATE caretakers SET name=?, phone=?, shift=? WHERE id=?";
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            bind(ps, caretaker);
            ps.setObject(4, caretaker.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to update caretaker " + caretaker.getId(), e);
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM caretakers WHERE id = ?";
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to delete caretaker " + id, e);
        }
    }

    private void bind(PreparedStatement ps, Caretaker caretaker) throws SQLException {
        ps.setString(1, caretaker.getName());
        ps.setString(2, caretaker.getPhone());
        ps.setString(3, caretaker.getShift());
    }

    private Caretaker mapRow(ResultSet rs) throws SQLException {
        return new Caretaker(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("phone"),
            rs.getString("shift")
        );
    }
}

