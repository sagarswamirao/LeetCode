# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        dummy=[]
        count=[k]

        def inOrderWithCounter(root):
            if root==None:
                return
            
            inOrderWithCounter(root.left)

            count[0]-=1
            if count[0]==0:
                dummy.append(root.val)
            inOrderWithCounter(root.right)
    
        
        inOrderWithCounter(root)

        return dummy[0]