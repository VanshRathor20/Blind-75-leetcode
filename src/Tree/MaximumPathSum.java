package Tree;

public class MaximumPathSum {
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;

        int leftSum=Math.max(0,helper(root.left));
        int rightSum=Math.max(0,helper(root.right));
        maxSum=Math.max(maxSum,root.val+leftSum+rightSum);
        return root.val+Math.max(leftSum,rightSum);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumPathSum mps = new MaximumPathSum();
        int result = mps.maxPathSum(root);
        System.out.println(result); // Output: 42
    }
}
