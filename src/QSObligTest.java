import edu.princeton.cs.algs4.StdOut;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

/**
 * Created by poglesbyg on 24/09/15.
 */
public class QSObligTest {
    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testNull() {
        QuickSortOblig sorter = new QuickSortOblig();
        sorter.sort(null);
    }

    @Test
    public void testEmpty() {
        QuickSortOblig sorter = new QuickSortOblig();
        sorter.sort(new int[0]);
    }

    @Test
    public void testSimpleElement(){
        QuickSortOblig sorter = new QuickSortOblig();
        int[] test = new int[1];
        test[0] = 5;
        sorter.sort(test);
    }

    @Test
    public void testSpecial() {
        QuickSortOblig sorter = new QuickSortOblig();
        int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
        sorter.sort(test);
        if (!validate(test)){
            fail("Should not happen");
        }
        printResult(test);
    }

    @Test
    public void testQuickSort(){
        for (Integer i : numbers){
            StdOut.println(i + " ");
        }
        long startTime = System.currentTimeMillis();

        QuickSortOblig sorter = new QuickSortOblig();
        sorter.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        StdOut.println("Quicksort " + elapsedTime);

        if(!validate(numbers)){
            fail("Should not happen");
        }
        assertTrue(true);
    }

    @Test
    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);
        if (!validate(numbers)) {
            fail("Should not happen");
        }
        assertTrue(true);
    }

    private boolean validate(int[] test) {
        for (int i = 0; i < numbers.length -1; i++) {
            if (numbers[i] > numbers[i + 1]){
                return false;
            }
        }
        return true;
    }

    private void printResult(int[] test) {
        for (int i = 0; i < numbers.length; i++) {
            StdOut.print(numbers[i]);
        }
        StdOut.println();
    }
}
