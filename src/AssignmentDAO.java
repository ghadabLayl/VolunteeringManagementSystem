import java.sql.*;

public class AssignmentDAO {

    private MyJDBC db = new MyJDBC();

    public void save(int volunteerID, int taskID, int hours) {

        String sql =
                "INSERT INTO ASSIGNMENTS(volunteerID, taskID, hoursContributed) " +
                        "VALUES (?, ?, ?)";

        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, volunteerID);
            ps.setInt(2, taskID);
            ps.setInt(3, hours);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
