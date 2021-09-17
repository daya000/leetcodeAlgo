package TwoPointers;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args){

        sortColors(new int[]{2,0,2,1,1,0});
    }

    public static void sortColors(int[] c) {
        int red = 0;
        int blue = c.length-1;
        int i=0;
        while(i < blue) {
            if(c[i]==0) {
                swap(c, red++, i++);
            }
            else if(c[i]==2) {
                swap(c, blue--, i);
            }
            else {
                i++;
            }
        }

        System.out.println(Arrays.toString(c));
    }

    public static void swap(int[] c, int a, int b){
        int temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
