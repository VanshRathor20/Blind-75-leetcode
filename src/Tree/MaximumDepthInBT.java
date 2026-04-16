package Tree;

public class MaximumDepthInBT {
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

    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        return Math.max(lh,rh)+1;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);

        MaximumDepthInBT obj=new MaximumDepthInBT();
        int depth=obj.maxDepth(root);
        System.out.println("Maximum Depth of the Binary Tree: " + depth);
    }

}
