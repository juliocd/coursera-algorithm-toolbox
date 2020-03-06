import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();

        // Fill up references
        int[] references = new int[1 + n];
        for(int r = 1; r < references.length; r++){
            // n->n-1
            references[r] = references[r - 1] + 1;
            // n->n/2
            if( r % 2 == 0){
                references[r] = Math.min(references[r / 2] + 1, references[r]);
            }
            // n->n/3
            if( r % 3 == 0){
                references[r] = Math.min(references[r / 3] + 1, references[r]);
            }
        }

        // Get minimun number of operations
        while(n > 1){
            sequence.add(n);

            // n->n-1
            if(references[n - 1] == references[n] - 1){
                n--;
            }else if(n % 2 == 0 && (references[n / 2] == references[n] - 1)){
                n /= 2;
            }else if(n % 3 == 0 && (references[n / 3] == references[n] - 1)){
                n /= 3;
            }
        }
        sequence.add(1);
    
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

