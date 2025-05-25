package Admin;

import java.math.BigDecimal;
import java.util.Scanner;

import DAO.AdminDAO;

public class AdminMenu {
	public AdminMenu() {
	}

	public static void adminshowMenu(Scanner scanner) {
		boolean running = true;

		while (running) {
			System.out.println("\n🔐 Admin Menu:");
			System.out.println("1. View All Employees");
			System.out.println("2. Add Employee");
			System.out.println("3. Search Employee by ID");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("0. Logout");
			AdminDAO.reindexIDs();
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 0:
				running = false;
				System.out.println("👋 Logging out...");
				break;
			case 1:
				System.out.println("\n--- Viewing All Employees ---");
				// Add logic to view employees here
				AdminDAO.ShowAllEmp();

				break;

			case 2:
				System.out.println("\n--- Adding New Employee ---");

				// Add logic to add new employee here

				System.out.print("Enter First Name: ");
				String firstName = scanner.nextLine();

				System.out.print("Enter Last Name: ");
				String lastName = scanner.nextLine();

				System.out.print("Enter Gender (Male/Female/Other): ");
				String gender = scanner.nextLine();

				System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
				String dob = scanner.nextLine();

				System.out.print("Enter Contact Number: ");
				String contactNumber = scanner.nextLine();

				System.out.print("Enter Email: ");
				String email = scanner.nextLine();

				System.out.print("Enter Address: ");
				String address = scanner.nextLine();

				System.out.print("Enter City: ");
				String city = scanner.nextLine();

				System.out.print("Enter State: ");
				String state = scanner.nextLine();

				System.out.print("Enter Country: ");
				String country = scanner.nextLine();

				System.out.print("Enter Postal Code: ");
				String postalCode = scanner.nextLine();

				System.out.print("Enter Department: ");
				String department = scanner.nextLine();

				System.out.print("Enter Designation: ");
				String designation = scanner.nextLine();

				System.out.print("Enter Joining Date (YYYY-MM-DD): ");
				String joiningDate = scanner.nextLine();

				System.out.print("Enter Employment Type (Permanent/Contract/Intern): ");
				String employmentType = scanner.nextLine();

				System.out.print("Enter Status (Active/Inactive/Resigned/Terminated): ");
				String status = scanner.nextLine();

				System.out.print("Enter Basic Salary: ");
				double basicSalary = scanner.nextDouble();

				System.out.print("Enter HRA: ");
				double hra = scanner.nextDouble();

				System.out.print("Enter Other Allowance: ");
				double otherAllowance = scanner.nextDouble();
				scanner.nextLine(); // consume newline

				// Calculate total salary (you can modify this calculation if needed)
				double totalSalary = basicSalary + hra + otherAllowance;
				System.out.println("totalSalary" + totalSalary);

				System.out.print("Enter Username: ");
				String username = scanner.nextLine();

				System.out.print("Enter Password: ");
				String password = scanner.nextLine();

				System.out.print("Enter Role (admin/employee): ");
				String role = scanner.nextLine();

				// Convert double values to BigDecimal
				BigDecimal basicSalaryBD = BigDecimal.valueOf(basicSalary);
				BigDecimal hraBD = BigDecimal.valueOf(hra);
				BigDecimal otherAllowanceBD = BigDecimal.valueOf(otherAllowance);
				BigDecimal totalSalaryBD = BigDecimal.valueOf(totalSalary);

				// Call the method to add the new employee
				AdminDAO.AddNewEmp(firstName, lastName, gender, dob, contactNumber, email, address, city, state,
						country, postalCode, department, designation, joiningDate, employmentType, status,
						basicSalaryBD, hraBD, otherAllowanceBD, totalSalaryBD, username, password, role);

				break;

			case 3:
				System.out.println("\n--- Searching Employee by ID ---");
				// Add logic to search employee by ID here
				System.out.print("Enter employee ID :");
				int employee_id = scanner.nextInt();
				AdminDAO.FetchStudentById(employee_id);
				break;

			case 4:
				System.out.println("\n--- Updating Employee ---");

				System.out.print("Enter Employee ID to update: ");
				String employeeId = scanner.nextLine();

				// Collecting employee data from the user
				System.out.print("Enter Full Name: ");
				String fullName1 = scanner.nextLine();

				System.out.print("Enter Last Name: ");
				String lastName1 = scanner.nextLine();

				System.out.print("Enter Gender: ");
				String gender1 = scanner.nextLine();

				System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
				String dateOfBirth1 = scanner.nextLine();

				System.out.print("Enter Contact Number: ");
				String contactNumber1 = scanner.nextLine();

				System.out.print("Enter Email: ");
				String email1 = scanner.nextLine();

				System.out.print("Enter Address: ");
				String address1 = scanner.nextLine();

				System.out.print("Enter City: ");
				String city1 = scanner.nextLine();

				System.out.print("Enter State: ");
				String state1 = scanner.nextLine();

				System.out.print("Enter Country: ");
				String country1 = scanner.nextLine();

				System.out.print("Enter Postal Code: ");
				String postalCode1 = scanner.nextLine();

				System.out.print("Enter Department: ");
				String department1 = scanner.nextLine();

				System.out.print("Enter Designation: ");
				String designation1 = scanner.nextLine();

				System.out.print("Enter Joining Date (YYYY-MM-DD): ");
				String joiningDate1 = scanner.nextLine();

				System.out.print("Enter Employment Type ('Permanent','Contract','Intern'): ");
				String employmentType1 = scanner.nextLine();

				System.out.print("Enter Status ('Active','Inactive','Resigned','Terminated'): ");
				String status1 = scanner.nextLine();

				System.out.print("Enter Basic Salary: ");
				double basicSalary1 = scanner.nextDouble();

				System.out.print("Enter HRA: ");
				double hra1 = scanner.nextDouble();

				System.out.print("Enter Other Allowance: ");
				double otherAllowance1 = scanner.nextDouble();
				scanner.nextLine(); // clear buffer after reading double values

				System.out.print("Enter Username: ");
				String username1 = scanner.nextLine();

				System.out.print("Enter Password: ");
				String password1 = scanner.nextLine();

				System.out.print("Enter Role ('admin','employee'): ");
				String role1 = scanner.nextLine();

				// Call the method to update employee
				AdminDAO.updateEmpById(employeeId, fullName1, lastName1, gender1, dateOfBirth1, contactNumber1, email1,
						address1, city1, state1, country1, postalCode1, department1, designation1, joiningDate1,
						employmentType1, status1, basicSalary1, hra1, otherAllowance1, username1, password1, role1);
				break;

			case 5:
				System.out.println("\n--- Deleting Employee ---");
				// Add logic to delete employee here
				System.out.print("Enter Employee ID to Delete: ");
				int employeeId2 = scanner.nextInt();
				
				AdminDAO.deleteEmployeeById(employeeId2);
				break;
			default:
				System.out.println("❌ Invalid choice. Please try again.");
			}
		}
	}
}
