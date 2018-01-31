package amar.algorithm.sort;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Created by amarendra on 18/09/17.
 */
public class QuickSelectTest {

    public static void main(String[] args) {

        int[] arr = {7,2,1,6,8,5,3,4};
        int k = 4;
        System.out.println("Select Element number: "+ k);
        int kthSmallest = findKthSmallest(arr, k);
        int kthLargest = findKthLargest(arr, k);
        System.out.println("kth smallest : "+ kthSmallest);
        System.out.println("kth largest : "+ kthLargest);

    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }

    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k, Comparator.reverseOrder());
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }

    private static int quickSelect(int[] arr, int startIndex, int endIndex, final int k) {

        if (startIndex < endIndex) {

            int pIndex = partition(arr, startIndex, endIndex);

            if (k == pIndex) {
                return arr[k];
            }

            //Sort left
            quickSelect(arr, startIndex, pIndex - 1, k);

            //Sort Right
            //quickSelect(arr, pIndex + 1, endIndex, k);
        }
        return 0;
    }

    /**
     * Its job is to partition the array
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return the partition index of array
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        int pIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] <= pivot){
                // Swap arr[i] and arr[pIndex] AND increase pIndex++
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        // Swap the element at partition index and pivot
        arr[endIndex] = arr[pIndex];
        arr[pIndex] = pivot;
        return pIndex;
    }
}
