package HomeWork.Week_11.Bài_5;

import java.util.*;

public class MissingNumbersSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> missing = new ArrayList<>();
        int i = 0, j = 0;
        while (j < m) {
            if (i < n && a[i] == b[j]) {
                i++;
                j++;
            } else {
                if (missing.isEmpty() || missing.get(missing.size() - 1) != b[j]) {
                    missing.add(b[j]);
                }
                j++;
            }
        }

        for (int idx = 0; idx < missing.size(); idx++) {
            System.out.print(missing.get(idx) + (idx + 1 < missing.size() ? " " : ""));
        }
    }
}