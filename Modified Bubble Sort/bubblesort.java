import java.util.List;
import java.util.ArrayList;

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

        ArrayList<Comparable> vals = new ArrayList<Comparable>();
        ArrayList<Integer> repeats = new ArrayList<Integer>();

        for(int i = 0; i < arr.length; i++) {
            if(!vals.contains(arr[i])) {
                vals.add(arr[i]);
                repeats.add(1);
            }
            else {
                int index = vals.indexOf(arr[i]);
                repeats.set( index, repeats.get(index) + 1 );
            }
        }

        for(int i = 0; i < vals.size(); i++) {
            System.out.println(vals.get(i) + " is repeated " + repeats.get(i) + " times");
        }
    }
}