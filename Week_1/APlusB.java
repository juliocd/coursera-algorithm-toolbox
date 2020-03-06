import java.util.Scanner;

class APlusB {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        s.close();

        int result = a + b;
        System.out.println(result);
    }
}