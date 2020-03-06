import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int[][] D = new int[s.length() + 1][t.length() + 1];
    
    String[] A = new String[t.length() + 1];
    char[] sArray =  t.toCharArray();
    for(int i=0; i <= t.length(); i++){
      A[i] = (i == 0) ? "" : sArray[i - 1] + "";
      D[0][i] = i;
    }
    String[] B = new String[s.length() + 1];
    char[] tArray =  s.toCharArray();
    for(int j=0; j <= s.length(); j++){
      B[j] = (j == 0) ? "" : tArray[j - 1] + "";
      D[j][0] = j;
    }
    
    for(int j=1; j < A.length; j++){
      for(int i=1; i < B.length; i++){
        int insertion = D[i][j-1] + 1;
        int deletion = D[i-1][j] + 1;
        int match = D[i-1][j-1];
        int mismatch = D[i-1][j-1] + 1;
        
        if(A[j].equals(B[i])){
          int[] tempArray = {insertion, deletion, match};
          Arrays.sort(tempArray);
          D[i][j] = tempArray[0];
        }else{
          int[] tempArray = {insertion, deletion, mismatch};
          Arrays.sort(tempArray);
          D[i][j] = tempArray[0];
        }
      }
    }
    //print2D(D);
    return D[s.length()][t.length()];
  }

  public static void print2D(int mat[][]) 
    { 
        // Loop through all rows 
        for (int[] row : mat) 
  
            // converting each row as string 
            // and then printing in a separate line 
            System.out.println(Arrays.toString(row)); 
    }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
