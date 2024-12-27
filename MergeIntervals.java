
import java.util.Arrays;

public class MergeIntervals {
    /*
         * added merge sort in place as a part of this
         */
    public static void main(String[] args) {
        int [][] array = new int[][]{{1,3},{0,2},{2,3},{4,6},{4,5},{5,5},{0,2},{3,3}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        array = mergeIntervals.merge(array);
        Arrays.stream(array).forEach(values -> System.out.print(Arrays.toString(values)+", "));
        
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] returnArray = new int[intervals.length][2];
        returnArray[0][0] = intervals[0][0];
        returnArray[0][1] = intervals[0][1];
        int i=0;
        for(int j=1; j<intervals.length; j++){
            if(intervals[j][0] <= returnArray[i][1]){
                returnArray[i][1] = intervals[j][1] > returnArray[i][1] ? intervals[j][1] : returnArray[i][1];
            }else{
                i++;
                returnArray[i][0] = intervals[j][0];
                returnArray[i][1] = intervals[j][1];
            }
        }
        return Arrays.copyOfRange(returnArray, 0, i+1);
        
    }
}
