"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        #
        if not node:
            return None
            
        nodes_dict={}
        def get_node(val):
            if val not in nodes_dict:
                nodes_dict[val]=Node(val)
            return nodes_dict[val]

        queue=deque()
        queue.append(node)
        
        while queue:
            curr_node=queue.popleft()
            cloned_node=get_node(curr_node.val)
            if len(cloned_node.neighbors)>0:
                continue
                
            for neighbor in curr_node.neighbors:
                cloned_node.neighbors.append(get_node(neighbor.val))
                queue.append(neighbor)
    
        return nodes_dict[1]