package petfarm.db;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Centralized helper responsible for creating SQLite connections.
 */
public final class SQLiteConnectionManager {

    private static final String JDBC_PREFIX = "jdbc:sqlite:";
    private static final Path DB_PATH = Paths.get("petfarm", "db", "petfarm.db").toAbsolutePath();

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Missing sqlite-jdbc driver on classpath", e);
        }
        ensureParentDirectoryExists();
    }

    private SQLiteConnectionManager() {
    }

    private static void ensureParentDirectoryExists() {
        try {
            Files.createDirectories(DB_PATH.getParent());
        } catch (Exception e) {
            throw new IllegalStateException("Unable to create database directory", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_PREFIX + DB_PATH);
    }

    public static Path getDatabasePath() {
        return DB_PATH;
    }
}

