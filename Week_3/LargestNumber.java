import java.util.*;

public class LargestNumber {
    private static String largestNumber(Integer[] a) {
        int maxValueLength = String.valueOf(largest(a)).length();
        String[] arrays = new String[maxValueLength];

        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            int valueLength = String.valueOf(value).length();
            arrays[valueLength - 1] += " " + value;
        }

        int largestArray = 0;
        Integer[][] array = new Integer[maxValueLength][];
        for (int j = 0; j < maxValueLength; j++) {
            String arrStr = arrays[j];
            if(arrStr == null){
                array[j] = new Integer[0];
            }else{
                String[] arr = arrStr.substring(5).split(" ");
                array[j] = new Integer[arr.length];
                for(int l = 0; l < arr.length ; l++){
                    array[j][l] = Integer.parseInt(arr[l]);
                }
                Arrays.sort(array[j], Collections.reverseOrder());
                if(array[j].length > largestArray){
                    largestArray = array[j].length;
                }
            }
        }

        String result = "";
        for (int k = 0; k < largestArray; k++) {
            for (int p = 0; p < array.length; p++) {
                if(array[p].length > k){
                    result += array[p][k];
                }
            }
        }
        return result;
    }

    static int largest(Integer[] arr) 
     { 
         int i; 
         int max = arr[0];   
         for (i = 1; i < arr.length; i++) 
             if (arr[i] > max) 
                 max = arr[i]; 
        
         return max; 
     }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n < 1 || n >= 101){
            System.out.println(0);
            return;
        }

        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();

            if(a[i] < 1 || a[i] >= 1001){
                System.out.println(0);
                return;
            }
        }
        System.out.println(largestNumber(a));
    }
}

