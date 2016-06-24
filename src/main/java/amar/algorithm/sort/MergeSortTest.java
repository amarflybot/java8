package amar.algorithm.sort;

/**
 * Created by amarendra on 24/06/16.
 */
public class MergeSortTest {

    public static void main(String[] args) {

        //1D
        int[] list = {3,8,4,1,2,9,5,6};

        System.out.println("Before sorting");
        printList(list);
        System.out.println("After sorting");
        mergeSort(list);
        printList(list);

        //2D

    }

    public static void mergeSort2D(int [][] grid){
        for (int i = 0; i < grid.length; i++) {
            int[] list = grid[i];
            mergeSort(list);
            grid[i] = list;
        }
    }

    public static void mergeSort(int[] list){
        int size = list.length;
        if(size < 2){
            return;
        }
        int mid = size/2;
        int[] left = new int[mid];
        int[] right = new int[mid];
        for(int i=0; i< mid; i++){
            left[i] = list[i];
        }
        for(int i=0; i<size-mid; i++){
            right[i] = list[mid+i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, list);
    }

    private static void merge(int[] left, int[] right, int[] list) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0,j =0, k =0;

        while (i < leftSize && j < rightSize){
            if(left[i] <= right[j]){
                list[k] = left[i];
                i++;
            }
            else {
                list[k] = right[j];
                j++;
            }
            k++;
        }

        while (i< leftSize){
            list[k] = left[i];
            k++; i++;
        }
        while (j<rightSize){
            list[k] = right[j];
            k++; j++;
        }
    }

    public static void printList(int[] list){
        for(int i=0; i<list.length;i++){
            System.out.print(list[i] + " ");
        }
    }

    public static int[][] generateGrid(int in, int jn){
        int[][] grid = new int[in][jn];
        for (int i = 0; i < in; i++) {
            for (int j = 0; j < jn; j++) {
                grid[i][j] = (int)(Math.random()*10);
            }
        }
        return grid;
    }
}
