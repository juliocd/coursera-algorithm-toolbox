import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        Arrays.sort(segments, new SortSegment()); 

        List<Integer> coverPoints = new ArrayList<Integer>();
        int initValue = segments[0].end;

        while(segments.length > 0){
            Segment[] tmpSegments = new Segment[segments.length];
            int counter = 0;
            for(int i=0; i < segments.length; i++){
                if(!(segments[i].start <= initValue  && initValue <= segments[i].end)){
                    tmpSegments[counter] = segments[i];
                    counter++;
                }
            }
            segments = Arrays.copyOf(tmpSegments, counter);
            Arrays.sort(segments, new SortSegment());
            coverPoints.add(initValue);

            if(segments.length > 0){
                initValue = segments[0].end;
            }
        }
        return coverPoints;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class SortSegment implements Comparator<Segment> 
    { 
        // Used for sorting in ascending
        public int compare(Segment a, Segment b) 
        { 
            return a.end - b.end; 
        } 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n < 1 || n >= 101){
            System.out.println(0);
            return;
        }

        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();

            if(start < 0 || end < 0 || start > end){
                System.out.println(0);
                return;
            }

            segments[i] = new Segment(start, end);
        }

        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
