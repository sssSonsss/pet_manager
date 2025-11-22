package petfarm.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Creates schema + inserts sample data on first launch.
 */
public final class DatabaseInitializer {

    private DatabaseInitializer() {
    }

    public static void initialize() {
        try (Connection conn = SQLiteConnectionManager.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("PRAGMA foreign_keys = ON");

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS caretakers (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    phone TEXT,
                    shift TEXT
                )
                """);

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS pets (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    species TEXT NOT NULL,
                    age INTEGER,
                    health_status TEXT,
                    intake_date TEXT,
                    diet TEXT,
                    caretaker_id INTEGER,
                    FOREIGN KEY (caretaker_id) REFERENCES caretakers(id) ON DELETE SET NULL
                )
                """);

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS care_schedule (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    pet_id INTEGER NOT NULL,
                    caretaker_id INTEGER NOT NULL,
                    activity TEXT NOT NULL,
                    schedule_date TEXT NOT NULL,
                    notes TEXT,
                    FOREIGN KEY (pet_id) REFERENCES pets(id) ON DELETE CASCADE,
                    FOREIGN KEY (caretaker_id) REFERENCES caretakers(id) ON DELETE CASCADE
                )
                """);

            seedIfEmpty(stmt);
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to initialize SQLite schema", e);
        }
    }

    private static void seedIfEmpty(Statement stmt) throws SQLException {
        stmt.executeUpdate("""
            INSERT INTO caretakers (name, phone, shift)
            SELECT 'Lan Nguyen', '0901234567', 'Morning'
            WHERE NOT EXISTS (SELECT 1 FROM caretakers)
            """);

        stmt.executeUpdate("""
            INSERT INTO caretakers (name, phone, shift)
            SELECT 'Huy Tran', '0919876543', 'Evening'
            WHERE NOT EXISTS (SELECT 1 FROM caretakers WHERE name = 'Huy Tran')
            """);

        stmt.executeUpdate("""
            INSERT INTO pets (name, species, age, health_status, intake_date, diet, caretaker_id)
            SELECT 'Milo', 'Dog', 2, 'Healthy', '2025-01-15', 'Premium dry food', 1
            WHERE NOT EXISTS (SELECT 1 FROM pets)
            """);

        stmt.executeUpdate("""
            INSERT INTO care_schedule (pet_id, caretaker_id, activity, schedule_date, notes)
            SELECT 1, 1, 'Vaccination', '2025-02-10', 'Annual booster'
            WHERE NOT EXISTS (SELECT 1 FROM care_schedule)
            """);
    }
}

