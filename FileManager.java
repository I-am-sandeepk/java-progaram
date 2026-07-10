
import java.io.*;
import java.util.*;

    public class FileManager {

        private static final String FILE_NAME = "students.txt";

        public static void saveStudent(Student student) {

            try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
                fw.write(student.toFileString() + "\n");
            } catch (IOException e) {
                System.out.println("Error saving student.");
            }
        }

        public static List<Student> loadStudents() {

            List<Student> students = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

                String line;

                while ((line = br.readLine()) != null) {
                    students.add(Student.fromFileString(line));
                }

            } catch (FileNotFoundException e) {
                // File doesn't exist yet.
            } catch (IOException e) {
                System.out.println("Error reading file.");
            }

            return students;
        }

    }
