package TwoPointers;

public class rainWater {

    public static int maxRainWater(int[] a) {
        int i = 0;
        int j = a.length-1;
        int maxLeft = a[0];
        int maxRight = a[a.length-1];
        int res=0;
        if (a.length < 3) return 0;


        while (i<j) {
            if(a[i] < a[j]) {
                if (a[i] < maxLeft) {
                    res += maxLeft - a[i++];
                }
                else {
                maxLeft = a[i++];
                }

            }
            else {
                if (a[j] < maxRight) {
                    res += maxRight - a[j--];
                }
                else {
                    maxRight = a[j--];
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {

        int[] input = new int[]{3,0,1,0,5,2,3,1,4};
        System.out.println(maxRainWater(input));
    }
}
