package Tree;

import General.TreeNode;

/**
 * 124 Binary Tree Max Path Sum
 *      a:-10
 *     / \
 *   b:9  c:20
 *       / \
 *     d:15 e:7
 *     / \
 *   f:3 g:5
 **/

public class MaxPathSumOfBinaryTree {

    static int maxSum = Integer.MIN_VALUE;
    public static int dfs (TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(dfs(node.getLeft()),0);
        int right = Math.max(dfs(node.getRight()), 0);
        maxSum = Math.max(maxSum, left + right + Integer.parseInt(node.getValue()));
        return Math.max(left, right) + Integer.parseInt(node.getValue());
    }

    public static void main(String[] args) {

        TreeNode f = new TreeNode(3);
        TreeNode g = new TreeNode(5);
        TreeNode d = new TreeNode(15, f, g);
        TreeNode e = new TreeNode(7);
        TreeNode c = new TreeNode(20, d, e);
        TreeNode b = new TreeNode(9);
        TreeNode a = new TreeNode(-10, b, c);

        dfs(a);
        System.out.println(maxSum);  //DFS只能得到局部最优！
    }
}
