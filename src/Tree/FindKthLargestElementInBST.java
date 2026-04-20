package Tree;


public class FindKthLargestElementInBST {
    private int count = 0;
    private int result = -1;

    public int kthLargest(TreeNode root, int k) {
        reverseInOrderTraversal(root, k);
        return result;
    }

    private void reverseInOrderTraversal(TreeNode node, int k) {
        if (node == null) return;

        reverseInOrderTraversal(node.right, k);
        count++;
        if (count == k) {
            result = node.data;
            return;
        }
        reverseInOrderTraversal(node.left, k);
    }

    public static void main(String[] args) {
        FindKthLargestElementInBST solution = new FindKthLargestElementInBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int k = 3;
        int kthLargest = solution.kthLargest(root, k);
        System.out.println("The " + k + "rd largest element in the BST is: " + kthLargest);
    }
}
