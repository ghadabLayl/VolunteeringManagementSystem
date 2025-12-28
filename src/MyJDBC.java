import java.sql.*;

public class MyJDBC {

    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/VOLUNTEERAPP";
    private static final String USERNAME = "root";
    private static final String PASS = "password123";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASS);
    }

    public void createSchema() throws SQLException {

        try (Connection conn =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:3306", USERNAME, PASS);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS VOLUNTEERAPP;");
        }

        // tables will be created using normal connections
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS VOLUNTEERS(" +
                            "volunteerID INT PRIMARY KEY AUTO_INCREMENT," +
                            "name VARCHAR(255) NOT NULL," +
                            "email VARCHAR(255) NOT NULL UNIQUE," +
                            "energyLevel INT NOT NULL," +
                            "experienceLevel ENUM('BEGINNER','INTERMEDIATE','EXPERT') NOT NULL" +
                            ");"
            );

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS EVENTS(" +
                            "eventID INT PRIMARY KEY AUTO_INCREMENT," +
                            "name VARCHAR(255) NOT NULL," +
                            "eventDate DATE NOT NULL," +
                            "location VARCHAR(255)" +
                            ");"
            );

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS TASKS(" +
                            "taskID INT PRIMARY KEY AUTO_INCREMENT," +
                            "eventID INT NOT NULL," +
                            "taskType ENUM('FOOD','EDUCATION','LOGISTICS') NOT NULL," +
                            "requiredVolunteers INT NOT NULL," +
                            "durationHours INT NOT NULL," +
                            "FOREIGN KEY (eventID) REFERENCES EVENTS(eventID) ON DELETE CASCADE" +
                            ");"
            );

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS ASSIGNMENTS(" +
                            "assignmentID INT PRIMARY KEY AUTO_INCREMENT," +
                            "volunteerID INT NOT NULL," +
                            "taskID INT NOT NULL," +
                            "hoursContributed INT," +
                            "FOREIGN KEY (taskID) REFERENCES TASKS(taskID) ON DELETE CASCADE," +
                            "FOREIGN KEY (volunteerID) REFERENCES VOLUNTEERS(volunteerID) ON DELETE CASCADE" +
                            ");"
            );
        }

        System.out.println("Database and tables ready!");
    }
}
