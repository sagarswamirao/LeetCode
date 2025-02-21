# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class FindElements:

    def __init__(self, root: Optional[TreeNode]):
        self.final_root=root
        self.values = set()
        temp_root=self.final_root
        def recover_tree(curr_head, curr_val):
            global values
            if not curr_head:
                return

            curr_head.val=curr_val
            self.values.add(curr_val)
            if curr_head.left:
                recover_tree(curr_head.left, (2*curr_val) +1)
            if curr_head.right:
                recover_tree(curr_head.right, (2*curr_val) +2)

        recover_tree(temp_root, 0)

    def find(self, target: int) -> bool:
        return target in self.values         

# Your FindElements object will be instantiated and called as such:
# obj = FindElements(root)
# param_1 = obj.find(target)