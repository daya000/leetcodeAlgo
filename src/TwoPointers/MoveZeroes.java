package TwoPointers;

/*valueIdx pointing to value selected, which will be replaced by other value during iteration, then it moves on and pointing to next
if found same value, the valueIdx is exactly at that position, do nothing and continue loop.
 */
public class MoveZeroes {

    //O[2n] worst case
    public static void moveZeroes1(int[] num, int value) {
        int valueIdx = 0;
        for (int i = 0; i < num.length; i++) {
            if (value != num[i]) {
                num[valueIdx++] = num[i];
            }
        }
        for (int j = valueIdx; j < num.length; j++) {
            num[j] = value;
        }
    }

    //O[n]
    public static void moveZeroes2(int[] num, int value) {
        int valueIdx = 0;
        for (int i=0; i< num.length; i++) {
            if (value != num[i]) {
                int tmp = num[valueIdx];
                num[valueIdx] = num[i];
                num[i] = tmp;
                valueIdx++;
            }
        }
    }


    public static void main(String[] args) {

        int[] input = new int[]{0,1,0,3,12};
        moveZeroes2(input, 0);
        for (int i: input) {
            System.out.print(i+", ");
        }
    }
}
