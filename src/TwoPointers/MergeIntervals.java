package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[4][2];

        intervals[3]= new int[]{1, 3};
        intervals[1]= new int[]{3, 6};
        intervals[0]= new int[]{8, 10};
        intervals[2]= new int[]{15, 18};
        Arrays.stream(merge(intervals)).forEach(a -> System.out.println(a[0] + "--->" + a[1]));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        if (intervals.length <=1) return intervals;

        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i=1; i < intervals.length; i++) {
            if (right >= intervals[i][0]) {
                right = intervals[i][1] > right ? intervals[i][1] : right;
            }
            else {
                left = intervals[i][0];
                right = intervals[i][1];
            }

            res.add(new int[]{left, right});
        }
        return res.toArray(new int[][]{});
    }
}
