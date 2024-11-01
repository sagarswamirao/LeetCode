# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False
        def recursive(root, currentSum, targetSum):
            if not (root.left or root.right):
                if currentSum+root.val==targetSum:
                    return True
                return False
            
            left, right=False, False
            if root.left:
                left= recursive(root.left, currentSum+root.val, targetSum)
            
            if root.right:
                right= recursive(root.right, currentSum+root.val, targetSum)

            return (left or right)

        return recursive(root, 0, targetSum)