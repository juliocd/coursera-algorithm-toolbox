import java.util.*;

public class LCS2 {

    private static int lcs2(int[] s, int[] t) {
        
        int[][] D = new int[s.length + 1][t.length + 1];

        int[] A = new int[t.length + 1];
        for(int i=0; i <= t.length; i++){
            A[i] = (i == 0) ? 0 : t[i - 1];
            D[0][i] = i;
        }
        int[] B = new int[s.length + 1];
        for(int j=0; j <= s.length; j++){
            B[j] = (j == 0) ? 0 : s[j - 1];
            D[j][0] = j;
        }

        for(int j=1; j < A.length; j++){
            for(int i=1; i < B.length; i++){
              int insertion = D[i][j-1];
              int deletion = D[i-1][j];
              int match = D[i-1][j-1] + 1;
              int mismatch = D[i-1][j-1];
              
              if(A[j] == B[i]){
                int[] tempArray = {insertion, deletion, match};
                Arrays.sort(tempArray);
                D[i][j] = tempArray[2];
              }else{
                int[] tempArray = {insertion, deletion, mismatch};
                Arrays.sort(tempArray);
                D[i][j] = tempArray[2];
              }
            }
          }
          print2D(D);
        return D[s.length][t.length];
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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

