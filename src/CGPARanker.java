import java.util.*;
import java.io.*;

public class CGPARanker {
    public static List<Student> loadStudents(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] data = line.split(", ");
            String name = data[0];
            double cgpa = Double.parseDouble(data[data.length - 1]);
            students.add(new Student(name, cgpa));
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
}
