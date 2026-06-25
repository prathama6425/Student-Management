import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        // ---------------- LOGIN ----------------
        System.out.println("===== LOGIN PAGE =====");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (!username.equals("admin") || !password.equals("1234")) {
            System.out.println("Invalid Credentials. Access Denied!");
            return;
        }

        System.out.println("\nLogin Successful! Welcome Admin.");

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // -------- ADD STUDENT --------
                case 1:
                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();

                    sc.nextLine(); // consume newline

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    students.add(new Student(rollNo, name, marks));
                    System.out.println("Student Added Successfully!");
                    break;

                // -------- VIEW STUDENTS --------
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (Student s : students) {
                            System.out.println("Roll No: " + s.rollNo +
                                    ", Name: " + s.name +
                                    ", Marks: " + s.marks);
                        }
                    }
                    break;

                // -------- SEARCH STUDENT --------
                case 3:
                    System.out.print("Enter Roll No to Search: ");
                    int searchRoll = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.rollNo == searchRoll) {
                            System.out.println("Student Found!");
                            System.out.println("Roll No: " + s.rollNo);
                            System.out.println("Name: " + s.name);
                            System.out.println("Marks: " + s.marks);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                // -------- UPDATE STUDENT --------
                case 4:
                    System.out.print("Enter Roll No to Update: ");
                    int updateRoll = sc.nextInt();

                    boolean updated = false;

                    for (Student s : students) {
                        if (s.rollNo == updateRoll) {
                            sc.nextLine(); // consume newline

                            System.out.print("Enter New Name: ");
                            s.name = sc.nextLine();

                            System.out.print("Enter New Marks: ");
                            s.marks = sc.nextInt();

                            System.out.println("Student Updated Successfully!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Student not found.");
                    }
                    break;

                // -------- DELETE STUDENT --------
                case 5:
                    System.out.print("Enter Roll No to Delete: ");
                    int deleteRoll = sc.nextInt();

                    boolean removed = students.removeIf(s -> s.rollNo == deleteRoll);

                    if (removed) {
                        System.out.println("Student Deleted Successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                // -------- EXIT --------
                case 6:
                    System.out.println("Exiting System... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
