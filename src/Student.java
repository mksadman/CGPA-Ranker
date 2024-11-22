public class Student {
    String name;
    double[] semesters = new double[8];
    double cgpa;

    public Student(String name, double[] semesters, double cgpa) {
        this.name = name;
        this.semesters = semesters;
        this.cgpa = cgpa;
    }
}
