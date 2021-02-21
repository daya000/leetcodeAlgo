package Tree;

import General.TreeNode;
/**
 *      a
 *     / \
 *    b   c
 *   / \   \
 *  d   e   g
 *   \     /
 *    f   h
 *   /
 *  i
 **/

public class MaxDepthOfBinaryTree {

    public static int maxDepth (TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(maxDepth(node.getLeft()), maxDepth(node.getRight()));
    }

    public static void main(String[] args) {

        TreeNode e = new TreeNode("e");
        TreeNode h = new TreeNode("h");
        TreeNode i = new TreeNode("i");
        TreeNode f = new TreeNode("f", i, null);
        TreeNode d = new TreeNode("d", null, f);
        TreeNode g = new TreeNode("g", h, null);
        TreeNode b = new TreeNode("b", d, e);
        TreeNode c = new TreeNode("c", null, g);
        TreeNode a = new TreeNode("a", b, c);


        System.out.println(maxDepth(a));
    }
}
