package DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import DB.DBConnection;

public class AdminDAO {

	public static void reindexIDs() {
		try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {

			stmt.execute("SET @count = 0");
			stmt.execute("UPDATE employees SET employee_id = @count := @count + 1");
			stmt.execute("ALTER TABLE employees AUTO_INCREMENT = 1");
			System.out.println("🔄 IDs re-indexed successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	view employees here
	public static void ShowAllEmp() {
		String sql = "SELECT * FROM employees";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			try (ResultSet rs = stmt.executeQuery()) {
				// Iterate through all rows in the ResultSet
				while (rs.next()) {
					int id = rs.getInt("employee_id");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					String gender = rs.getString("gender");
					Date dob = rs.getDate("date_of_birth");
					String contact = rs.getString("contact_number");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String city = rs.getString("city");
					String state = rs.getString("state");
					String country = rs.getString("country");
					String postalCode = rs.getString("postal_code");
					String department = rs.getString("department");
					String designation = rs.getString("designation");
					Date joiningDate = rs.getDate("joining_date");
					String employmentType = rs.getString("employment_type");
					String status = rs.getString("status");
					BigDecimal basicSalary = rs.getBigDecimal("basic_salary");
					BigDecimal hra = rs.getBigDecimal("hra");
					BigDecimal otherAllowance = rs.getBigDecimal("other_allowance");
					BigDecimal totalSalary = rs.getBigDecimal("total_salary");
					String username = rs.getString("username");
					String password = rs.getString("password"); // Fetch the password
					String role = rs.getString("role");
					Timestamp createdAt = rs.getTimestamp("created_at");
					Timestamp updatedAt = rs.getTimestamp("updated_at");

					// Print employee data in name: value format
					System.out.println("Employee ID: " + id);
					System.out.println("First Name: " + firstName);
					System.out.println("Last Name: " + lastName);
					System.out.println("Gender: " + gender);
					System.out.println("Date of Birth: " + (dob != null ? dob.toString() : "N/A"));
					System.out.println("Contact Number: " + (contact != null ? contact : "N/A"));
					System.out.println("Email: " + (email != null ? email : "N/A"));
					System.out.println("Address: " + (address != null ? address : "N/A"));
					System.out.println("City: " + (city != null ? city : "N/A"));
					System.out.println("State: " + (state != null ? state : "N/A"));
					System.out.println("Country: " + (country != null ? country : "N/A"));
					System.out.println("Postal Code: " + (postalCode != null ? postalCode : "N/A"));
					System.out.println("Department: " + (department != null ? department : "N/A"));
					System.out.println("Designation: " + (designation != null ? designation : "N/A"));
					System.out.println("Joining Date: " + (joiningDate != null ? joiningDate.toString() : "N/A"));
					System.out.println("Employment Type: " + (employmentType != null ? employmentType : "N/A"));
					System.out.println("Status: " + (status != null ? status : "N/A"));
					System.out.println("Basic Salary: " + (basicSalary != null ? basicSalary.toString() : "N/A"));
					System.out.println("HRA: " + (hra != null ? hra.toString() : "N/A"));
					System.out.println(
							"Other Allowance: " + (otherAllowance != null ? otherAllowance.toString() : "N/A"));
					System.out.println("Total Salary: " + (totalSalary != null ? totalSalary.toString() : "N/A"));
					System.out.println("Username: " + (username != null ? username : "N/A"));
					System.out.println("Password: " + (password != null ? password : "N/A")); // Show password
					System.out.println("Role: " + (role != null ? role : "N/A"));
					System.out.println("Created At: " + (createdAt != null ? createdAt.toString() : "N/A"));
					System.out.println("Updated At: " + (updatedAt != null ? updatedAt.toString() : "N/A"));
					System.out.println("----------------------------------------------------");
				}

				// If no employee was found, display this message
				if (!rs.isBeforeFirst()) {
					System.out.println("all employee Found .");
				} else {
					System.out.println("! No employee Found .");

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

// add new emp

	public static void AddNewEmp(String firstName, String lastName, String gender, String dob, String contactNumber,
			String email, String address, String city, String state, String country, String postalCode,
			String department, String designation, String joiningDate, String employmentType, String status,
			BigDecimal basicSalary, BigDecimal hra, BigDecimal otherAllowance, BigDecimal totalSalary, String username,
			String password, String role) {
		String sql = "INSERT INTO employees (first_name, last_name, gender, date_of_birth, contact_number, email, address, "
				+ "city, state, country, postal_code, department, designation, joining_date, employment_type, status, "
				+ "basic_salary, hra, other_allowance, username, password, role) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, gender);
			pstmt.setString(4, dob); // Make sure dob is in proper format, e.g., "YYYY-MM-DD"
			pstmt.setString(5, contactNumber);
			pstmt.setString(6, email);
			pstmt.setString(7, address);
			pstmt.setString(8, city);
			pstmt.setString(9, state);
			pstmt.setString(10, country);
			pstmt.setString(11, postalCode);
			pstmt.setString(12, department);
			pstmt.setString(13, designation);
			pstmt.setString(14, joiningDate); // Make sure joiningDate is in proper format, e.g., "YYYY-MM-DD"
			pstmt.setString(15, employmentType);
			pstmt.setString(16, status);
			pstmt.setBigDecimal(17, basicSalary);
			pstmt.setBigDecimal(18, hra);
			pstmt.setBigDecimal(19, otherAllowance);
//			pstmt.setBigDecimal(20, totalSalary); // Ensure totalSalary is calculated before calling
			pstmt.setString(20, username);
			pstmt.setString(21, password);
			pstmt.setString(22, role); // Ensure this is the correct role parameter

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("Employee added successfully.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	search student by id 

	public static void FetchStudentById(int employee_id) {
		String sql = "SELECT * FROM employees WHERE employee_id=?"; // use prepared statement

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Set the employee ID in the query
			stmt.setInt(1, employee_id);

			try (ResultSet rs1 = stmt.executeQuery()) {
				// Check if the result set has any rows
				if (!rs1.next()) {
					System.out.println("No employee found with ID: " + employee_id);
				} else {
					// Iterate through the result set (in case multiple rows, though you expect 1)
					do {
						int id = rs1.getInt("employee_id");
						String firstName = rs1.getString("first_name");
						String lastName = rs1.getString("last_name");
						String gender = rs1.getString("gender");
						Date dob = rs1.getDate("date_of_birth");
						String contact = rs1.getString("contact_number");
						String email = rs1.getString("email");
						String address = rs1.getString("address");
						String city = rs1.getString("city");
						String state = rs1.getString("state");
						String country = rs1.getString("country");
						String postalCode = rs1.getString("postal_code");
						String department = rs1.getString("department");
						String designation = rs1.getString("designation");
						Date joiningDate = rs1.getDate("joining_date");
						String employmentType = rs1.getString("employment_type");
						String status = rs1.getString("status");
						BigDecimal basicSalary = rs1.getBigDecimal("basic_salary");
						BigDecimal hra = rs1.getBigDecimal("hra");
						BigDecimal otherAllowance = rs1.getBigDecimal("other_allowance");
						BigDecimal totalSalary = rs1.getBigDecimal("total_salary");
						String username = rs1.getString("username");
						String password = rs1.getString("password"); // You may not want to display this
						String role = rs1.getString("role");
						Timestamp createdAt = rs1.getTimestamp("created_at");
						Timestamp updatedAt = rs1.getTimestamp("updated_at");

						// Print employee data in name: value format
						System.out.println("Employee ID: " + id);
						System.out.println("First Name: " + firstName);
						System.out.println("Last Name: " + lastName);
						System.out.println("Gender: " + gender);
						System.out.println("Date of Birth: " + (dob != null ? dob.toString() : "N/A"));
						System.out.println("Contact Number: " + (contact != null ? contact : "N/A"));
						System.out.println("Email: " + (email != null ? email : "N/A"));
						System.out.println("Address: " + (address != null ? address : "N/A"));
						System.out.println("City: " + (city != null ? city : "N/A"));
						System.out.println("State: " + (state != null ? state : "N/A"));
						System.out.println("Country: " + (country != null ? country : "N/A"));
						System.out.println("Postal Code: " + (postalCode != null ? postalCode : "N/A"));
						System.out.println("Department: " + (department != null ? department : "N/A"));
						System.out.println("Designation: " + (designation != null ? designation : "N/A"));
						System.out.println("Joining Date: " + (joiningDate != null ? joiningDate.toString() : "N/A"));
						System.out.println("Employment Type: " + (employmentType != null ? employmentType : "N/A"));
						System.out.println("Status: " + (status != null ? status : "N/A"));
						System.out.println("Basic Salary: " + (basicSalary != null ? basicSalary.toString() : "N/A"));
						System.out.println("HRA: " + (hra != null ? hra.toString() : "N/A"));
						System.out.println(
								"Other Allowance: " + (otherAllowance != null ? otherAllowance.toString() : "N/A"));
						System.out.println("Total Salary: " + (totalSalary != null ? totalSalary.toString() : "N/A"));
						System.out.println("Username: " + (username != null ? username : "N/A"));
						// You can decide if you want to print password here, it can be sensitive
						// information
						System.out.println("Password: " + (password != null ? password : "N/A"));
						System.out.println("Role: " + (role != null ? role : "N/A"));
						System.out.println("Created At: " + (createdAt != null ? createdAt.toString() : "N/A"));
						System.out.println("Updated At: " + (updatedAt != null ? updatedAt.toString() : "N/A"));
						System.out.println("----------------------------------------------------");
					} while (rs1.next());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	 update employee data 

	// Make sure this method matches exactly
	public static void updateEmpById(String employeeId, String firstName, String lastName, String gender,
			String dateOfBirth, String contactNumber, String email, String address, String city, String state,
			String country, String postalCode, String department, String designation, String joiningDate,
			String employmentType, String status, double basicSalary, double hra, double otherAllowance,
			String username, String password, String role) {

		String sql = "UPDATE employees SET "
				+ "first_name = ?, last_name = ?, gender = ?, date_of_birth = ?, contact_number = ?, "
				+ "email = ?, address = ?, city = ?, state = ?, country = ?, postal_code = ?, "
				+ "department = ?, designation = ?, joining_date = ?, employment_type = ?, status = ?, "
				+ "basic_salary = ?, hra = ?, other_allowance = ?, username = ?, password = ?, role = ? "
				+ "WHERE employee_id = ?;";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, gender);
			stmt.setDate(4, java.sql.Date.valueOf(dateOfBirth)); // must be yyyy-MM-dd
			stmt.setString(5, contactNumber);
			stmt.setString(6, email);
			stmt.setString(7, address);
			stmt.setString(8, city);
			stmt.setString(9, state);
			stmt.setString(10, country);
			stmt.setString(11, postalCode);
			stmt.setString(12, department);
			stmt.setString(13, designation);
			stmt.setDate(14, java.sql.Date.valueOf(joiningDate));
			stmt.setString(15, employmentType);
			stmt.setString(16, status);
			stmt.setDouble(17, basicSalary);
			stmt.setDouble(18, hra);
			stmt.setDouble(19, otherAllowance);
			stmt.setString(20, username);
			stmt.setString(21, password);
			stmt.setString(22, role);
			stmt.setString(23, employeeId); // This must match 'WHERE employee_id = ?'

			int rowsUpdated = stmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Employee ID " + employeeId + " updated successfully!");
			} else {
				System.out.println("Employee ID " + employeeId + " not found!");
			}

		} catch (SQLException e) {
			System.out.println("Error while updating employee: " + e.getMessage());
		}
	}

	public static void deleteEmployeeById(int employee_id) {
		String sql = "DELETE FROM employees WHERE employee_id = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, employee_id);

			int affectedRows = pstmt.executeUpdate();

			if (affectedRows > 0) {
				System.out.println("Employee with ID " + employee_id + " was deleted successfully.");
			} else {
				System.out.println("No employee found with ID " + employee_id + ". Deletion failed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("An error occurred while deleting employee with ID " + employee_id);
		}
	}

}
