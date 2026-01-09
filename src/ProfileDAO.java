import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO {

    public void save(Profile profile) {
        String sql = "INSERT INTO profiles(username) VALUES (?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, profile.getUsername());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Profile> findAll() {
        List<Profile> profiles = new ArrayList<>();
        String sql = "SELECT * FROM profiles";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                profiles.add(new Profile(rs.getString("username")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profiles;
    }

    public void update(int id, String newUsername) {
        String sql = "UPDATE profiles SET username=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newUsername);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM profiles WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
