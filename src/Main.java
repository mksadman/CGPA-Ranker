import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "cgpa.txt";

            List<Student> students = Ranker.loadStudents(filePath);

            Ranker.displayRanks(students);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
