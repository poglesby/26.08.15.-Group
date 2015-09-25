import edu.princeton.cs.algs4.StdOut;

/**
 * Created by poglesbyg on 26/08/15.
 */
public class QuickSortOblig {

    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        // check for empty or null array
        if (values == null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number -1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // get the pivot
        int pivot = numbers[low + (high-low)/2];

        while (i <= j){
            while (numbers[i] < pivot){
                i++;
            }
            while (numbers[i] < pivot){
                j--;
            }
            if (i<= j){
                exchange(i,j);
                i++;
                j--;
            }
        }
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args){

    }
}
