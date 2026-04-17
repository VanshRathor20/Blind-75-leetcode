package Tree;

public class InvertBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree solution = new InvertBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode invertedRoot = solution.invertTree(root);
        // The inverted tree should now have the structure:
        //     1
        //    / \
        //   3   2
        //      / \
        //     5   4
        System.out.println(invertedRoot.val); // 1
        System.out.println(invertedRoot.left.val); // 3
        System.out.println(invertedRoot.right.val); // 2
        System.out.println(invertedRoot.right.left.val); // 5
        System.out.println(invertedRoot.right.right.val); // 4
    }
}
