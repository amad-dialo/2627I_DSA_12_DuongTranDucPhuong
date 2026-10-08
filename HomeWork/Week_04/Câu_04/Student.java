package src.Week_04.Câu_04;

public class Student {
    private int id;
    private String name;
    private double cpa;
    public Student(int id, String name, double cpa) {
        this.id = id;
        this.name = name;
        this.cpa = cpa;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCpa() {
        return cpa;
    }
}
