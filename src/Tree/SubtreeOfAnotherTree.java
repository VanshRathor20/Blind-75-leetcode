package Tree;

public class SubtreeOfAnotherTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String treeA = serialize(root);
        String treeB = serialize(subRoot);
        return treeA.contains(treeB);
    }private String serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        preOrder(node, sb);
        return sb.toString();
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(",null");
            return;
        }
        sb.append(",").append(node.val);
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();
        boolean result = solution.isSubtree(root, subRoot);
        System.out.println(result); // Output: true
    }



}
