package _02student_management_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n✨ Student Management System ✨");
            System.out.println("1. Display All Students");
            System.out.println("2. View Student by ID");
            System.out.println("3. Add New Student");
            System.out.println("4. Update Student Info");
            System.out.println("5. Delete Student by ID");
            System.out.println("6. Exit");
            System.out.print("👉 Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> StudentDAO.viewAllStudents();
                case 2 -> {
                    System.out.print("🔍 Enter Student ID: ");
                    int id = sc.nextInt();
                    StudentDAO.viewStudentById(id);
                }
                case 3 -> {
                    System.out.print("🧑 Name: ");
                    String name = sc.nextLine();
                    System.out.print("📚 Course: ");
                    String course = sc.nextLine();
                    System.out.print("🔢 Age: ");
                    int age = sc.nextInt();
                    StudentDAO.addStudent(new Student(name, course, age));
                }
                case 4 -> {
                    System.out.print("🆔 Enter ID to Update: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("🧑 New Name: ");
                    String name = sc.nextLine();
                    System.out.print("📚 New Course: ");
                    String course = sc.nextLine();
                    System.out.print("🔢 New Age: ");
                    int age = sc.nextInt();
                    StudentDAO.updateStudent(new Student(id, name, course, age));
                }
                case 5 -> {
                    System.out.print("🆔 Enter ID to Delete: ");
                    int id = sc.nextInt();
                    StudentDAO.deleteStudent(id);
                }
                case 6 -> System.out.println("👋 Exiting. Thank you!");
                default -> System.out.println("⚠️ Invalid choice. Try again.");
            }

        } while (choice != 6);
    }
}
