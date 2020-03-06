import java.util.Scanner;

class FibonacciLastDigit {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();

        if(n < 0 || n >= (1e7 + 1)){
            System.out.println(0);
            return;
        }

        if(n <= 1){
            System.out.println(n);
            return;
        }

        long n1 = 0;
        long n2 = 1;
        long value = n1;

        for(long i=1; i < n; i++){
            value = n1 + n2;
            n1 = n2 % 10;
            n2 = value % 10;
        }

        System.out.println(n2);
    }
}