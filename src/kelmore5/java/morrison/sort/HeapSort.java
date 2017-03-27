package kelmore5.java.morrison.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/19/17
 */
public class HeapSort {
    private static double[] A; //The array to be sorted
    private static double[] B; //A copy of A, to sort with the quadratic sorting algorithm

    private static void generateData(double[] A){//Fills array A[] with random values.
        Random r = new Random();
        for (int i=0; i<A.length; i++) A[i]= r.nextDouble();
    }

    /**
     * Heap sort
     * Sorts an array by first changing the array into a heap
     * And then swapping children of the "tree" until the array is sorted
     *
     * @param Arr The array to be sorted
     */
    private static void heapSort(double[] Arr){
        int newIndex = (Arr.length-2)/2;

        while(newIndex >= 0) {
            maintainHeap(Arr, newIndex, Arr.length-1);
            newIndex -= 1;
        }

        int end = Arr.length-1;
        while(end > 0) {
            swap(Arr, end, 0);
            end--;
            maintainHeap(Arr, 0, end);
        }
    }//You have to write this

    /**
     * Swaps the elements of a heap to push the largest child (in a "tree") to the top of the tree
     *
     * @param Arr The array to push elements to the top of
     * @param start The start index of swapping
     * @param end The end index of swapping
     */
    private static void maintainHeap(double[] Arr, int start, int end) {
        int parent = start;

        while(parent *2 +1 <= end) {
            int child = parent*2+1;
            int swap = parent;

            if(Arr[swap] < Arr[child]) {
                swap = child;
            }

            if(child+1 <= end && Arr[swap] < Arr[child+1]) {
                swap = child+1;
            }

            if(swap != parent) {
                swap(Arr, parent, swap);
                parent = swap;
            }
            else {
                return;
            }
        }
    }

    /**
     * Swaps two elements in an array
     *
     * @param Arr The array to make the swap in
     * @param first The location of the first value
     * @param second The location of the second value
     */
    private static void swap(double[] Arr, int first, int second) {
        double temp = Arr[first];
        Arr[first] = Arr[second];
        Arr[second] = temp;
    }

    /**
     * Implementation of the quick sort algorithm
     * @param Arr The array to be sorted
     */
    private static void quadSort(double[] Arr){
        quadSortHelper(Arr, 0, Arr.length-1);
    }//Implement some quadratic run-time sorting algo

    /**
     * Makes swaps in the array
     * Starts by choosing a pivot (will always be the center for this implementation)
     * Then makes swaps so all the elements less than the pivot are to the left of it in the array
     * and all the elements greater than the pivot are to the right of it
     * Calls itself again to sort from the start to the pivot
     * and the pivot to the end
     * Keeps going until start is greater than end
     *
     * @param Arr The array to be sorted
     * @param start The start of sorting
     * @param end The end of sorting
     */
    private static void quadSortHelper(double[] Arr, int start, int end) {
        if(start < end) {
            int pivot = start + (end-start)/2;
            pivot = quadSortHelper2(Arr, start, end, pivot);
            quadSortHelper(Arr, start, pivot-1);
            quadSortHelper(Arr, pivot+1, end);
        }
    }

    /**
     * Makes swaps in an array so all the elements less than the pivot are to the left of it in the array
     * and all the elements greater than the pivot are to the right of it in the array
     *
     * @param Arr The array to be sorted
     * @param start The start index of sorting
     * @param end The end index of sorting
     * @param pivot The pivot
     * @return The new pivot
     */
    private static int quadSortHelper2(double[] Arr, int start, int end, int pivot) {
        swap(Arr, end, pivot);
        int index = start;
        for(int i = start; i < end; i++) {
            if(Arr[i] < Arr[end]) {
                swap(Arr, i , index);
                index += 1;
            }
        }
        swap(Arr, index, end);
        return index;
    }

    /**
     * Simple method for determining if an array is sorted
     *
     * @param Arr The array to check
     * @return True if the array is sorted, false otherwise
     */
    @SuppressWarnings("unused")
    private static boolean checkSort(double[] Arr) {
        for(int i = 0; i < Arr.length-1; i++) {
            if(Arr[i] > Arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    private static long[] times() {
        long time1 = System.nanoTime();//Records the current time (in nano-seconds)
        heapSort(A);
        long time2= System.nanoTime();
        quadSort(B);
        long time3 = System.nanoTime();
        System.out.printf("Heapsort took %6d ms while quadSort took %6d ms\n",
                (time2-time1)/1000,
                (time3-time2)/1000);

        return new long[] {(time2-time1)/1000, (time3-time2)/1000};
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[] {0, 1, 10, 100, 10000, 1000000, 10000000};
        ArrayList<long[]> random = new ArrayList<>();
        ArrayList<long[]> sorted = new ArrayList<>();
        ArrayList<long[]> reverse = new ArrayList<>();

        for(int test: a) {
            for(int i = 0; i < 5; i++) {
                A = new double[test];
                generateData(A);
                B= A.clone();

                random.add(times());

                Arrays.sort(A);
                Arrays.sort(B);

                sorted.add(times());

                Arrays.sort(A);
                Arrays.sort(B);

                for(int j = 0; j < A.length/2; j++) {
                    swap(A, j, A.length-1-j);
                    swap(B, j, B.length-1-j);
                }

                reverse.add(times());
            }
        }

        for(long[] test: random) {
            System.out.println(test[0] + " " + test[1]);
        }

        for(long[] test: sorted) {
            System.out.println(test[0] + " " + test[1]);
        }

        for(long[] test: reverse) {
            System.out.println(test[0] + " " + test[1]);
        }
    }
}
