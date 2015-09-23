import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;
import java.util.Scanner;


/**
 * Created by poglesbyg on 26/08/15.
 */
public class SlowUF {

    private int[] id;
    private int count;
    private long aacost;

    public SlowUF(int N){
        id = new int[N];
        for (int i=0; i<N; i++)
            id[i]=i;
        aacost = N;
        count = N;
    }

    public int count(){
        return count;
    }
    public long cost(){
        return aacost;
    }
    public void show(){
        for (int i=0;i<id.length; i++)
            System.out.print(id[i]);
    }
    public int find(int p) {
        aacost++;
        return id[p];
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public void union(int p, int q){
        int idp = find(p);
        int idq = find(q);
        if (idp != idq) {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == idp) {
                    aacost++;
                    id[i] = idq;
                }
                count--;
                aacost += id.length;
            }
        }
    }

    public static void main(String[] args){
        int N = StdIn.readInt();
        SlowUF uf = new SlowUF(N);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p,q)) uf.union(p,q);
            StdOut.print(p + " " + q + " ");
            uf.show();
            StdOut.println(" #components: " + uf.count());
        }
    }
}
