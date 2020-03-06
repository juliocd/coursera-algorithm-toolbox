import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int money, int[] coins) {
        if(money == 0){
            return 0;
        }
        int[] minNumCoins = new int[money + 1];

        for(int m = 1; m <= money; m++){
            minNumCoins[m] = 1001;
            for(int i = 0; i < coins.length; i++){
                if(m >= coins[i]){
                    int numCoins = minNumCoins[m - coins[i]]+ 1;
                    if(numCoins < minNumCoins[m]){
                        minNumCoins[m] = numCoins;
                    }
                }
            }
        }

        return minNumCoins[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] coins = {1, 3, 4};
        System.out.println(getChange(m, coins));
    }
}

