package HomeWork.Week_05;
import java.util.*;
public class QuickSelectMedian {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static int quickSelect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pi = partition(arr, low, high);

            if (pi == k) {
                return arr[pi];
            }
            if (pi > k) {
                return quickSelect(arr, low, pi - 1, k);
            }
            return quickSelect(arr, pi + 1, high, k);
        }
        return -1;
    }
    public static int findMedian(int[] arr) {
        int n = arr.length;
        int k = n / 2;
        return quickSelect(arr, 0, n - 1, k);
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15, 2};
        System.out.println("Phan tu trung vi la: " + findMedian(arr));
    }
}
