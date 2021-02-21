package General;

public class TreeNode {

    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode(String value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
        this.value = String.valueOf(value);
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = String.valueOf(value);
        this.left = left;
        this.right = right;
    }

    public TreeNode(String value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    TreeNode left;
    TreeNode right;

    @Override
    public String toString() {
        return value;
    }

    public TreeNode () {

    }
}
