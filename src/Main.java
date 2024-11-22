import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "cgpa.txt";

            List<Student> students = Ranker.loadStudents(filePath);

            System.out.println("CGPA Rankings:");
            Ranker.displayRanks(students);

            System.out.println("\nSemester 2 Rankings:");
            Ranker.displaySemesterRanks(students, 2);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
