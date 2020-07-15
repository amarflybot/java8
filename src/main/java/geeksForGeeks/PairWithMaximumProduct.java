package geeksForGeeks;

public class PairWithMaximumProduct {

    public static void main(String[] args) {
        Integer arr[] = {1, 4, 3, 6, 7, 0};
        Integer maxProduct = Integer.MIN_VALUE;
        int x = 0,y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j=0 ;j < arr.length && i != j; j++) {
                int product = arr[i] * arr[j];
                if ( product > maxProduct) {
                    x = arr[i];
                    y = arr[j];
                    maxProduct = product;
                }
            }
        }
        System.out.println(x + " "+ y);
    }
}
