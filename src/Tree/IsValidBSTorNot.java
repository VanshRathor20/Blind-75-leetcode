package Tree;

public class IsValidBSTorNot {

    /**
     * Local TreeNode definition to keep this file self-contained.
     * (Other files in this repo define their own TreeNode as nested classes.)
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long minValue,long maxValue){
        if(root==null) return true;
        if(root.val<=minValue || root.val>=maxValue) return false;
        return isValidBST(root.left, minValue, root.val) &&
                isValidBST(root.right, root.val, maxValue);
    }

    public static void main(String[] args) {
            IsValidBSTorNot obj = new IsValidBSTorNot();
            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(1);
            root.right = new TreeNode(3);
            System.out.println(obj.isValidBST(root)); // Output: true

            TreeNode root2 = new TreeNode(5);
            root2.left = new TreeNode(1);
            root2.right = new TreeNode(4);
            root2.right.left = new TreeNode(3);
            root2.right.right = new TreeNode(6);
            System.out.println(obj.isValidBST(root2)); // Output: false
    }
}
