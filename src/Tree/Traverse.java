package Tree;

import General.TreeNode;
import java.util.Stack;

/**
 *      a
 *     / \
 *    b   c
 *   / \ / \
 *  d  e f  g
 */
public class Traverse {
    public static void preOrderTraverse (TreeNode root) {
        if (root == null) return;
        System.out.print(root.getValue() + " --> ");
        preOrderTraverse(root.getLeft());
        preOrderTraverse(root.getRight());
    }

    public static void preOrderTraverseNonRecurrsive (TreeNode root) {
        Stack stack = new Stack();
        while (root!=null || !stack.isEmpty()) {

            while (root!=null) {
                System.out.print(root.getValue() + " --> ");
                stack.push(root);
                root = root.getLeft();
            }
            if (!stack.isEmpty()) {
                root = (TreeNode) stack.pop();
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
        Stack stack = new Stack();
        while (root!=null || !stack.isEmpty()) {

            while (root!=null) {
                stack.push(root);
                root = root.getLeft();
            }

            if (!stack.isEmpty()) {
                root = (TreeNode) stack.pop();
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
        Stack stack = new Stack();
        while (root!=null || !stack.isEmpty()) {
            while (root!=null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (!stack.isEmpty()) {
                root = (TreeNode) stack.pop();
                if (root.getRight()!=null) {
                    System.out.print(root.getRight().getValue() + " --> ");
                    System.out.print(root.getValue() + " --> ");
                    if (!stack.isEmpty()) {
                        root = (TreeNode) stack.pop();
                    }
                }

                else {

                System.out.print(root.getValue() + " --> ");
                }
                root = root.getRight();
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
