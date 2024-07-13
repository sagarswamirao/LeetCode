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
    public int minDepth(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> queue=new LinkedList<>();
        if(root==null){
            return 0;
        }
        queue.add(new Pair<>(root,1));
        while(!queue.isEmpty()){
            Pair<TreeNode,Integer> pair=queue.poll();
            TreeNode node=pair.getKey();
            if(node.left==null && node.right==null){
                return pair.getValue();
            }
            if(node.left!=null){
            queue.offer(new Pair<>(node.left,pair.getValue()+1));
            }
            
            if(node.right!=null){
            queue.offer(new Pair<>(node.right,pair.getValue()+1));
            }

        } 
        return -1;
    }
}