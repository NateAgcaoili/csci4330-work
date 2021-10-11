package project6;

public class Project6 {
    //Two arrays to be sorted
    public static int arrayOne[] = new int[10];
    public static int arrayTwo[] = new int[10];

    //Original quicksort functions
    public static void quicksort(int[] a){
        int p = 0;
        int r = a.length - 1;
        if (p < r) {
            int q = partition(a, p, r);
            quicksort(a, p, q - 1);
            quicksort(a, q + 1, r);
        }
    }

    public static void quicksortHoarePartition(int[] a){
        int p = 0;
        int r = a.length - 1;
        if (p < r) {
            int q = hoarePartition(a, p, r);
            quicksortHoarePartition(a, p, q);
            quicksortHoarePartition(a, q + 1, r);
        }
    }

    //Overloaded quicksort functions
    public static void quicksort(int[] a, int p, int r){
        if (p < r) {
            int q = partition(a, p, r);
            quicksort(a, p, q - 1);
            quicksort(a, q + 1, r);
        }
    }

    public static void quicksortHoarePartition(int[] a, int p, int r){
        if (p < r) {
            int q = hoarePartition(a, p, r);
            quicksortHoarePartition(a, p, q);
            quicksortHoarePartition(a, q + 1, r);
        }
    }

    //Partition functions
    public static int partition(int[] a, int p, int r){
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++){
            if (a[j] <= x){
                i += 1;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[r];
        a[r] = a[i + 1];
        a[i + 1] = temp;
        return i + 1;
    }

    public static int hoarePartition(int[] a, int p, int r) {
        int x = a[p];
        int i = p - 1;
        int j = r + 1;
        while (true){
            do {
                j--;
            } while (a[j] > x);
            do {
                i++;
            } while (a[i] < x);
            if (i < j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            } else {
                return j;
            }
        }
    }

    //Helper functions
    public static int[] randomlyFillArray(int arraySize){
        int[] a = new int[arraySize];
        for (int i = 0; i < a.length; i++){
            a[i] = (int)(Math.random() * 9) + 1;
        }
        return a;
    }

    static void printArray(int[] a) {
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println();
    }

    //Main method
    public static void main(String[] args){
        //Randomly populating arrays
        arrayOne = randomlyFillArray(10);
        arrayTwo = randomlyFillArray(10);
        //Demonstration
        System.out.print("Array to be sorted using quicksort: ");
        printArray(arrayOne);
        quicksort(arrayOne);
        System.out.print("Array post sorting: ");
        printArray(arrayOne);
        System.out.print("Array to be sorted using quicksort Hoare partition: ");
        printArray(arrayTwo);
        quicksortHoarePartition(arrayTwo);
        System.out.print("Array post sorting: ");
        printArray(arrayTwo);
    }
}
