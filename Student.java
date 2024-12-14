package studentdatabaseapp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Student {
    // Constants
    private static final int COST_OF_COURSE = 600;
    private static final int MIN_GRADE_YEAR = 1;
    private static final int MAX_GRADE_YEAR = 4;
    
    // Class variable to generate unique IDs
    private static int nextId = 1000;

    // Instance variables
    private final String firstName;
    private final String lastName;
    private final int gradeYear;
    private final String studentID;
    private final List<String> courses;
    private int tuitionBalance;

    // Constructor with input validation
    public Student(Scanner scanner) {
        this.firstName = getValidatedInput(scanner, "Enter student first name: ");
        this.lastName = getValidatedInput(scanner, "Enter student last name: ");
        this.gradeYear = getValidatedGradeYear(scanner);
        this.studentID = generateStudentID();
        this.courses = new ArrayList<>();
        this.tuitionBalance = 0;
    }

    // Validate and get input
    private String getValidatedInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    return input;
                }
                System.out.println("Input cannot be empty. Please try again.");
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    // Validate grade year
    private int getValidatedGradeYear(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Select student class level:");
                System.out.println("1 - Freshman");
                System.out.println("2 - Sophomore");
                System.out.println("3 - Junior");
                System.out.println("4 - Senior");
                System.out.print("Enter grade level: ");
                
                int gradeYear = Integer.parseInt(scanner.nextLine());
                
                if (gradeYear >= MIN_GRADE_YEAR && gradeYear <= MAX_GRADE_YEAR) {
                    return gradeYear;
                }
                System.out.println("Invalid grade level. Please enter a number between 1 and 4.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Generate unique student ID
    private String generateStudentID() {
        return gradeYear + String.valueOf(nextId++);
    }

    // Enroll in courses with improved input handling
    public void enroll(Scanner scanner) {
        while (true) {
            System.out.print("Enter course to enroll (or 'Q' to quit): ");
            String course = scanner.nextLine().trim();
            
            if (course.equalsIgnoreCase("Q")) {
                break;
            }
            
            if (!course.isEmpty()) {
                if (!courses.contains(course)) {
                    courses.add(course);
                    tuitionBalance += COST_OF_COURSE;
                    System.out.println("Enrolled in: " + course);
                } else {
                    System.out.println("You are already enrolled in this course.");
                }
            } else {
                System.out.println("Course name cannot be empty.");
            }
        }
    }

    // View balance
    public void viewBalance() {
        System.out.printf("Current balance: $%d%n", tuitionBalance);
    }

    // Pay tuition with improved validation
    public void payTuition(Scanner scanner) {
        while (tuitionBalance > 0) {
            viewBalance();
            try {
                System.out.print("Enter your payment amount: $");
                int payment = Integer.parseInt(scanner.nextLine());
                
                if (payment < 0) {
                    System.out.println("Payment cannot be negative.");
                    continue;
                }
                
                if (payment > tuitionBalance) {
                    System.out.println("Payment exceeds current balance. Adjusting payment.");
                    payment = tuitionBalance;
                }
                
                tuitionBalance -= payment;
                System.out.printf("Thank you for your payment of $%d%n", payment);
                
                if (tuitionBalance == 0) {
                    System.out.println("Tuition balance paid in full!");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid payment amount. Please enter a valid number.");
            }
        }
    }

    // Improved toString method
    @Override
    public String toString() {
        return String.format(
            "Student Details:\n" +
            "Name: %s %s\n" +
            "Grade Level: %s\n" +
            "Student ID: %s\n" +
            "Courses Enrolled: %s\n" +
            "Balance: $%d",
            firstName, lastName, 
            getGradeLevelName(gradeYear), 
            studentID, 
            courses.isEmpty() ? "None" : String.join(", ", courses), 
            tuitionBalance
        );
    }

    // Helper method to convert grade year to readable name
    private String getGradeLevelName(int gradeYear) {
        return switch (gradeYear) {
            case 1 -> "Freshman";
            case 2 -> "Sophomore";
            case 3 -> "Junior";
            case 4 -> "Senior";
            default -> "Unknown";
        };
    }
}
