package project2;

public class Project2 {

    public static void insertionSort(int[] a) {
        int j, key;
        for(int i = 1; i < a.length; i++) {
            key = a[i];
            j = i - 1;
            while( (j >= 0) && (a[j] > key)) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

    public static void mergeSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    //Merge sort helper functions
    public static void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        int leftArraySize = middleIndex - leftIndex + 1;
        int rightArraySize = rightIndex - middleIndex;
        int[] leftArray = new int[leftArraySize + 1];
        int[] rightArray = new int[rightArraySize + 1];

        leftArray[leftArraySize] = Integer.MAX_VALUE;
        rightArray[rightArraySize] = Integer.MAX_VALUE;

        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = array[leftIndex + i];
        }

        for (int i = 0; i < rightArraySize; i++) {
            rightArray[i] = array[ i + middleIndex + 1];
        }

        int j = 0, k = 0;

        for (int i = leftIndex; i <= rightIndex; i++) {
            if (leftArray[j] <= rightArray[k]) {
                array[i] = leftArray[j];
                j++;
            } else {
                array[i] = rightArray[k];
                k++;
            }
        }
    }

    public static void sort(int[] array, int leftIndex, int rightIndex) {
        if(leftIndex < rightIndex){
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            sort(array, leftIndex, middleIndex);
            sort(array, middleIndex + 1, rightIndex);
            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }
}
