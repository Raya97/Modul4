package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseInitService {
    private static final Logger logger = Logger.getLogger(DatabaseInitService.class.getName());

    public static void main(String[] args) {
        try {
            // підключення до бази даних використовуючи клас Database
            Connection connection = Database.getInstance().getConnection();

            // SQL запит з файлу init_db.sql
            String sqlFilePath = "sql/init_db.sql";
            String sql = readSQLFromFile(sqlFilePath);

            // SQL запит для ініціалізації бази даних
            executeSQL(connection, sql);

            System.out.println("Базу даних ініціалізовано успішно.");
        } catch (SQLException | IOException e) {
            logger.log(Level.SEVERE, "Помилка при ініціалізації бази даних", e);
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
}
