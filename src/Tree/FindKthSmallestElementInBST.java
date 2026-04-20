package Tree;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}

public class FindKthSmallestElementInBST {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) return;

        inOrderTraversal(node.left, k);
        count++;
        if (count == k) {
            result = node.data;
            return;
        }
        inOrderTraversal(node.right, k);
    }

    public static void main(String[] args) {
        FindKthSmallestElementInBST solution = new FindKthSmallestElementInBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int k = 3;
        int kthSmallest = solution.kthSmallest(root, k);
        System.out.println("The " + k + "rd smallest element in the BST is: " + kthSmallest);
    }
}
