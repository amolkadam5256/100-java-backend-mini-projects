package DAO;

import java.math.BigDecimal;
import java.sql.*;
import DB.DBConnection;

public class EmployeeDAO {

//	 Select data all current user uisng empUsername 

	public static void getEmployeeById(String empUsername) {
		String sql = "SELECT * FROM employees WHERE username = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Set the employee ID parameter
			stmt.setString(1, empUsername);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
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
					System.out.println("Role: " + (role != null ? role : "N/A"));
					System.out.println("Created At: " + (createdAt != null ? createdAt.toString() : "N/A"));
					System.out.println("Updated At: " + (updatedAt != null ? updatedAt.toString() : "N/A"));
					System.out.println("----------------------------------------------------");
				} else {
					System.out.println("❌ No employee found with ID: " + empUsername);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//     SQL query to update employee details (contact, email, address) based on username

	public static void updateEmployeeById(String empUsername, String firstName, String lastName, String gender,
			Date dob, String contact, String email, String address, String city, String state, String country,
			String postalCode) {
		String sql = "UPDATE employees SET first_name = ?, last_name = ?, gender = ?, date_of_birth = ?, "
				+ "contact_number = ?, email = ?, address = ?, city = ?, state = ?, country = ?, postal_code = ? "
				+ "WHERE username = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
// Set the values in the prepared statement
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, gender);
			stmt.setDate(4, dob);
			stmt.setString(5, contact);
			stmt.setString(6, email);
			stmt.setString(7, address);
			stmt.setString(8, city);
			stmt.setString(9, state);
			stmt.setString(10, country);
			stmt.setString(11, postalCode);
			stmt.setString(12, empUsername); // Employee username for the condition

// Execute the update query
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Employee information updated successfully!");

// Print updated employee data in name: value format
				System.out.println("First Name: " + (firstName != null ? firstName : "N/A"));
				System.out.println("Last Name: " + (lastName != null ? lastName : "N/A"));
				System.out.println("Gender: " + (gender != null ? gender : "N/A"));
				System.out.println("Date of Birth: " + (dob != null ? dob.toString() : "N/A"));
				System.out.println("Contact Number: " + (contact != null ? contact : "N/A"));
				System.out.println("Email: " + (email != null ? email : "N/A"));
				System.out.println("Address: " + (address != null ? address : "N/A"));
				System.out.println("City: " + (city != null ? city : "N/A"));
				System.out.println("State: " + (state != null ? state : "N/A"));
				System.out.println("Country: " + (country != null ? country : "N/A"));
				System.out.println("Postal Code: " + (postalCode != null ? postalCode : "N/A"));
			} else {
				System.out.println("❌ No employee found with username: " + empUsername);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	 View Company All INformation

		// Method to fetch and display company information from the companyinfo table
		public static void CompanyInfoViewer() {
			String sql = "SELECT * FROM companyinfo"; // SQL query to fetch all data from companyinfo table

			try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

				// Execute query and get results
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						// Retrieve the company data from the result set
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String about = rs.getString("about");
						String mission = rs.getString("mission");
						String vision = rs.getString("vision");
						String founder = rs.getString("founder");
						int yearEstablished = rs.getInt("year_established");
						String headquarters = rs.getString("headquarters");
						String contactEmail = rs.getString("contact_email");
						String phoneNumber = rs.getString("phone_number");
						String website = rs.getString("website");
						int noOfEmployees = rs.getInt("no_of_employees");
						String annualRevenue = rs.getString("annual_revenue");
						String workingHours = rs.getString("working_hours");
						String companyValues = rs.getString("company_values");
						String socialMediaLinks = rs.getString("social_media_links");

						// Print company data in name: value format
						System.out.println("ID: " + id);
						System.out.println("Name: " + (name != null ? name : "N/A"));
						System.out.println("About: " + (about != null ? about : "N/A"));
						System.out.println("Mission: " + (mission != null ? mission : "N/A"));
						System.out.println("Vision: " + (vision != null ? vision : "N/A"));
						System.out.println("Founder: " + (founder != null ? founder : "N/A"));
						System.out.println("Year Established: " + (yearEstablished != 0 ? yearEstablished : "N/A"));
						System.out.println("Headquarters: " + (headquarters != null ? headquarters : "N/A"));
						System.out.println("Contact Email: " + (contactEmail != null ? contactEmail : "N/A"));
						System.out.println("Phone Number: " + (phoneNumber != null ? phoneNumber : "N/A"));
						System.out.println("Website: " + (website != null ? website : "N/A"));
						System.out.println("No of Employees: " + (noOfEmployees != 0 ? noOfEmployees : "N/A"));
						System.out.println("Annual Revenue: " + (annualRevenue != null ? annualRevenue : "N/A"));
						System.out.println("Working Hours: " + (workingHours != null ? workingHours : "N/A"));
						System.out.println("Company Values: " + (companyValues != null ? companyValues : "N/A"));
						System.out.println(
								"Social Media Links: " + (socialMediaLinks != null ? socialMediaLinks : "N/A"));
						System.out.println("----------------------------------------------------");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}