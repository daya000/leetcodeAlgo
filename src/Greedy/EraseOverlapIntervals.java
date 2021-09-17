package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1; //初始化不重叠区间个数为1
        int preValue = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= preValue) {
                count ++;
                preValue = intervals[i][1];
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {

        int[][] intervals = new int[][]{new int[]{1,2}, new int[]{2,4}, new int[]{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
