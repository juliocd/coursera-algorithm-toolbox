import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right || left > right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        
        int m = (right + left) / 2;
        int maxL = getMajorityElement(a, left, m);
        int maxR = getMajorityElement(a, m + 1, right);

        // for(int k=left; k < right; k++){
        //     System.out.print(a[k]);
        // }
        // System.out.println();

        int half = (right - left + 1) / 2;
        if(maxL == maxR){
            return maxL;
        }else if(countArray(a, left, right, maxL) > half){
            return maxL;
        }else if(countArray(a, left, right, maxR) > half){
            return maxR;
        }else{
            return -1;
        }
    }

    private static int countArray(int[] a, int lo, int hi, int value){
        int counter = 0;
        for(int l=lo; l <= hi; l++){
            if(a[l] == value){
                counter++;
            }
        }

        // System.out.println(counter + " " + value);

        return counter;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        boolean error = false;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if(a[i] < 0 || a[i] > 1000000000){
                error = true;
            }
        }

        if(n > 100000 || error){
            System.out.println(0);
        }

        if(getMajorityElement(a, 0, a.length - 1) != -1) {
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

