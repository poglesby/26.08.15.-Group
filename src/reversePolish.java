import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * Created by poglesbyg on 22/09/15.
 */
public class reversePolish {

    public static String workingMethod(){
        String x = null;
        String input = "2 3 + 4 ∗ 3 2 + 1 2 + ∗ +";
        String[] working = input.split(" ");


        Stack<String> revPol = new Stack<>();

        for (int i = 0; i < working.length; i++) {
            revPol.push(working[i]);

            if (revPol.peek() == "+" || revPol.peek() == "*"){
                StdOut.print(revPol.pop());
            }
        }

//        while (!revPol.empty()){
//                if (revPol.peek() == "1"){
//                    StdOut.print(revPol.pop());
//            }
//
//        }

        return revPol.toString();
    }

    public static void main(String [] args){
        StdOut.print(workingMethod());
    }
}
