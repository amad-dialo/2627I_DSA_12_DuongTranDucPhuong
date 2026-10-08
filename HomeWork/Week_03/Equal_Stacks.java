package src.Week_03;
import java.util.*;

public class Equal_Stacks {
        public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
            int sum1 = 0, sum2 = 0, sum3 = 0;

            // tổng chiều cao 3 ngăn xếp
            for (int h : h1) sum1 += h;
            for (int h : h2) sum2 += h;
            for (int h : h3) sum3 += h;

            int i = 0, j = 0, k = 0;

            // Chạy đến khi 3 ngăn xếp có tổng chiều cao bằng nhau
            while (!(sum1 == sum2 && sum2 == sum3)) {
                // Tìm ngăn xếp cao nhất và loại bỏ phần tử trên cùng
                if (sum1 >= sum2 && sum1 >= sum3) {
                    sum1 -= h1.get(i++);
                } else if (sum2 >= sum1 && sum2 >= sum3) {
                    sum2 -= h2.get(j++);
                } else if (sum3 >= sum1 && sum3 >= sum2) {
                    sum3 -= h3.get(k++);
                }
            }

            // sum1 = sum2 = sum3, trả về kết quả
            return sum1;
        }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc số lượng khối 3 ngăn xếp
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        // Đọc xếp 1
        List<Integer> h1 = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            h1.add(scanner.nextInt());
        }

        // Đọc ngăn xếp 2
        List<Integer> h2 = new ArrayList<>();
        for (int i = 0; i < n2; i++) {
            h2.add(scanner.nextInt());
        }

        // Đọc ngăn xếp 3
        List<Integer> h3 = new ArrayList<>();
        for (int i = 0; i < n3; i++) {
            h3.add(scanner.nextInt());
        }

        int result = equalStacks(h1, h2, h3);
        System.out.println(result);

        scanner.close();
    }
    }

