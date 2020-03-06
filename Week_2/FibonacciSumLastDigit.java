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

        long n1 = 0;
        long n2 = 1;
        long value = n2;
        long sum = value;

        for(long i=2; i <= n; i++){
            value = (n1 + n2) % 10;
            n1 = n2;
            n2 = value;
            sum += value;
        }

        System.out.println(sum % 10);
    }
}