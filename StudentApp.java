import java.util.*;

public class StudentApp {

    private static List<Student> students;

    public static void main(String[] args) {

        students = FileManager.loadStudents();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private static void addStudent(Scanner sc) {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        Student student = new Student(id, name, age);

        students.add(student);

        FileManager.saveStudent(student);

        System.out.println("Student saved successfully.");
    }

    private static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void searchStudent(Scanner sc) {

        System.out.print("Enter Student ID: ");

        int id = sc.nextInt();

        for (Student s : students) {

            if (s.getId() == id) {
                System.out.println("Student Found");
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student Not Found.");
    }
}