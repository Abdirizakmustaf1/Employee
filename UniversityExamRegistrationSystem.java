import java.util.Scanner;

class InvalidRegistrationException extends Exception {
    public InvalidRegistrationException(String message) {
        super(message);
    }
}

public class ExamRegistration {

    public static void registerStudent(
            String studentId,
            String name,
            int age,
            double examMark,
            int numberOfSubjects)
            throws InvalidRegistrationException {

        if (studentId.trim().isEmpty()) {
            throw new InvalidRegistrationException(
                    "Student ID cannot be empty.");
        }

        if (age < 18) {
            throw new InvalidRegistrationException(
                    "Age must be at least 18.");
        }

        if (examMark < 0 || examMark > 100) {
            throw new InvalidRegistrationException(
                    "Exam mark must be between 0 and 100.");
        }

        if (numberOfSubjects < 1) {
            throw new InvalidRegistrationException(
                    "Minimum allowed subjects is 1.");
        }

        if (numberOfSubjects > 5) {
            throw new InvalidRegistrationException(
                    "Maximum allowed subjects is 5.");
        }

        System.out.println("\nRegistration Successful!");
        System.out.println("Student: " + name);
        System.out.println("Registered Subjects: " + numberOfSubjects);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== EXAM REGISTRATION SYSTEM =====");
        System.out.println();

        try {
            System.out.print("Enter Student ID: ");
            String studentId = input.nextLine();

            System.out.print("Enter Student Name: ");
            String name = input.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(input.nextLine());

            System.out.print("Enter Exam Mark: ");
            double examMark = Double.parseDouble(input.nextLine());

            System.out.print("Enter Number of Subjects: ");
            int numberOfSubjects = Integer.parseInt(input.nextLine());

            registerStudent(studentId, name, age, examMark, numberOfSubjects);

        } catch (InvalidRegistrationException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: Please enter valid numbers.");

        } finally {
            System.out.println("\nRegistration attempt completed.");
            input.close();
        }
    }
}