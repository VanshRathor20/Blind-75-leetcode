package Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTheBinaryTreeFromPostorderAndInorderTraversal {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        Map<Integer, Integer> inorderIndex = new HashMap<>(inorder.length * 2);
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderIndex);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd,
                                     int[] postorder, int postStart, int postEnd,
                                     Map<Integer, Integer> inorderIndex) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        Integer rootIndexObj = inorderIndex.get(rootValue);
        if (rootIndexObj == null) {
            // Invalid input (value exists in postorder but not in inorder).
            return null;
        }
        int rootIndex = rootIndexObj;

        // Defensive bounds check (in case of invalid input ranges)
        if (rootIndex < inStart || rootIndex > inEnd) {
            return null;
        }
        int leftTreeSize = rootIndex - inStart;

        root.left = buildTreeHelper(inorder, inStart, rootIndex - 1,
                postorder, postStart, postStart + leftTreeSize - 1, inorderIndex);
        root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd,
                postorder, postStart + leftTreeSize, postEnd - 1, inorderIndex);

        return root;
    }


    public static void main(String[] args) {
        ConstructTheBinaryTreeFromPostorderAndInorderTraversal solution = new ConstructTheBinaryTreeFromPostorderAndInorderTraversal();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = solution.buildTree(inorder, postorder);
        // You can add code here to print the tree or verify the structure

    }
}
