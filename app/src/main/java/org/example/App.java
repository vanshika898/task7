
package org.example;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;


public class App {

    public static void main(String[] args) {

        System.out.println("Welcome to Employee DataBase");

        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Database Connected successfully");
            } else {
                System.out.println("Failed to connect to database!");
                return;
            }

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\nChoose an action:");
                System.out.println("1. Add Employees");
                System.out.println("2. View All Employees");
                System.out.println("3. Update Employee Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Try again.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        addEmployees(sc);
                        break;
                    case 2:
                        Operations.getAllEmployee();
                        break;
                    case 3:
                        updateSalary(sc);
                        break;
                    case 4:
                        deleteEmployee(sc);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Failed to connect to database!");
            e.printStackTrace();
        }
    }

    private static void addEmployees(Scanner sc) {
        System.out.print("How many employees you want to add: ");
        int num;
        while (true) {
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num <= 0) {
                    System.out.print("Enter a positive number: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, try again: ");
            }
        }

        for (int i = 1; i <= num; i++) {
            System.out.println("\nEnter details for Employee " + i + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            int salary;
            while (true) {
                System.out.print("Salary: ");
                try {
                    salary = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid number for salary!");
                }
            }

            System.out.print("City: ");
            String city = sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            System.out.print("Designation: ");
            String designation = sc.nextLine();

            long phone;
            while (true) {
                System.out.print("Phone Number: ");
                try {
                    phone = Long.parseLong(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid number for phone!");
                }
            }

            Employee emp = new Employee(name, salary, city, department, designation, phone);

            try {
                Operations.insertEmployee(emp);
            } catch (Exception e) {
                System.out.println("Unexpected exception for employee: " + emp.getName());
                e.printStackTrace();
            }
        }
    }

    private static void updateSalary(Scanner sc) {
        System.out.print("Enter employee name to update salary: ");
        String name = sc.nextLine();

        int salary;
        while (true) {
            System.out.print("Enter new salary: ");
            try {
                salary = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number!");
            }
        }

        Operations.UpdateSalary(name, salary);
    }

    private static void deleteEmployee(Scanner sc) {
        System.out.print("Enter employee name to delete: ");
        String name = sc.nextLine();
        Operations.DeleteEmployee(name);
    }
}
