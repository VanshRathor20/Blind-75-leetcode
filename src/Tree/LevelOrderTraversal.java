package Tree;

import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    
    public List<List<Integer>> levelOrder(InvertBinaryTree.TreeNode root){
        Queue<InvertBinaryTree.TreeNode> q = new java.util.LinkedList<>();
        List<List<Integer>> ans = new java.util.ArrayList<>();
        if(root==null) return ans;

        q.add(root);
        while(!q.isEmpty()){
            List<Integer> level= new java.util.ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                InvertBinaryTree.TreeNode node=q.poll();
                level.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        InvertBinaryTree.TreeNode root = new InvertBinaryTree.TreeNode(1);
        root.left = new InvertBinaryTree.TreeNode(2);
        root.right = new InvertBinaryTree.TreeNode(3);
        root.left.left = new InvertBinaryTree.TreeNode(4);
        root.left.right = new InvertBinaryTree.TreeNode(5);

        LevelOrderTraversal lot = new LevelOrderTraversal();
        List<List<Integer>> result = lot.levelOrder(root);
        System.out.println(result); // Output: [[1], [2, 3], [4, 5]]
    }
}
