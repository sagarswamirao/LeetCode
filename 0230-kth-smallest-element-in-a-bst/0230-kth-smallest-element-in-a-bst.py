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
        self.inOrderWithCounter(root, count,dummy)
        return dummy[0]

    def inOrderWithCounter(self, root, count, dummy):
        if root==None:
            return
        self.inOrderWithCounter(root.left, count, dummy)
        count[0]-=1
        if count[0]==0:
            dummy.append(root.val)
        self.inOrderWithCounter(root.right, count, dummy)