import java.util.*;

public class Partition3 {
    private static int partition3(int[] w) {
        int W = 0;
        for(int x : w){
            W += x;
        }

        if(W % 3 != 0){
            return 0;
        }
        W = W / 3;

        int[][] value = new int[w.length + 1][W + 1];
        
        int count = 0;
        for(int i = 1; i <= w.length; i++){
            for(int j = 1; j <= W; j++){
                value[i][j] = value[i - 1][j];
                if(w[i - 1] <= j){
                int val = value[i - 1][j - w[i - 1]] + w[i - 1];
                    if(value[i][j] < val){
                        value[i][j] = val;
                    }

                    if(val == W){
                        count++;
                    }
                }
            }
        }

        return count >= 3 ? 1 : 0;
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
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

