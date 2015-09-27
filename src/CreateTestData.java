import edu.princeton.cs.algs4.StdOut;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by poglesbyg on 25/09/15.
 */
public class CreateTestData {
    public static int[] getArray() {
        int size = 10000;
        int[] array = new int[size];
        int item = 0;
        for (int i = 0; i < size; i++) {
            item = (int) (Math.random() * 1000);
            array[i] = item;
        }
        return array;
    }


    public static int[] getSortedArray(){
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i]=i;
        }
        return array;
    }


    public static void main(String[] args) throws IOException {
        Writer wr = new FileWriter("data.txt");
        Writer wrSorted = new FileWriter("sortedData.txt");
        int[] array = getArray();
        int[] arrayTestSorted = getSortedArray();

        for (int i = 0; i < array.length; i++) {
            wr.write(String.valueOf(array[i]) + "\n");

            //StdOut.println(String.valueOf(array[i]));
        }

        for (int i = 0; i < arrayTestSorted.length; i++) {
            wrSorted.write(String.valueOf(arrayTestSorted[i]) + "\n");

            //StdOut.println(String.valueOf(array[i]));
        }
        wr.close();
        wrSorted.close();
    }
}
