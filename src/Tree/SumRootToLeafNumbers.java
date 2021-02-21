package Tree;

import General.TreeNode;

/**
 * 124 Binary Tree Max Path Sum
 *      a:4
 *     / \
 *   b:0  c:9
 *       / \
 *     d:1 e:5
 **/

public class SumRootToLeafNumbers {

    static int maxSum = 0;
    //递归也可以是无返回值的，这种情况是正序得到结果
    public static void dfs (TreeNode node, int num) {

        int newNum = num * 10 + Integer.parseInt(node.getValue());

        if (node.getLeft()==null && node.getRight()==null) {
            maxSum += newNum;
        }
        if (node.getLeft()!=null) {
            dfs (node.getLeft(), newNum);
        }
        if (node.getRight()!=null) {
            dfs (node.getRight(), newNum);
        }
    }

    public static void main(String[] args) {

        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(5);
        TreeNode c = new TreeNode(9, d, e);
        TreeNode b = new TreeNode(0);
        TreeNode a = new TreeNode(4, b, c);

        dfs(a, 0);
        System.out.println(maxSum);
    }
}
