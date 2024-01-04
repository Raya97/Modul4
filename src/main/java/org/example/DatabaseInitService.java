package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseInitService {
    private static final Logger logger = Logger.getLogger(DatabaseInitService.class.getName());

    public static void main(String[] args) {
        try {
            // Підключення до бази даних використовуючи клас Database
            Connection connection = Database.getInstance().getConnection();

            // SQL запит з файлу init_db.sql
            String sqlFilePath = "sql/init_db.sql";
            String sql = readSQLFromFile(sqlFilePath);

            // Ім'я таблиці для перевірки і створення
            String tableName = "CLIENT";

            // Перевірка наявності таблиці "CLIENT"
            if (!tableExists(connection, tableName)) {
                // Таблиця "CLIENT" не існує, можна її створити
                String createTableSQL = "CREATE TABLE " + tableName + " (ID SERIAL PRIMARY KEY, NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000))";
                executeSQL(connection, createTableSQL);
                System.out.println("Таблицю " + tableName + " створено.");
            } else {
                System.out.println("Таблиця " + tableName + " вже існує.");
            }

            // Виконання SQL запиту для ініціалізації бази даних
            executeSQL(connection, sql);

            System.out.println("Базу даних ініціалізовано успішно.");
        } catch (SQLException | IOException e) {
            if (e.getMessage().contains("already exists")) {
                // Ігнорувати виняток, якщо таблиця вже існує
                System.out.println("Таблиця вже існує.");
            } else {
                logger.log(Level.SEVERE, "Помилка при ініціалізації бази даних", e);
            }
        }
    }

    private static String readSQLFromFile(String filePath) throws IOException {
        StringBuilder sql = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
            }
        }
        return sql.toString();
    }

    private static void executeSQL(Connection connection, String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static boolean tableExists(Connection connection, String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT 1 FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME='" + tableName + "'");
            return resultSet.next();
        }
    }
}
