# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        arr=[]
        self.recursive(root, arr)
        return arr

    def recursive(self, root, arr):
        if root is None:
            return 
        self.recursive(root.left, arr)  
        arr.append(root.val)
        self.recursive(root.right, arr)  
