import java.util.Scanner;

class Fibonacci {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();

        if(n < 0 || n >= 46){
            return;
        }

        if(n <= 1){
            System.out.println(n);
            return;
        }

        long n1 = 0;
        long n2 = 1;
        long value = n1;

        for(int i=1; i < n; i++){
            value = n1 + n2;
            n1 = n2;
            n2 = value;
        }

        System.out.println(value);
    }
}