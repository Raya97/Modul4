package org.example;

import java.util.Date;

public class MaxProjectCountClient {
    private int projectCount; // Нова властивість, кількість проектів
    private int id; // Унікальний ідентифікатор
    private String name; // Ім'я клієнта
    private final Date birthday; // Дата народження
    private final String level; // Рівень клієнта
    private final double salary; // Зарплата
    private final int clientId; // Унікальний ідентифікатор клієнта
    private int workerId; // Унікальний ідентифікатор працівника

    // Порожній конструктор для ініціалізації за замовчуванням
    public MaxProjectCountClient() {
        this.id = 0;
        this.name = "";
        this.birthday = new Date();
        this.level = "";
        this.salary = 0.0;
        this.clientId = 0;
    }

    // Конструктор класу для ініціалізації всіх властивостей
    public MaxProjectCountClient(int id, String name, Date birthday, String level, double salary, int clientId, int workerId, int projectCount) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
        this.clientId = clientId;
        this.workerId = workerId;
        this.projectCount = projectCount;
    }

    // Геттери та сеттери для всіх властивостей

    // Геттер та сеттер для дати початку проекту
    private Date startDate;
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    // Геттер та сеттер для дати завершення проекту
    private Date finishDate;
    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    // Геттер та сеттер для ідентифікатора проекту
    private int projectId;
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    // Геттер та сеттер для унікального ідентифікатора об'єкта
    public int getId() {
        return id;
    }

    public void setId() {
        setId(0);
    }

    public void setId(int id) {
        this.id = id;
    }

    // Геттер та сеттер для імені клієнта
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Геттер для дати народження
    public Date getBirthday() {
        return birthday;
    }

    // Геттер для рівня клієнта
    public String getLevel() {
        return level;
    }

    // Геттер для зарплати
    public double getSalary() {
        return salary;
    }

    // Геттер для унікального ідентифікатора клієнта
    public int getClientId() {
        return clientId;
    }

    // Геттер та сеттер для унікального ідентифікатора працівника
    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    // Геттер та сеттер для кількості проектів клієнта
    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    // Перевизначений метод toString() для представлення об'єкта у вигляді рядка
    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", level='" + level + '\'' +
                ", salary=" + salary +
                ", clientId=" + clientId +
                ", workerId=" + workerId +
                ", projectCount=" + projectCount +
                '}';
    }
}
