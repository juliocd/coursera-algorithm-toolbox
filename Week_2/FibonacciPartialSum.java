import java.util.Scanner;

class FibonacciPartialSum {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long m = s.nextLong();
        long n = s.nextLong();
        s.close();

        if(n < 0 || n >= (1e14 + 1)){
            System.out.println(0);
            return;
        }

        if(m < 0 || m >= (1e14 + 1)){
            System.out.println(0);
            return;
        }

        if(m > n){
            System.out.println(0);
            return;
        }

        if(n <= 1){
            System.out.println(n);
            return;
        }

        long n1 = 0;
        long n2 = 1;
        long value = 0;
        long sum = value;
        if(m <= 1){
            sum = n2;
        }

        for(long i=2; i <= n; i++){
            value = (n1 + n2) % 10;
            n1 = n2;
            n2 = value;
            if(i >= m){
                sum += value;
            }
        }

        System.out.println(sum % 10);
    }
}