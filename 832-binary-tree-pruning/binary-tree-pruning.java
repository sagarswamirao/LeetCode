/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        root=dfs(root);
        return root;
    }

    public TreeNode dfs(TreeNode root){
        if(root.left!=null){
        root.left=dfs(root.left);
        }
        if(root.right!=null){
        root.right=dfs(root.right);
        }
        if(root.left==null && root.right==null){
            if(root.val==1)
                return root;
            else
                return null;
        }
        return root;
    }       
}