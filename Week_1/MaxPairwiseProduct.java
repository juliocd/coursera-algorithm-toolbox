import java.util.Random;
import java.util.Scanner;

class MaxPairwiseProduct {
    private static long calculateMaxPairwiseProduct(long arrayLength, long[] arrayData){
        long fisrtValue = 0;
        long secondValue = 0;

        for(int i = 0; i < arrayLength; i++){
            long value = arrayData[i];
            if(value >= fisrtValue){
                secondValue = fisrtValue;
                fisrtValue = value;
                continue;
            }
            if(value >= secondValue){
                secondValue = value;
            }
        }

        return fisrtValue * secondValue;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arrayLength = s.nextInt();
        long[] arrayData = new long[arrayLength];
        for(int i = 0; i < arrayLength; i++){
            arrayData[i] = s.nextLong();
        }
        s.close();
        System.out.println(calculateMaxPairwiseProduct(arrayLength, arrayData));

        // while(true){
        //     int n = (int) (Math.random() * 100) + 2;
        //     System.out.println("n:" + n);
        //     long[] vector = new long[n];
        //     for(int j = 0; j< n; j++){
        //         vector[j] = (long) (Math.random() * 1000000);
        //         System.out.print(vector[j] + " ");
        //     }
        //     System.out.println();

        //     System.out.println(calculateMaxPairwiseProduct(n, vector));
        // }
    }
}