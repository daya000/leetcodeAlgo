package TwoPointers;

public class maxCapacity {
    public static int maxVolume (int[] num) {

        if (num.length<2) {
            return 0;
        }
        int left = 0;
        int right = num.length-1;
        int res = 0;

        while (left < right) {

            if (num[left] < num[right]) {
                res = Math.max(res, (right - left) * num[left]);
                left++;
            }
            else {
                res = Math.max(res, (right - left) * num[right]);
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] input = new int[]{ 1,8,6,2,5,4,8,3,7};
        System.out.println(maxVolume(input));
    }
}
