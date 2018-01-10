
public class BubbleSort {
    public static void sort(Comparable[] arr, Comparison compare) {
        int count = -1;
        while(count != 0) {

            count = 0;

            for(int i = 0; i < arr.length-1; i++) {

                if(compare.compare(arr[i], arr[i+1])) {
                    Comparable temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    count++;
                }
            }
        }
    }
}