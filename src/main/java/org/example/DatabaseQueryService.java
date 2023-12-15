package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseQueryService {
    private final Connection connection;
    private static final Logger logger = Logger.getLogger(DatabaseQueryService.class.getName());

    public DatabaseQueryService() {
        this.connection = Database.getInstance().getConnection();
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        try {
            // SQL запит з відповідного файлу (find_max_projects_client.sql)
            String sqlFilePath = "sql/find_max_projects_client.sql";
            String sql = readSQLFromFile(sqlFilePath);

            // Виконую SQL-запит
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Результат запиту і додаю його до списку
            while (resultSet.next()) {
                MaxProjectCountClient client = new MaxProjectCountClient();
                client.setName(resultSet.getString("name"));
                client.setProjectCount(resultSet.getInt("project_count"));
                result.add(client);
            }
        } catch (SQLException | IOException e) {
            logger.log(Level.SEVERE, "Помилка при вибірці даних з бази даних", e);
        }
        return result;
    }

    // Зчитування SQL запитів з файлу
    private String readSQLFromFile(String filePath) throws IOException {
        StringBuilder sql = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
            }
        }
        return sql.toString();
    }

    public static void main(String[] args) {
        // Використання методу findMaxProjectsClient
        DatabaseQueryService queryService = new DatabaseQueryService();
        List<MaxProjectCountClient> clients = queryService.findMaxProjectsClient();

        // Виведення результату на консоль
        for (MaxProjectCountClient client : clients) {
            System.out.println("Ім'я: " + client.getName());
            System.out.println("Кількість проектів: " + client.getProjectCount());
            System.out.println("-----------------------------");
        }
    }
}
