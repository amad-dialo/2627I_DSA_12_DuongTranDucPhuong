package src.Week_04.Câu_04;
import java.util.*;

public class Main_4 {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        // Thêm dữ liệu mẫu (thường gặp trong bài tập này)
        studentList.add(new Student(33, "Harry", 9.8));
        studentList.add(new Student(85, "Hermionie", 10.0));
        studentList.add(new Student(56, "Ron", 7.5));
        studentList.add(new Student(19, "Luna", 8.0));
        studentList.add(new Student(22, "Neville", 8.5));

        Collections.sort(studentList, new StudentComparator());
        for (Student st : studentList) {
            System.out.println(st.getName());
        }
    }
}
