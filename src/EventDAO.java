import java.sql.*;
import java.time.LocalDate;

public class EventDAO {

    private MyJDBC db = new MyJDBC();

    public int save(Event event) {
        String sql =
                "INSERT INTO EVENTS(name, eventDate, location) VALUES (?, ?, ?)";

        try (Connection conn = db.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, event.getName());
            ps.setDate(2, Date.valueOf(event.getDate()));
            ps.setString(3, event.getLocation());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // eventID
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
