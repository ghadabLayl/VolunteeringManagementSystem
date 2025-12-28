import java.sql.*;

public class VolunteerDAO {

    private final MyJDBC db = new MyJDBC();

    public void save(Volunteer v) {
        String sql =
                "INSERT INTO VOLUNTEERS(name, email, energyLevel, experienceLevel) " +
                        "VALUES (?, ?, ?, ?)";

        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, v.getName());
            ps.setString(2, v.getEmail());
            ps.setInt(3, v.getEnergyLevel());
            ps.setString(4, v.getExperienceLevel().name());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Volunteer findById(int id) {
        String sql = "SELECT * FROM VOLUNTEERS WHERE volunteerID = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Volunteer(
                        rs.getInt("volunteerID"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("energyLevel"),
                        ExperienceLevel.valueOf(rs.getString("experienceLevel"))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
