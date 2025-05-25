package Employee;

import java.sql.Date;
import java.util.Scanner;
import DAO.EmployeeDAO;

public class EmployeeMenu {

	public EmployeeMenu() {
	}

	// Updated method to accept username
	public static void EmpshowMenu(Scanner scanner, String empUsername) {
		boolean running = true;

		while (running) {
			System.out.println("\n👨‍💼👔 Employee Menu for " + empUsername + ":");
			System.out.println("1. View Profile");
			System.out.println("2. Update Profile");
			System.out.println("3. View Company Profile");
			System.out.println("0. Logout");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 0:
				running = false;
				System.out.println("👋 Logging out from Employee Section...");
				break;
			case 1:
				System.out.println("\n--- Viewing Profile for " + empUsername + " ---");
				// You can modify this to use empUsername instead of asking for ID if needed
				EmployeeDAO.getEmployeeById(empUsername); // Update this in DAO too
				break;

			// Assuming you're inside a method that handles the menu system (e.g., in a
			// loop)
			case 2:
				System.out.println("\n--- Updating Profile ---");
				Scanner sc = new Scanner(System.in); // You can reuse an existing Scanner if already created

				System.out.print("Enter First Name: ");
				String firstName = sc.nextLine();

				System.out.print("Enter Last Name: ");
				String lastName = sc.nextLine();

				System.out.print("Enter Gender (Male/Female/Other): ");
				String gender = sc.nextLine();

				System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
				String dobInput = sc.nextLine();
				Date dob = null;
				try {
					dob = Date.valueOf(dobInput); // java.sql.Date from yyyy-mm-dd string
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid date format. Setting Date of Birth as null.");
				}

				System.out.print("Enter Contact Number: ");
				String contact = sc.nextLine();

				System.out.print("Enter Email: ");
				String email = sc.nextLine();

				System.out.print("Enter Address: ");
				String address = sc.nextLine();

				System.out.print("Enter City: ");
				String city = sc.nextLine();

				System.out.print("Enter State: ");
				String state = sc.nextLine();

				System.out.print("Enter Country: ");
				String country = sc.nextLine();

				System.out.print("Enter Postal Code: ");
				String postalCode = sc.nextLine();

				// Now call the update method with collected values
				EmployeeDAO.updateEmployeeById(empUsername, firstName, lastName, gender, dob, contact, email, address,
						city, state, country, postalCode);
				break;

//				Show company information all

			case 3:
				System.out.println("\n--- Viewing Company Policies ---");
				EmployeeDAO.CompanyInfoViewer();
				break;
			default:
				System.out.println("❌ Invalid choice. Please try again.");
			}
		}
	}
}
