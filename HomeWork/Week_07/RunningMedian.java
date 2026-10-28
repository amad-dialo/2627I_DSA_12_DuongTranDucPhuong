package HomeWork.Week_07;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class RunningMedian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int N = scanner.nextInt();

        Queue<Integer> maxPQ = new PriorityQueue<>(N / 2 + 1, Collections.reverseOrder());
        Queue<Integer> minPQ = new PriorityQueue<>(N / 2 + 1);

        for (int i = 0; i < N; i++) {
            int val = scanner.nextInt();
            maxPQ.add(val);

            minPQ.add(maxPQ.poll());

            if (maxPQ.size() < minPQ.size()) {
                maxPQ.add(minPQ.poll());
            }

            if (maxPQ.size() > minPQ.size()) {
                System.out.printf("%.1f\n", (double) maxPQ.peek());
            } else {
                System.out.printf("%.1f\n", ((double) maxPQ.peek() + minPQ.peek()) / 2.0);
            }
        }
        scanner.close();
    }
}
