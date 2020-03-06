import java.util.Scanner;

class FibonacciSumSquares {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        s.close();

        if(n < 1 || n >= (1e14 + 1)){
            System.out.println(0);
            return;
        }

        if(n == 1){
            System.out.println(n);
            return;
        }

        long n1 = 0;
        long n2 = 1;
        long value = n1;
        long pPeriod = (n+1) % 60;

        for(long i=1; i < pPeriod; i++){
            value = (n1 + n2) % 10;
            n1 = n2;
            n2 = value;
        }

        System.out.println(((n2 % 10) * (n1 % 10)) % 10);
    }
}