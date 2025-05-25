package Main;

import java.util.Scanner;

import Admin.AdminMenu;
import DAO.UserDAO;
import DB.DBConnection;
import Employee.EmployeeMenu;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		new DBConnection();
		DBConnection.getConnection();
		new AdminMenu();
		new EmployeeMenu();

		boolean running = true;

		while (running) {
			System.out.println("\n🖥️ Welcome to the Employee Management System!");
			System.out.println("💼 Login as:");
			System.out.println("1. 👨‍💼 Admin");
			System.out.println("2. 👩‍💼 Employee");
			System.out.println("0. 🚪 Exit");
			System.out.print("Enter your choice: ");
			int userChoice = scanner.nextInt();
			scanner.nextLine();
			switch (userChoice) {
			case 0:
				running = false;
				System.out.println("👋 Thank you for visiting the Console Employee Management System! Exiting... 🚪");
				break;
			case 1:
				System.out.print("🧑‍💻 Admin Username: ");
				String adminUsername = scanner.nextLine();
				System.out.print("🔑 Password: ");
				String adminPassword = scanner.nextLine();
				if (UserDAO.validateLogin(adminUsername, adminPassword, "admin")) {
					System.out.println("✅ Admin login successful!");
					AdminMenu.adminshowMenu(scanner);
				} else {
					System.out.println("❌ Invalid admin credentials! Please try again.");
				}
				break;
			case 2:
				System.out.print("👨‍💻 Employee Username: ");
				String empUsername = scanner.nextLine();
				System.out.print("🔑 Password: ");
				String empPassword = scanner.nextLine();
				if (UserDAO.validateLogin(empUsername, empPassword, "employee")) {
					System.out.println("✅ Employee login successful!");
					EmployeeMenu.EmpshowMenu(scanner, empUsername);
				} else {
					System.out.println("❌ Invalid employee credentials! Please try again.");
				}
				break;
			default:
				System.out.println("❌ Invalid choice! Please choose a valid option.");
			}
		}

		scanner.close();
	}
}
