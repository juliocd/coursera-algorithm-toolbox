import java.util.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numRefills = 0;
        int currentRefill = 0;
        int n = stops.length;
        int[] totalStops = new int[n + 2];

        totalStops[0] = 0;
        for(int i=0; i < n; i++){
            totalStops[i + 1] = stops[i];
        }
        totalStops[n + 1] = dist;

        while (currentRefill <= n){
            int lastRefill = currentRefill;
            while(currentRefill <= n && (totalStops[currentRefill + 1] - totalStops[lastRefill] <= tank)){
                currentRefill++;
            }
            if(currentRefill == lastRefill){
                numRefills = -1;
                break;
            }
            if(currentRefill <= n){
                numRefills++;
            }
        }
        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
