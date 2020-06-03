import java.util.Scanner;

class FibonacciSumLastDigit {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        s.close();

        if(n < 1 || n >= (1e14 + 1)){
            System.out.println(0);
            return;
        }

        if(n <= 2){
            System.out.println(n);
            return;
        }

        int n1 = 0;
        int n2 = 1;

        // Pisano period for % 10 is 60 
        int pp = (int) (n % 60);
        pp = pp + 2;  

        for(int i = 1; i < pp; i++){
            int value = (n1 + n2) % 60;
            n1 = n2;
            n2 = value;
        }

        System.out.println((n2 - 1) % 10);
    }
}