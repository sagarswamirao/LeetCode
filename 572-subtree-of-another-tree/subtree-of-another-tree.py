# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        queue=deque([root])
        while queue:
            item=queue.popleft()
            if item.val==subRoot.val:
                if self.isValidSubTree(item,subRoot):
                    return True            
            
            if item.left:
                queue.append(item.left)

            if item.right:
                queue.append(item.right)
        
        return False
    
    def isValidSubTree(self,t1, t2):
        queue=deque()
        queue.append([t1,t2])
        while queue:
            item1, item2=queue.popleft()
            if (item1!=None and item2==None) or (item1==None and item2!=None):
                return False
            if item1.val != item2.val:
                return False

            if not (item1.left==None and item2.left==None):
                queue.append([item1.left, item2.left])
            if not (item1.right==None and item2.right==None):
                queue.append([item1.right, item2.right])

        return True