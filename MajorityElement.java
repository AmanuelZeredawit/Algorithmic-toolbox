//package algoex.week4;

import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        return majority(a,left,right-1);
    }
    private static int majority(int[]a,int left,int right){
        if(left==right)return a[left];
        int mid= left +(right -left)/2;
        int left_majority= majority(a,left,mid);
        int right_majority=majority(a,mid+1,right);
        if(left_majority==right_majority)return left_majority;
        int left_count = getfreq(a,left_majority);
        int right_count= getfreq(a,right_majority);
        return left_count>a.length/2? left_majority:(right_count>a.length/2?right_majority:-1);

    }
    private static int getfreq(int[]a,int majority){
        int count=0;
        for(int element:a){
            if(element==majority)count++;
            if(count>a.length/2)break;

        }
        return count;
    }
    public static int getLinear(int[]a,int left,int right){
        int major=-1; int count=0;
        for(int i=left;i< right;i++){
            if(count==0){
                major=a[i];
                count=1;
            } else if (a[i]==major) {
                count++;
                
            }
            else if(a[i]==major){
                count--;
            }
        }
        for( int i =left;i<right;i++){
            if(a[i]==major) count++;
            if(count>right/2)return major;
            
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
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

