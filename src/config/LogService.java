package config;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LogService {

    public static void logAction(int userId, String action) {
        String sql = "INSERT INTO tbl_logs (user_id, action, date_time) VALUES (?, ?, datetime('now','localtime'))";

        try (Connection con = config.connectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, userId);
            pst.setString(2, action);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}