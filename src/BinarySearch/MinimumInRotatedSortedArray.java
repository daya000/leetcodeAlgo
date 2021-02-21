package BinarySearch;

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {

        int[] input = new int[]{7,9,10,2,4,5,6};
        findMin(input);
    }

    public static int findMin(int[] num) {
        int i = 0;
        int j = num.length-1;
        while (i < j) {
            if (num[i] > num[j]) {
                i = (i+j)/2;
            }
            else if (num[i] < num[j]) {
                j = (i+j)/2;
            }
        }
        System.out.println(num[i]);
        return num[i];
    }
}
