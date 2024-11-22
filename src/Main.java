import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "cgpa.txt";

            List<Student> students = CGPARanker.loadStudents(filePath);

            CGPARanker.displayRanks(students);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
