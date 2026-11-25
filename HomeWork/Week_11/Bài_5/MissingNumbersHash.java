package HomeWork.Week_11.Bài_5;
import java.util.*;

public class MissingNumbersHash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            freq.put(x, freq.getOrDefault(x, 0) - 1);
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        List<Integer> missing = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 0) {
                missing.add(entry.getKey());
            }
        }

        Collections.sort(missing);
        for (int i = 0; i < missing.size(); i++) {
            System.out.print(missing.get(i) + (i + 1 < missing.size() ? " " : ""));
        }
    }
}
