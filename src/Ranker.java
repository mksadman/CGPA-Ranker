import java.util.*;
import java.io.*;

public class Ranker {
    public static List<Student> loadStudents(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine(); // Skip header
        while ((line = br.readLine()) != null) {
            String[] data = line.split(", ");
            String name = data[0];
            double[] semesters = new double[8];
            for (int i = 1; i <= 8; i++) {
                semesters[i - 1] = data[i].isEmpty() ? 0 : Double.parseDouble(data[i]);
            }
            double cgpa = Double.parseDouble(data[9]);
            students.add(new Student(name, semesters, cgpa));
        }
        br.close();
        return students;
    }

    public static void displayRanks(List<Student> students) {
        students.sort((s1, s2) -> Double.compare(s2.cgpa, s1.cgpa));
        System.out.println("Rank\tName\tCGPA");
        int rank = 1;
        for (Student student : students) {
            System.out.printf("%d\t%s\t%.2f\n", rank++, student.name, student.cgpa);
        }
    }

    public static void displaySemesterRanks(List<Student> students, int semesterIndex) {
        students.sort((s1, s2) -> Double.compare(s2.semesters[semesterIndex - 1], s1.semesters[semesterIndex - 1]));
        System.out.println("Rank\tName\tGPA (Sem " + semesterIndex + ")");
        int rank = 1;
        for (Student student : students) {
            double gpa = student.semesters[semesterIndex - 1];
            if (gpa > 0) {
                System.out.printf("%d\t%s\t%.2f\n", rank++, student.name, gpa);
            }
        }
    }
}
