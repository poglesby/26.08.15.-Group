import edu.princeton.cs.algs4.StdOut;
import javafx.util.Pair;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

/**
 * Created by poglesbyg on 02/09/15.
 */
public class printElementIfInBothArrays {

    public static void solveProblem(ArrayList<Integer> firstArray, ArrayList<Integer> secondArray){

        for (int i = 0; i < firstArray.size(); i++) {
            for (int j = 0; j < secondArray.size(); j++) {
                if (firstArray.get(i) == secondArray.get(j)){
                    StdOut.print(firstArray.get(i).toString() + " ");
                }
            }
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> firstArray = new ArrayList<Integer>();
        ArrayList<Integer> secondArray = new ArrayList<Integer>();
        firstArray.add(1);
        firstArray.add(3);
        firstArray.add(6);
        firstArray.add(9);
        firstArray.add(12);
        secondArray.add(3);
        secondArray.add(6);
        secondArray.add(12);
        secondArray.add(13);

        solveProblem(firstArray, secondArray);
    }
}
