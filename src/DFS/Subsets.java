package DFS;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args){
        int[] m = new int[]{1,2,3,4};
        subSets(m);
        System.out.println(subsetsNonRecursive(m));
    }
    public static List<List<Integer>> subSets(int[] m){
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), 0, m);
        System.out.println(res);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> temp, int pos, int[] m) {

        res.add(new ArrayList<Integer>(temp));
        for(int i=pos; i<m.length; i++){
            //if 循环过滤掉重复元素的情况进行剪枝，即subset II的题型，集合包含重复元素，可以重复使用，但结果集元素不可重复
//            if(i > pos && m[i] == m[i - 1]) {
//                continue;
//            }
            temp.add(m[i]);
            dfs(res,temp,i+1,m);
            //上一步dfs已经结束了叶子节点的遍历，此时需要删掉最后一个元素（最近加进来的元素）以在下次for循环中遍历兄弟节点
            temp.remove(temp.size()-1);
        }
    }

    public static List<List<Integer>> subsetsNonRecursive(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int num : nums) {  // ①从数组中取出每个元素
            System.out.println("Size for res is: " + res.size());
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));  // ②逐一取出中间结果集
                System.out.println(temp);
                System.out.println("adding new number: " + num);

                temp.add(num);  // ③将 num 放入中间结果集
                res.add(temp);  // ④加入到结果集中
                System.out.println("now new entry is added: " + temp);
            }
        }
        return res;
    }

}
