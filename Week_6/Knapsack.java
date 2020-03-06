import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int[][] value = new int[w.length + 1][W + 1];

        for(int i = 1; i <= w.length; i++){
          for(int j = 1; j <= W; j++){
            value[i][j] = value[i - 1][j];
            if(w[i - 1] <= j){
              int val = value[i - 1][j - w[i - 1]] + w[i - 1];
              if(value[i][j] < val){
                value[i][j] = val;
              }
            }
          }
        }
        
        return value[w.length][W];
    }

    public static void print2D(int mat[][]) 
    { 
        // Loop through all rows 
        for (int[] row : mat) 
  
            // converting each row as string 
            // and then printing in a separate line 
            System.out.println(Arrays.toString(row)); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

