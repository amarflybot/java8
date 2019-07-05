package amar.algorithm.sort;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Created by amarendra on 18/09/17.
 */
public class QuickSelectTest {

    public static void main(final String[] args) {

        final int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        final int k = 4;
        System.out.println("Select Element number: " + k);
        final int kthSmallest = findKthSmallest(arr, k);
        final int kthLargest = findKthLargest(arr, k);
        System.out.println("kth smallest : " + kthSmallest);
        System.out.println("kth largest : " + kthLargest);

    }

    public static int findKthLargest(final int[] nums, final int k) {
        final PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (final int i : nums) {
            q.offer(i);

            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

    public static int findKthSmallest(final int[] nums, final int k) {
        final PriorityQueue<Integer> q = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (final int i : nums) {
            q.offer(i);

            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

    private static int quickSelect(final int[] arr, final int startIndex, final int endIndex, final int k) {

        if (startIndex < endIndex) {

            final int pIndex = partition(arr, startIndex, endIndex);

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
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return the partition index of array
     */
    private static int partition(final int[] arr, final int startIndex, final int endIndex) {
        final int pivot = arr[endIndex];
        int pIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] <= pivot) {
                // Swap arr[i] and arr[pIndex] AND increase pIndex++
                final int temp = arr[i];
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
