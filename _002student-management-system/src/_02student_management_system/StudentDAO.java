package _02student_management_system;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static void addStudent(Student student) {
        String sql = "INSERT INTO students(name, course, age) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getCourse());
            stmt.setInt(3, student.getAge());

            stmt.executeUpdate();
            System.out.println("✅ Student added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewAllStudents() {
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("📋 All Students:");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Course: %s | Age: %d%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Course: %s | Age: %d%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getInt("age"));
            } else {
                System.out.println("❌ Student not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, course = ?, age = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getCourse());
            stmt.setInt(3, student.getAge());
            stmt.setInt(4, student.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("📝 Student updated successfully!");
            } else {
                System.out.println("❌ Student not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("❌ Student deleted successfully.");
                reindexIDs();
            } else {
                System.out.println("❌ Student not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void reindexIDs() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("SET @count = 0");
            stmt.execute("UPDATE students SET id = @count := @count + 1");
            stmt.execute("ALTER TABLE students AUTO_INCREMENT = 1");
            System.out.println("🔄 IDs re-indexed successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
