import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static edu.princeton.cs.algs4.StdIn.*;
import static edu.princeton.cs.algs4.StdOut.*;
import static edu.princeton.cs.algs4.StdRandom.*;

/**
 * Created by poglesbyg on 26/08/15.
 */
public class QuickSort {

    public static ArrayList<String> readFile(String file_path) throws IOException {
        Scanner s = new Scanner(new File(file_path));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();

        return list;
    }

    public static <Object extends Comparable<Object>> void sort(Object[] a){
        shuffle(a);
        quicksort(a,0,a.length-1);
    }

    public static <Object extends Comparable<Object>> void quicksort(Object[] a, int lo, int hi) {
        if (lo >= hi) return;
        int m = partition(a,lo,hi);
        quicksort(a, lo, hi);
        quicksort(a,m+1,hi);
    }

    public static <Object extends Comparable<Object>> int partition(Object[] a, int lo, int hi) {
        Object v = a[lo];
        int l=lo, h = hi;
        for (;;) {
            while (less(v,a[h]))
                h--;
            while (l<h && less(a[l+1],v))
                l++;
            if (l+1<h) {
                exch(a,l+1,h);
                l++;
            } else {
                break;
            }
        }
        exch(a, l, lo);
        return l;
    }

    private static <Object extends Comparable<Object>> boolean less(Object v, Object w){
        return v.compareTo(w) < 0;
    }

    private static <Object extends Comparable<Object>> void exch(Object[] a, int i, int j){
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static <Object extends Comparable<Object>> void show(Object[] a){
        for (Object o : a)
            print(o + " ");
        print();
    }

    public static <Object extends Comparable<Object>> boolean isSorted(Object[] a){
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
//        ArrayList<String> a = (readFile("/Users/poglesbyg/Downloads/data/namesA.txt"));
//        int[] testArray = {1,2,3,4,5,3,23,32,23,3,23};
//
//        sort(testArray);
//
//
//        sort(a);
//        show(a);
//        assert isSorted(a);
    }
}
