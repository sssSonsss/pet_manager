package petfarm.repository;

import petfarm.db.SQLiteConnectionManager;
import petfarm.model.Pet;
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

public class PetRepository {

    public List<Pet> findAll() {
        String sql = "SELECT * FROM pets ORDER BY id DESC";
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<Pet> pets = new ArrayList<>();
            while (rs.next()) {
                pets.add(mapRow(rs));
            }
            return pets;
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to read pets", e);
        }
    }

    public Optional<Pet> findById(int id) {
        String sql = "SELECT * FROM pets WHERE id = ?";
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRow(rs));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to read pet " + id, e);
        }
    }

    public int create(Pet pet) {
        String sql = """
            INSERT INTO pets (name, species, age, health_status, intake_date, diet, caretaker_id)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            bind(ps, pet);
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
            throw new IllegalStateException("Insert succeeded but no ID returned");
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create pet", e);
        }
    }

    public boolean update(Pet pet) {
        if (pet.getId() == null) {
            throw new IllegalArgumentException("Pet ID required for update");
        }
        String sql = """
            UPDATE pets SET name=?, species=?, age=?, health_status=?, intake_date=?, diet=?, caretaker_id=?
            WHERE id=?
            """;
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            bind(ps, pet);
            ps.setObject(8, pet.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to update pet " + pet.getId(), e);
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM pets WHERE id = ?";
        try (Connection conn = SQLiteConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to delete pet " + id, e);
        }
    }

    private void bind(PreparedStatement ps, Pet pet) throws SQLException {
        ps.setString(1, pet.getName());
        ps.setString(2, pet.getSpecies());
        ps.setObject(3, pet.getAge());
        ps.setString(4, pet.getHealthStatus());
        ps.setString(5, pet.getIntakeDate() != null ? pet.getIntakeDate().toString() : null);
        ps.setString(6, pet.getDiet());
        ps.setObject(7, pet.getCaretakerId());
    }

    private Pet mapRow(ResultSet rs) throws SQLException {
        LocalDate intake = null;
        String intakeStr = rs.getString("intake_date");
        if (intakeStr != null) {
            intake = DateUtils.parseDate(intakeStr).orElse(null);
        }
        return new Pet(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("species"),
            (Integer) rs.getObject("age"),
            rs.getString("health_status"),
            intake,
            rs.getString("diet"),
            (Integer) rs.getObject("caretaker_id")
        );
    }
}

