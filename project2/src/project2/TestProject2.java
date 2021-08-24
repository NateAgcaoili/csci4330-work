package project2;

import java.util.Arrays;
import java.util.Random;


public class TestProject2 {

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            if ((i+1) % 30 == 0) System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int n = 1000;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        Random r = new Random(1);
        for (int i = 0; i < n; i++) {
            a[i] = b[i] = c[i] = r.nextInt(1000000);
        }
        print(c);
        Arrays.sort(c);
        print(c);
        long t0 = System.nanoTime();
        Project2.insertionSort(a);
        long t1 = System.nanoTime();
//        print(a);
        long t2 = System.nanoTime();
        Project2.mergeSort(b);
        long t3 = System.nanoTime();
//        print(b);
        for (int i = 0; i < n; i++) {
            if (a[i] != c[i]) System.out.println("insertion error:" + i);
            if (b[i] != c[i]) System.out.println("merge error:" + i);
        }
        System.out.println("insertionSort time: " + (t1-t0));
        System.out.println("mergeSort time: " + (t3-t2));
    }

}
