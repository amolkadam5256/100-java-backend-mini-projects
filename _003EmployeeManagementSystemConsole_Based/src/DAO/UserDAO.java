package DAO;

import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
   public UserDAO() {
   }

   public static boolean validateLogin(String username, String password, String role) {
      try {
         Connection conn = DBConnection.getConnection();
         String sql = "SELECT * FROM employees WHERE username = ? AND password = ? AND role = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, username);
         ps.setString(2, password);
         ps.setString(3, role);
         ResultSet rs = ps.executeQuery();
         return rs.next();
      } catch (Exception var7) {
         System.out.println("❌ Login error: " + var7.getMessage());
         return false;
      }
   }
}
