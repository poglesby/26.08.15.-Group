import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by poglesbyg on 26/08/15.
 */

public class Parentheses {

    static String createTestString(){
        String testString = "[()]{}{[()()]()}";
        String falseTest = "{[(]}";
        return testString;
        //return falseTest;
    }

    static boolean isOpener(char opener){
        return opener == '(' || opener == '[' || opener == '{';
    }

    static boolean correctMatch(char opener, char closer){
        switch (opener) {
            case '(': {
                return closer == ')';
            }
            case '[': {
                return closer == ']';
            }
            case '{': {
                return closer == '}';
            }
        }
        return false;
    }

    static boolean isBalanced(String input){
        Stack<Character> openers = new Stack<Character>();
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (isOpener(c)){
                openers.push(c);
            } else {
                if (!correctMatch(openers.pop(), c))
                    return false;
            }
        }
        return openers.empty();
    }

    public static void main(String[] args){
        System.out.print(isBalanced(createTestString()));
    }
}
