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
    public int maxDepth(TreeNode root) {
       Queue<Pair<TreeNode,Integer>> queue=new LinkedList<>();
       queue.offer(new Pair<>(root,1));
       int max_depth=0;
       while(!queue.isEmpty()){
        Pair<TreeNode,Integer> pair=queue.poll();
        TreeNode node=pair.getKey();
        Integer height=pair.getValue();
        if(node==null){
            continue;
        }
        max_depth=Math.max(max_depth, height);
        if(node.left!=null){
            queue.offer(new Pair<>(node.left,height+1));
        }
        if(node.right!=null){
            queue.offer(new Pair<>(node.right,height+1));
        }
       } 
       return max_depth;
    }
}