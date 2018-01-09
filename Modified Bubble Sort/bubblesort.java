

public class bubblesort {

    public static void main(String[] args) {

        String[] arr = {"d", "a", "b", "b", "c", "A1"};
        ArrayMethods.printArray(arr);
        sort(arr, 1);
        ArrayMethods.printArray(arr);

    }

    //if direc is 1, sort acending
    //if direc is -1, sort descending
    public static void sort(Comparable[] arr, int direc) {
        for(int i = 0; i < arr.length; i++) {

            for(int x = i; x < arr.length-1; x++) {

                if(direc == 1 ? arr[x].compareTo(arr[x+1]) > 0 : arr[x].compareTo(arr[x+1]) < 0) {
                    Comparable temp = arr[x];
                    arr[x] = arr[x+1];
                    arr[x+1] = temp;

                }
            }
        }
    }
}