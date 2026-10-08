package src.Week_04.Câu_05;

public class InsertionSort_Part2 {
    public static void insertionSortPart2(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int key = ar[i]; // Phần tử cần được chèn
            int j = i - 1;

            while (j >= 0 && ar[j] > key) {
                ar[j + 1] = ar[j];
                j--;
            }

            ar[j + 1] = key;

            printArray(ar);
        }
    }

    public static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] ar = {3, 4, 7, 5, 6, 2, 1};
        insertionSortPart2(ar);
    }
}
