import java.util.Scanner;
import java.math.BigInteger; 

class FibonacciHuge {
    private static int calculatePisanoPeriod(long m) {
        long n1 = 0; 
        long n2 = 1;
        long value = n1;
        int period = 0;
        int counter = 2;

        while(period == 0){
            value = (n1 + n2) % m;
            n1 = n2;
            n2 = value;

            if(n1 == 0 && n2 == 1){
                period = counter - 1;
                break;
            }

            counter++;
        }

        return period;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long m = s.nextLong();
        s.close();

        if(n < 1 || n >= (1e14 + 1)){
            System.out.println(0);
            return;
        }

        if(m <= 1 || m >= (1e3 + 1)){
            System.out.println(0);
            return;
        }

        if(n == 1){
            System.out.println(n);
            return;
        }

        int period = calculatePisanoPeriod(m);

        long remainder = n % period;

        if(remainder == 0){
            System.out.println(0);
            return;
        }

        BigInteger n1 = BigInteger.ZERO;
        BigInteger n2 = BigInteger.ONE; 
        BigInteger value = n2; 

        for(long i=1; i < remainder; i++){
            value = n1.add(n2);
            n1 = n2;
            n2 = value;
        }

        System.out.println(value.remainder(BigInteger.valueOf(m)));
    }
}