# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        ans=[]
        if root is None:
            return ans
        queue=deque([root])

        
        while len(queue)>0:
            popValue=None
            for i in range(len(queue)):
                item=queue.popleft()
                popValue=item.val
                if item.left:
                    queue.append(item.left)
                if item.right:
                    queue.append(item.right)

            if popValue is not None:
                ans.append(popValue)
                
        return ans