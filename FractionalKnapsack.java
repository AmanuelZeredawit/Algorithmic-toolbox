//package algoex.week3;


//import java.util.Scanner;
import java.util.*;

public class FractionalKnapsack{

    private static int getMaxIndex(int[] weight, int[] values) {
        int max_i = 0;
        double max = 0;

        for (int i = 0; i < weight.length; i++) {
            if (weight[i] != 0 && (double) values[i] / weight[i] > max) {
                max = (double) values[i] / weight[i];
                max_i = i;
            }
        }
        return max_i;
    }

    private static double getOptimalValue(int capacity_is, int[] values, int[] weight) {
        double value = 0.0;

        for (int i = 0; i < weight.length; i++) {
            if (capacity_is == 0)
                return value;
            int index = getMaxIndex(weight, values);
            int a = Math.min(capacity_is, weight[index]);
            value += a * (double) values[index] / weight[index];
            weight[index] -= a;
            capacity_is -= a;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
