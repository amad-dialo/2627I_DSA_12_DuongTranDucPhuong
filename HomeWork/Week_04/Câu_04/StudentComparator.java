package src.Week_04.Câu_04;

import java.util.*;

public class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.getCpa() != s2.getCpa()) {
            return Double.compare(s2.getCpa(), s1.getCpa());
        }
        int nameCompare = s1.getName().compareTo(s2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        return Integer.compare(s1.getId(), s2.getId());
    }
}
