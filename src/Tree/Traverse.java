package Tree;

import General.TreeNode;
import java.util.Stack;

/**
 *      a
 *     / \
 *    b   c
 *   / \ / \
 *  d  e f  g
 *
 *  三种遍历的非递归算法异同点分析：
 *  1）三种遍历都是一直找左子树
 *  2）其中先序遍历找左子树过程中先遍逐层遍历根节点，然后在抵达最远左子树时倒序遍历左右节点
 *  3）中序遍历直到抵达最远左子树开始遍历左节点和父节点
 *  4）后序遍历难点在于，抵达最远左子树后要先访问左右节点最后才是父节点。需要额外变量储存上次遍历节点信息，
 *  以此判断是否遍历过右节点。如果无则遍历右节点，并将父节点入栈。若非则回退遍历父节点。
 *
 */
public class Traverse {
    public static void preOrderTraverse (TreeNode root) {
        if (root == null) return;
        System.out.print(root.getValue() + " --> ");
        preOrderTraverse(root.getLeft());
        preOrderTraverse(root.getRight());
    }

    public static void preOrderTraverseNonRecurrsive (TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        while (root!=null || !stack.isEmpty()) {

            while (root!=null) {
                System.out.print(root.getValue() + " --> ");
                stack.push(root);
                root = root.getLeft();
            }
            if (!stack.isEmpty()) {
                root =  stack.pop();
                root = root.getRight();
            }
        }
    }


    public static void midOrderTraverse (TreeNode root) {
        if (root == null) return;
        midOrderTraverse(root.getLeft());
        System.out.print(root.getValue() + " --> ");
        midOrderTraverse(root.getRight());
    }

    public static void midOrderTraverseNonRecurrsive (TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        while (root!=null || !stack.isEmpty()) {

            while (root!=null) {
                stack.push(root);
                root = root.getLeft();
            }

            if (!stack.isEmpty()) {
                root =  stack.pop();
                System.out.print(root.getValue() + " --> ");
                root = root.getRight();
            }
        }
    }


    public static void postOrderTraverse (TreeNode root) {
        if (root == null) return;
        postOrderTraverse(root.getLeft());
        postOrderTraverse(root.getRight());
        System.out.print(root.getValue() + " --> ");
    }

    public static void postOrderTraverseNonRecurrsive (TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode prev = null;
        while (root!=null || !stack.isEmpty()) {
            while (root!=null) {
                stack.push(root);
                root = root.getLeft();
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                //IMPORTANT: filter out case when right leaf is traversed using second condition
                if (root.getRight() != null && !prev.equals(root.getRight())) {
                    stack.push(root);
                    root = root.getRight();
                }
                else {
                    System.out.print(root.getValue() + " --> ");
                    prev = root;
                    root = null;     //set to null to get directly into line 87
                }
            }
        }

    }

    public static void main(String[] args) {
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
        TreeNode g = new TreeNode("g");
        TreeNode b = new TreeNode("b", d, e);
        TreeNode c = new TreeNode("c", f, g);
        TreeNode a = new TreeNode("a", b, c);
        System.out.println("Result for preOrderTraverse:");
        preOrderTraverse(a);
        System.out.println("\nResult for preOrderTraverseNonRecurrsive:");
        preOrderTraverseNonRecurrsive (a);
        System.out.println("\nResult for midOrderTraverse:");
        midOrderTraverse(a);
        System.out.println("\nResult for midOrderTraverseNonRecurrsive:");
        midOrderTraverseNonRecurrsive(a);
        System.out.println("\nResult for postOrderTraverse:");
        postOrderTraverse(a);
        System.out.println("\nResult for postOrderTraverseNonRecurrsive:");
        postOrderTraverseNonRecurrsive(a);
    }
}
