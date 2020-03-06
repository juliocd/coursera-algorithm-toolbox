import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int sum = 0;

        for(int i=1; i < (n+1); i++){
            sum += i;
            if(sum <= n){
                summands.add(i);
                if(sum == n){
                    break;
                }
            }else{
                summands.set(summands.size() - 1, summands.get(summands.size() - 1) + (n - (sum - i)) );
                break;
            }
        }

        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n < 0 || n >= (10e8 + 1)){
            System.out.print(0);
            return;
        }

        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

