package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabasePopulateService {
    private static final Logger logger = Logger.getLogger(DatabasePopulateService.class.getName());

    public static void main(String[] args) {
        try {
            // Підключення до бази даних використовуючи клас Database
            Connection connection = Database.getInstance().getConnection();

            // SQL запити з файлу populate_db.sql
            String sqlFilePath = "sql/populate_db.sql";
            String sql = readSQLFromFile(sqlFilePath);

            // SQL запити для наповнення таблиць бази даних
            executeSQL(connection, sql);

            System.out.println("Таблиці бази даних успішно заповнено даними.");
        } catch (SQLException | IOException e) {
            logger.log(Level.SEVERE, "Помилка при наповненні таблиць бази даних", e);
        }
    }

    // Метод для зчитування SQL-запитів з файлу
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

    // Метод для виконання SQL-запитів
    private static void executeSQL(Connection connection, String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }
}
