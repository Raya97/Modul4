package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static final Logger logger = Logger.getLogger(Database.class.getName());
    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            // Підключення до бази даних H2
            connection = DriverManager.getConnection("jdbc:h2:~/Raisa_Modul3", "Raisa", "");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Помилка при підключенні до бази даних", e);
        }
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
