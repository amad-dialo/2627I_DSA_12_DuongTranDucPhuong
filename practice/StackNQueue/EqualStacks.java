package practice;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EqualStacks {
    public static int equalStacks(int[] arr1, int[] arr2, int[] arr3){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        int h1 =0, h2 =0, h3=0;

        for(int i =arr1.length-1;i>=0;i--){
            s1.push(arr1[i]);
            h1+=arr1[i];
        }
        for (int i = arr2.length - 1; i >= 0; i--) {
            s2.push(arr2[i]);
            h2 += arr2[i];
        }
        for (int i = arr3.length - 1; i >= 0; i--) {
            s3.push(arr3[i]);
            h3 += arr3[i];
        }

        while(true){
            if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty()){
                return 0;
            }
            if (h1==h2 && h2==h3){
                return h1;
            }

            if(h1>=h2 && h1>=h3){
                h1-=s1.pop();
            } else if (h2 >= h1 && h2 >= h3) {
            h2 -= s2.pop();
            } else {
            h3 -= s3.pop();
            }
        }
    }
    public static void main(String[] args) {
        int n1 = StdIn.readInt();
        int n2 = StdIn.readInt();
        int n3 = StdIn.readInt();

        int[] arr1 = new int[n1];
        int[] arr2  = new int[n2];
        int[] arr3 = new int[n3];

        for(int i=0;i<n1;i++){
            arr1[i] = StdIn.readInt();
        }
        for(int j=0;j<n2;j++){
            arr2[j]=StdIn.readInt();
        }
        for(int k=0;k<n3;k++){
            arr3[k]=StdIn.readInt();
        }

        StdOut.println(equalStacks(arr1,arr2,arr3));
    }

}
