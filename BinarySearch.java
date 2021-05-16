//package algoex.week4;

import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a,int first,int last, int x) {
       // int left = 0, right = a.length;
        int mid=first + (last-first)/2;
        while(first<=last){

        if(x==a[mid]){
            return mid;
        }
        if(x<a[mid]){
            return binarySearch(a,first,mid-1,x);


        }
        if(x>a[mid]){
            return binarySearch(a,mid+1,last,x);
        }
        //write your code here



    }
        return -1;
    }



    static int linearSearch(int[] a,  int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        int first=0;
        int last=a.length-1;
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            //System.out.print(linearSearch(a, b[i]) + " ");
            System.out.println(binarySearch(a,first,last,b[i]));
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

