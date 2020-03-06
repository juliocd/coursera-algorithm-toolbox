import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights, Double [] vW) {
        double value = 0;
        double[] A = new double[vW.length];

        if(capacity == 0){
            return 0;
        }
        for(int k=0; k<vW.length; k++){
            int a = 0;
            if(weights[k] > 0.0){
                a = Math.min(weights[k], capacity);
                value += a * vW[k];
                weights[k] -= a;
                A[k] += a;
                capacity -= a;
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        Double[] vW = new Double[values.length];

        if(n < 1){
            System.out.println(0);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
            if(weights[i] > 0){
                vW[i] = (double) values[i] / (double) weights[i];
            }else{
                vW[i] = 0.0;
            }
        }
        if(capacity <= 0){
            System.out.println(0);
            return;
        }

        for (int i = 0; i < vW.length; i++) {
            for (int j = 0; j < vW.length; j++) {
                if (vW[i] > vW[j]) {
                    double temp = vW[i];
                    vW[i] = vW[j];
                    vW[j] = temp;

                    int tempWeight = weights[i];
                    weights[i] = weights[j];
                    weights[j] = tempWeight;
                }
            }
        }

        System.out.printf("%1.4f",getOptimalValue(capacity, values, weights, vW));System.out.println();
    }
} 
