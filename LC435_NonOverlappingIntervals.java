import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        // Sort intervals by their ending time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int n = intervals.length;
        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            // Overlapping interval
            if (intervals[i][0] < end) {
                count++;
            } 
            else {
                // Non-overlapping interval
                end = intervals[i][1];
            }
        }

        return count;
    }
}