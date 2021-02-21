package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//output all possibilities
public class TwoSum {

    public static List<int[]> twoSum(int[] num, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < num.length; i++) {
            if (hm.containsKey(sum-num[i])) {
                int idx = hm.get(sum-num[i]);
                result.add(new int[]{num[idx],num[i]});
            }
            else {
                hm.put(num[i],i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] input = new int[] {1,3,4,5,6,7,10,15};
        List<int[]> res = twoSum(input, 11);
        res.forEach(x -> System.out.print(Arrays.toString(x)));
    }
}
