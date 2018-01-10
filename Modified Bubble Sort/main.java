public class main {

    public static void main(String[] args) {

        String[] arr = {"d", "a", "b", "b", "c", "z"};
        System.out.println();

        Comparison ascending = (a, b) -> a.compareTo(b) > 0;
        Comparison descending = (a, b) -> a.compareTo(b) < 0;

        BubbleSort.sort(arr, ascending);


        for(String a : arr) System.out.print(a + " ");
    }
}