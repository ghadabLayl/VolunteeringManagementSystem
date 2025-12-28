import java.sql.*;

public class TaskDAO {

    private MyJDBC db = new MyJDBC();

    public void save(Task task, int eventID) {

        String sql =
                "INSERT INTO TASKS(eventID, taskType, requiredVolunteers, durationHours) " +
                        "VALUES (?, ?, ?, ?)";

        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, eventID);

            if (task instanceof FoodTask)
                ps.setString(2, "FOOD");
            else if (task instanceof EducationTask)
                ps.setString(2, "EDUCATION");
            else
                ps.setString(2, "LOGISTICS");

            ps.setInt(3, 1); // keep simple for now
            ps.setInt(4, task.durationHours);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
