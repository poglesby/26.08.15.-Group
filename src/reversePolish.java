import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by poglesbyg on 22/09/15.
 */
public class ReversePolish {

    public static int reversePolishNotation(String[] tokens){
        int returnValue = 0;
        Stack<String> stack = new Stack<>();

//        while size of stack is bigger then 1

        for (String t: tokens){
            StdOut.println();
            if(!isOperator(t.charAt(0))) {
                StdOut.print("Pushing" + t);

                stack.push(t);
            } else {

                String as = stack.pop();
                String bs = stack.pop();
                StdOut.print(t + as + bs);
                int a = Integer.valueOf(as);
                int b = Integer.valueOf(bs);
                switch (t) {
                    case "+" :
                        stack.push(String.valueOf(a + b));
                        break;
                    case "*":
                    case "∗":
                        stack.push(String.valueOf(a * b));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());
        StdOut.println();
        return returnValue;
    }

    private static boolean isOperator(char t) {
        char[] operators = {'*', '+', '∗'};
        for (char ops : operators){
            if(ops == t) return true;
        }

        return false;
    }

    public static void main(String [] args) throws IOException {
        String[] test = {"2", "3", "+", "4", "∗", "3", "2", "+", "1", "2", "+", "∗", "+"};
        //String[] tokens1 = test.split(" ");
        String[] tokens = new String [] {"2", "1", "+", "3", "*"};
        StdOut.println(reversePolishNotation(test));
    }
}
