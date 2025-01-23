class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def validBSTCheck(node, min_val=float('-inf'), max_val=float('inf')):
            # Base case: empty tree is a valid BST
            if not node:
                return True
            
            # Check if current node's value is within the valid range
            if node.val <= min_val or node.val >= max_val:
                return False
            
            # Recursively check left and right subtrees
            # For left subtree, update max_val to current node's value
            # For right subtree, update min_val to current node's value
            return (validBSTCheck(node.left, min_val, node.val) and 
                    validBSTCheck(node.right, node.val, max_val))
        
        return validBSTCheck(root)