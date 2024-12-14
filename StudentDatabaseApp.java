public class StudentDatabaseApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get number of students with input validation
            int numOfStudents = getValidatedNumberOfStudents(scanner);
            
            // Create and process students
            Student[] students = new Student[numOfStudents];
            
            for (int i = 0; i < numOfStudents; i++) {
                System.out.println("\nEntering details for Student " + (i + 1));
                students[i] = new Student(scanner);
                students[i].enroll(scanner);
                students[i].payTuition(scanner);
            }
            
            // Display student information
            System.out.println("\n--- Student Database ---");
            for (Student student : students) {
                System.out.println(student);
                System.out.println(); // Extra line for readability
            }
        }
    }

    // Validate number of students input
    private static int getValidatedNumberOfStudents(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter number of new students to enroll: ");
                int numOfStudents = Integer.parseInt(scanner.nextLine());
                
                if (numOfStudents > 0) {
                    return numOfStudents;
                }
                System.out.println("Number of students must be positive.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
