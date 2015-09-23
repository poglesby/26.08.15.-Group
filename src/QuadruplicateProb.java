import edu.princeton.cs.algs4.StdOut;

import java.io.*;
import java.util.*;

/**
 * Created by poglesbyg on 23/09/15.
 */
public class QuadruplicateProb {

    public static ArrayList<String> readFile(String file_path) throws IOException {
        Scanner s = new Scanner(new File(file_path));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();

        return list;
    }

     public static <E extends Comparable<E>> ArrayList<E> findDuplicates(ArrayList<E>... lists) {

        Queue<ArrayList<E>> unprocessedLists = new LinkedList<>();

        // Sort the lists in nlog(n) time
        for (ArrayList<E> list : lists) {
            Collections.sort(list);
            unprocessedLists.add(list);
        }

        // this will take M-1 steps to finish, because the amount of lists decreases by 1 each time
        //      where M is the number of lists (by default: 4, so it will go through the loop 3 times)
        while (unprocessedLists.size() > 1) {
            ArrayList<E> f = unprocessedLists.poll(); // constant
            ArrayList<E> s = unprocessedLists.poll(); // constant

            unprocessedLists.add(findCommonElements(f, s)); // linear time
        }
        // while loop is done in linear time

        // return the first duplicate
        ArrayList<E> duplicates = unprocessedLists.poll();
        return duplicates;
    }

    public static String findFirstDuplicate(ArrayList<String> ... lists){
        ArrayList<String> duplicates = findDuplicates(lists);
        if(duplicates.size() > 0)
            return duplicates.get(0);
        else return "";

    }

    // worst case running time is the amount of elements in both lists, O(N)
    public static <E extends Comparable<E>> ArrayList<E> findCommonElements(ArrayList<E> first, ArrayList<E> second){
        int firstIndex = 0, secondIndex = 0;
        ArrayList<E> duplicates = new ArrayList<>();

        while(firstIndex < first.size() && secondIndex < second.size()){
            E firstElem = first.get(firstIndex);
            E secondElem = second.get(secondIndex);
            int comparison = firstElem.compareTo(secondElem);

            if(comparison == 0) {
                duplicates.add(firstElem);
                firstIndex++;
                secondIndex++;
            }
            else if (comparison < 0){
                firstIndex++;
            } else {
                secondIndex++;
            }
        }

        return duplicates;
    }


    public static ArrayList sortAndRemoveCopies(ArrayList arrayList){
        int size = arrayList.size();
        int duplicates = 0;
        ArrayList working = new ArrayList();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size; j++) {
                if(!arrayList.get(j).equals(arrayList.get(i)))
                    continue;
                duplicates++;
                arrayList.remove(j);
                j--;
                size--;
            }
        }

        return arrayList;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> l1 = (readFile("/Users/poglesbyg/Downloads/data/namesA.txt"));
        ArrayList<String> l2 = (readFile("/Users/poglesbyg/Downloads/data/namesB.txt"));
        ArrayList<String> l3 = (readFile("/Users/poglesbyg/Downloads/data/namesC.txt"));
        ArrayList<String> l4 = (readFile("/Users/poglesbyg/Downloads/data/namesD.txt"));

        ArrayList<String> duplicates = findDuplicates(l1, l2, l3, l4);
        StdOut.println(duplicates);

        StdOut.println(findFirstDuplicate(l1,l2,l3,l4));

    }
}
