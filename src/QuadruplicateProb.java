import edu.princeton.cs.algs4.StdOut;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by poglesbyg on 23/09/15.
 */
public class QuadruplicateProb {

    public static ArrayList readFile(String file_path) throws IOException {
        Scanner s = new Scanner(new File(file_path));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();

        return list;
    }

    public static void main(String[] args) throws IOException {
        StdOut.println(readFile("/Users/poglesbyg/Downloads/data/namesA.txt"));
        StdOut.println(readFile("/Users/poglesbyg/Downloads/data/namesB.txt"));
        StdOut.println(readFile("/Users/poglesbyg/Downloads/data/namesC.txt"));
        StdOut.println(readFile("/Users/poglesbyg/Downloads/data/namesD.txt"));
    }
}
