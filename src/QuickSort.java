import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by poglesbyg on 26/08/15.
 */
public class QuickSort {

    public static <Key extends Comparable<Key>> void sort(Key[] a){
        StdRandom.shuffle(a);
        quicksort(a,0,a.length-1);
    }

    public static <Key extends Comparable<Key>> void quicksort(Key[] a, int lo, int hi) {
        if (lo >= hi) return;
        int m = partition(a,lo,hi);
        quicksort(a, lo, hi);
        quicksort(a,m+1,hi);
    }

    public static <Key extends Comparable<Key>> int partition(Key[] a, int lo, int hi) {
        Key v = a[lo];
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

    private static <Key extends Comparable<Key>> boolean less(Key v, Key w){
        return v.compareTo(w) < 0;
    }

    private static <Key extends Comparable<Key>> void exch(Key[] a, int i, int j){
        Key t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static <Key extends Comparable<Key>> void show(Key[] a){
        for (Key o : a)
            StdOut.print(o + " ");
        StdOut.print();
    }

    public static <Key extends Comparable<Key>> boolean isSorted(Key[] a){
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[] a = StdIn.readAllLines();
        sort(a);
        show(a);
        assert isSorted(a);
    }
}
