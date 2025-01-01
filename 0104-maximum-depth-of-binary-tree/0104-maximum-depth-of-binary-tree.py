# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        queue=[]

        if root:
            queue.append(root)
        max_depth=0
        while queue:
            max_depth+=1
            size=len(queue)

            for i in range(size):
                item=queue.pop(0)
                
                if item.left:
                    queue.append(item.left)
                
                if item.right:
                    queue.append(item.right)
        
        return max_depth
