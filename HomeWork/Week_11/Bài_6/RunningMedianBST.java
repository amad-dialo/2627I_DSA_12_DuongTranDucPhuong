package HomeWork.Week_11.Bài_6;

import java.util.*;

public class RunningMedianBST {
    static class Node implements Comparable<Node> {
        int val;
        int idx;

        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node other) {
            if (this.val != other.val) {
                return Integer.compare(this.val, other.val);
            }
            return Integer.compare(this.idx, other.idx);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeSet<Node> set = new TreeSet<>();
        Node mid = null;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            Node curr = new Node(x, i);
            set.add(curr);

            int size = i + 1;
            if (size == 1) {
                mid = curr;
            } else if (size % 2 == 0) {
                if (curr.compareTo(mid) < 0) {
                    mid = set.lower(mid);
                }
            } else {
                if (curr.compareTo(mid) > 0) {
                    mid = set.higher(mid);
                }
            }

            double median;
            if (size % 2 == 1) {
                median = mid.val;
            } else {
                Node nextMid = set.higher(mid);
                median = (mid.val + nextMid.val) / 2.0;
            }

            System.out.printf("%.1f%n", median);
        }
    }
}
