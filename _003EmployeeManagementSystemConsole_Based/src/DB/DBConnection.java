// Source code is decompiled from a .class file using FernFlower decompiler.
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   private static final String url = "jdbc:mysql://localhost:3306/employeedb";
   private static final String user = "root";
   private static final String password = "amolkadam7709";
   private static Connection connection;

   public DBConnection() {
   }

   public static Connection getConnection() {
      try {
         if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "amolkadam7709");
//            System.out.println("✅ Connected to the database!");
         }
      } catch (SQLException var1) {
         System.out.println("❌ Database connection failed: " + var1.getMessage());
      }

      return connection;
   }
}
