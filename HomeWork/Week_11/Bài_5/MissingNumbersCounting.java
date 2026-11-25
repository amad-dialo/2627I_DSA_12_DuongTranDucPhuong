package HomeWork.Week_11.Bài_5;

import java.util.*;

public class MissingNumbersCounting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            if (b[i] < minVal) {
                minVal = b[i];
            }
        }

        int[] count = new int[101];
        for (int x : b) {
            count[x - minVal]++;
        }
        for (int x : a) {
            count[x - minVal]--;
        }

        boolean first = true;
        for (int i = 0; i <= 100; i++) {
            if (count[i] > 0) {
                if (!first) {
                    System.out.print(" ");
                }
                System.out.print(minVal + i);
                first = false;
            }
        }
    }
}