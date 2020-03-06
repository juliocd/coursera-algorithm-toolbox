import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlacingParentheses {

    // Gloval variables
    static List<String> operations = new ArrayList<String>();
    static List<Long> decimals = new ArrayList<Long>();

    private static long getMaximValue(String exp) {
        // Breakdown epression
        breakdownExp(exp);

        // Create M (max) and m(min) matrixes
        long[][] m = new long[decimals.size() + 1][decimals.size() + 1];
        long[][] M = new long[decimals.size() + 1][decimals.size() + 1];

        // Fill up the diagonal
        for(int x = 0; x < decimals.size(); x++){
            m[x + 1][x + 1] = decimals.get(x);
        }
        for(int y = 0; y < decimals.size(); y++){
            M[y + 1][y + 1] = decimals.get(y);
        }

        // Evalualuate operations
        int n = decimals.size();
        for(int s = 1; s <= (n - 1); s++){
            for(int i = 1; i <= (n - s); i++){
                int j = i + s;
                long[] minMax = minAndMax(i, j, m, M);
                m[i][j] = minMax[0];
                M[i][j] = minMax[1];
            } 
        }
    
      return M[1][decimals.size()];
    }

    private static long[] minAndMax(int i, int j, long[][] m, long[][] M){
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for(int k = i; k <= (j - 1); k++){
            long a = eval(M[i][k], M[k + 1][j], operations.get(k - 1).charAt(0));
            long b = eval(M[i][k], m[k + 1][j], operations.get(k - 1).charAt(0));
            long c = eval(m[i][k], M[k + 1][j], operations.get(k - 1).charAt(0));
            long d = eval(m[i][k], m[k + 1][j], operations.get(k - 1).charAt(0));

            min = min(new long[]{min, a, b, c, d});
            max = max(new long[]{max, a, b, c, d});
        }

        return new long[]{min, max};
    }

    private static long max(long [] array) {
        long max = 0;
       
        for(int i=0; i<array.length; i++ ) {
           if(array[i]>max) {
              max = array[i];
           }
        }
        return max;
     }
     private static long min(long [] array) {
        long min = array[0];
       
        for(int i=0; i<array.length; i++ ) {
           if(array[i]<min) {
              min = array[i];
           }
        }
        return min;
     }

    private static void breakdownExp(String exp){
        char[] expArr = exp.toCharArray();

        for(char x : expArr){
            if(x == '+' || x == '-' || x == '*'){
                operations.add(x + "");
            }else{
                decimals.add(Long.parseLong(x + ""));
            }
        }
    }

    public static void print2D(long mat[][]) 
    { 
        // Loop through all rows 
        for (long[] row : mat) 
  
            // converting each row as string 
            // and then printing in a separate line 
            System.out.println(Arrays.toString(row)); 
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

