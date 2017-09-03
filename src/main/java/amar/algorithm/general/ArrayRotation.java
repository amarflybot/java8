package amar.algorithm.general;

import java.util.Arrays;

/**
 * Created by amarendra on 02/09/17.
 * Program for array rotation
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 */
public class ArrayRotation {

    public static void main(String[] args) {

        final int rotationNumber = 2;

        int[] array = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(Arrays.toString(array));

        rotateOneByOne(rotationNumber, array);

        System.out.println(Arrays.toString(array));
    }

    private static void rotateOneByOne(final int rotationNumber, final int[] array) {

        for (int i = 0; i < rotationNumber; i++) {
            int temp = array[0];
            for (int j = 0; j < array.length -1; j++) {
                array[j] = array[j+1];
            }
            array[array.length - 1] = temp;
        }
    }

    public static void rotateByTempArray(final int rotationNumber, final int[] array) {
        int[] temp = Arrays.copyOf(array, rotationNumber);

        for (int i = 0; i < array.length - rotationNumber; i++) {

            array[i] = array[i+ rotationNumber];
        }

        int startPoint = array.length - temp.length;

        for (int i = 0; i < temp.length; i++) {
            array[startPoint] = temp[i];
            startPoint++;
        }
    }
}
