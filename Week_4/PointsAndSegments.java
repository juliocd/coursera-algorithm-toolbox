import java.util.*;
import java.util.stream.IntStream;

public class PointsAndSegments {
    private static Random random = new Random();

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        int[] points2 = IntStream.rangeClosed(0, points.length - 1).toArray();

        // Sort segments
        randomizedQuickSortDouble(starts, 0, starts.length - 1, ends);
        randomizedQuickSortDouble(points, 0, points.length - 1, points2);

        int counter = 0;
        int cLastIndex = 0;
        int[] lastIndex = new int[points.length * 10];
        for(int k=0; k < points.length; k++){
            if(!(points[k] >= starts[0] && points[k] <= ends[starts.length - 1])){
                continue;
            }

            for(int s=0; s < cLastIndex; s++){
                if(points[k] <= ends[lastIndex[cLastIndex]] && points[k] >= starts[lastIndex[cLastIndex]]){
                    cnt[points2[k]]++;
                }
            }

            while(ends[counter] >= points2[k]){
                if(points[k] >= starts[counter] && points[k] <= ends[counter]){
                    cnt[points2[k]]++;
                    lastIndex[cLastIndex] = counter;
                    cLastIndex++;
                }
                if(counter == (starts.length - 1)){
                    break;
                }
                counter++;
            }
        }

        return cnt;
    }

    private static int[] partition3Double(int[] a, int l, int r, int[] b) {
        int v = a[l];
        int m1 = l;
        int m2 = r;
        int i = l;

        while(i <= m2){
            if(a[i] < v){
                int t = a[i];
                a[i] = a[m1];
                a[m1] = t;
                int t2 = b[i];
                b[i] = b[m1];
                b[m1] = t2;
                m1++;
                i++;
            }else if (v == a[i]){
                i++;
            }else{
                int t = a[i];
                a[i] = a[m2];
                a[m2] = t;
                int t2 = b[i];
                b[i] = b[m2];
                b[m2] = t2;
                m2--;
            }
        }

        int[] m = {m1, m2};
        return m;
    }

    private static void randomizedQuickSortDouble(int[] a, int l, int r, int b[]) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        int t2 = b[l];
        b[l] = b[k];
        b[k] = t2;
        int[] m = partition3Double(a, l, r, b);
        randomizedQuickSortDouble(a, l, m[0] - 1, b);
        randomizedQuickSortDouble(a, m[1] + 1, r, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

