package amar.ds;

/**
 * Created by amarendra on 06/01/16.
 */
public class BigONotation {

    private int arraySize;
    private int[] theArray;

    public BigONotation(final int i) {
        arraySize = i;
        theArray = generateRandomArray(i);
    }

    public static void main(final String[] args) {
        final BigONotation bigONotation = new BigONotation(20);
        bigONotation.binarySearch(20);
        final BigONotation bigONotation1 = new BigONotation(40);
        bigONotation1.binarySearch(20);
        final BigONotation bigONotation2 = new BigONotation(80);
        bigONotation2.binarySearch(20);
        final BigONotation bigONotation3 = new BigONotation(300);
        bigONotation3.binarySearch(20);


    }

    private int[] generateRandomArray(final int i) {
        final int[] ints = new int[i];
        for (int j = 0; j < ints.length; j++) {
            ints[j] = (int) (Math.random() * 100);

        }
        return ints;
    }

    public void bubbleSort() {
        final long start = System.currentTimeMillis();

        for (int i = arraySize - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (theArray[j] > theArray[j + 1]) {
                    swapValues(j, j + 1);
                }
            }
        }

        final long end = System.currentTimeMillis();
        System.out.println("Time taken in Bubble sort " + (end - start));

    }

    private void swapValues(int j, int i) {
        j = j + i;
        i = j - i;
        j = j - i;
    }

    public void binarySearch(final int value) {
        final long start = System.currentTimeMillis();

        int lowIndex = 0;
        int highIndex = arraySize - 1;

        int timesThrough = 0;

        while (lowIndex <= highIndex) {
            final int middleIndex = (highIndex + lowIndex) / 2;
            if (theArray[middleIndex] < value) {
                lowIndex = middleIndex + 1;
            } else if (theArray[middleIndex] > value) {
                highIndex = middleIndex + 1;
            } else {
                System.out.println("Found match in index " + middleIndex);
                lowIndex = highIndex + 1;
            }
            timesThrough++;
        }

        final long end = System.currentTimeMillis();
        System.out.println("Time taken in binary Search " + (end - start));
        System.out.println("Times Through " + timesThrough);
    }

}
