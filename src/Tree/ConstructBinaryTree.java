package Tree;

/*
Given preOrder and inOrder traversal of a tree, construct the binary tree.

Note
You may assume that duplicates do not exist in the tree.

Example
Given inOrder [4,2,1,5,3,6] and preOrder [1,2,4,3,5,6]

return a tree

 *      1
 *     / \
 *    2   3
 *   /   / \
 *  4   5   6

Tags Expand
Binary Tree
*/

import General.TreeNode;
import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

    static Map<Integer, Integer> map = new HashMap<>();
    static int index = 0;

    public static TreeNode buildTree (int[] preOrder, int[] inOrder) {

        if (preOrder == null || inOrder == null || preOrder.length == 0
                || preOrder.length != inOrder.length) return null;

        return dfs(preOrder,inOrder,0,inOrder.length-1);
    }
    public static TreeNode dfs(int[] preOrder, int[] inOrder, int start, int end) {

        if (start > end) return null;
        int rootVal = preOrder[index++];  //根据先序遍历依次构造父节点，当index为零时是根节点
        int rootIdx = map.get(rootVal);
        TreeNode rootNode = new TreeNode(rootVal);
        if (start == end) return rootNode;
        rootNode.setLeft(dfs(preOrder, inOrder, start, rootIdx-1));
        rootNode.setRight(dfs(preOrder, inOrder, rootIdx+1, end));

        return rootNode;


    }
    public static void main(String[] args) {

        int[] inOrder = new int[] {4,2,1,5,3,6};
        int[] preOrder = new int[] {1,2,4,3,5,6};
        for (int i=0; i<inOrder.length;i++) {
            map.put(inOrder[i], i);
        }
        TreeNode rootNode = buildTree(preOrder,inOrder);
        System.out.println(rootNode);
        Traverse.preOrderTraverseNonRecurrsive(rootNode);
//        Traverse.midOrderTraverseNonRecurrsive(rootNode);
//        Traverse.postOrderTraverseNonRecurrsive(rootNode);
    }
}
