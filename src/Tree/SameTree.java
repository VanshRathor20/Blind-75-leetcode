package Tree;

public class SameTree {
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

    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;

        boolean left=isSameTree(p.left,q.left);
        boolean right=isSameTree(p.right,q.right);

        return left && right;
    }

    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        root1.left=new TreeNode(2);
        root1.right=new TreeNode(3);

        TreeNode root2=new TreeNode(1);
        root2.left=new TreeNode(2);
        root2.right=new TreeNode(3);

        SameTree obj=new SameTree();
        boolean result=obj.isSameTree(root1,root2);
        System.out.println("Are the two trees the same? " + result);
    }
}
