import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int[] A = {10,5,1};
        int totalCoins = 0;

        for(int i = 0; i<A.length ; i++){
            int coins = m / A[i];
            if(coins > 0){
                m = m % A[i];
                totalCoins += coins;
            }
        }

        return totalCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();
    }
}

