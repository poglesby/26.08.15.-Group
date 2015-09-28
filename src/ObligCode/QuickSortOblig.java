import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by poglesbyg on 26/08/15.
 */
public class QuickSortOblig {
    private static ArrayList<Integer> a;

    public static ArrayList<Integer> readFile(String file_path) throws IOException {
        Scanner s = new Scanner(new File(file_path));
        ArrayList<Integer> list = new ArrayList<>();
        while (s.hasNext()){
            list.add(Integer.valueOf(s.next()));
        }
        s.close();

        return list;
    }

    public static void main(String[] args) throws IOException {

        QuickSortOblig app = new QuickSortOblig();

        //Generate an integer array of length 7
        List<Integer> input = (readFile("data.txt"));
        List<Integer> sortedInput = (readFile("sortedData.txt"));

        Stopwatch stopwatchR = new Stopwatch();
        Stopwatch stopwatchS = new Stopwatch();

        //Before sort
        //System.out.println(input);

        //After sort
        app.quicksort(input);
        StdOut.println("Randomized Data");
        StdOut.println(stopwatchR.elapsedTime());

        StdOut.println("Sorted Data");
        app.quicksort(sortedInput);
        StdOut.print(stopwatchS.elapsedTime());

    }

    /**
     * This method sort the input ArrayList using quick sort algorithm.
     * @param input the ArrayList of integers.
     * @return sorted ArrayList of integers.
     */
    private List<Integer> quicksort(List<Integer> input){

        if(input.size() <= 1){
            return input;
        }

        int middle = (int) Math.ceil((double)input.size() / 2);
        int pivot = input.get(middle);

        List<Integer> less = new ArrayList<Integer>();
        List<Integer> greater = new ArrayList<Integer>();

        for (int i = 0; i < input.size(); i++) {
            if(input.get(i) <= pivot){
                if(i == middle){
                    continue;
                }
                less.add(input.get(i));
            }
            else{
                greater.add(input.get(i));
            }
        }

        return concatenate(quicksort(less), pivot, quicksort(greater));
    }

    /**
     * Join the less array, pivot integer, and greater array
     * to single array.
     * @param less integer ArrayList with values less than pivot.
     * @param pivot the pivot integer.
     * @param greater integer ArrayList with values greater than pivot.
     * @return the integer ArrayList after join.
     */
    private List<Integer> concatenate(List<Integer> less, int pivot, List<Integer> greater){

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < less.size(); i++) {
            list.add(less.get(i));
        }

        list.add(pivot);

        for (int i = 0; i < greater.size(); i++) {
            list.add(greater.get(i));
        }

        return list;
    }


}

