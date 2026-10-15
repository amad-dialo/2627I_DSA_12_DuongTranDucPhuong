package HomeWork.Week_05;
import java.util.*;
public class QuickSortLomuto {
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Lomuto
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

        printArray(arr);

        return i;
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 8, 2, 7, 5};
        System.out.print("Mang ban dau: ");
        printArray(arr);

        System.out.println("\nCac buoc partition:");
        quickSort(arr, 0, arr.length - 1);
    }
}
