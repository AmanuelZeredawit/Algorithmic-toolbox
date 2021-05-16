//package algoex.week3;


import java.util.*;
//import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int lastRefill=0;
        int numRefills=0;
        int currentRefill=0;
        if(tank>=dist)return 0;
        while(currentRefill< (stops.length-1)){
            lastRefill=currentRefill;
            while((currentRefill<(stops.length-1))&&((stops[currentRefill+1]-stops[lastRefill])<=tank)){
                currentRefill++;

            }
            if(currentRefill==lastRefill) return -1;
            if(currentRefill<(stops.length-1)) numRefills++;


        }
        return numRefills;




    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int[] stops= new int[n+2];
        stops[0]=0;

        for (int i = 1; i <=n; i++) {
            stops[i] = scanner.nextInt();
        }
        stops[n+1]=dist;

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
