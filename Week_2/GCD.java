import java.util.Scanner;

class GCD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
        long b = s.nextLong();
        s.close();

        if(a <= 0 || a >= (2*10e8 + 1)){
            System.out.println(0);
            return;
        }

        if(b <= 0 || b >= (2*10e8 + 1)){
            System.out.println(0);
            return;
        }

        if(a == 1 || b == 1){
            System.out.println(1);
            return;
        }

        long hg = 0;
        long sm = 0;
        if(a > b){
            hg = a;
            sm = b;
        }else{
            hg = b;
            sm = a;
        }
        
        long remainder = 0;
        boolean hasRemainder = false;
        while(hasRemainder(hg, sm)){
            remainder = hg - sm*(hg/sm);
            hg = sm;
            sm = remainder;
            hasRemainder = true;
        }

        if(hasRemainder){
            System.out.println(hg);
        }else{
            System.out.println(sm);
        }
    }

    private static boolean hasRemainder(long hg, long sm){
        return (((double) hg / (double) sm) % 10) > 0;
    }
}