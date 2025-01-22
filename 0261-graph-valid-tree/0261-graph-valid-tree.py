from collections import defaultdict
from typing import List

class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        # If there are no nodes (n == 0), the graph is trivially a valid tree.
        if n == 0:
            return True

        # A set to keep track of visited nodes during DFS to detect cycles and ensure connectivity.
        visited = set()

        # A defaultdict to represent the adjacency list of the graph.
        # Each node will map to a set of its neighbors.
        map = defaultdict(set)

        # Build the adjacency list for the graph.
        # Time complexity: O(E), where E is the number of edges.
        # Space complexity: O(V + E), where V is the number of nodes and E is the number of edges.
        for i, j in edges:
            map[i].add(j)  # Add the edge from node i to node j.
            map[j].add(i)  # Add the edge from node j to node i (undirected graph).

        # Helper function to perform Depth First Search (DFS) on the graph.
        # Parameters:
        # - node: the current node being visited.
        # - parent: the parent of the current node in the DFS tree.
        def dfs(node, parent):
            # If the node is already visited, a cycle is detected. Return False.
            if node in visited:
                return False

            # Mark the current node as visited.
            visited.add(node)

            # Iterate through the neighbors of the current node.
            for nei in map[node]:
                # Skip the parent node to avoid falsely detecting a cycle.
                if nei == parent:
                    continue

                # Recursively call DFS on the neighbor.
                # If the DFS for any neighbor returns False, the graph is not a tree.
                if not dfs(nei, node):
                    return False

            # If no issues were found, return True.
            return True

        # Start the DFS from node 0 with no parent (-1).
        # Time complexity of DFS: O(V + E), where V is the number of nodes and E is the number of edges.
        # Space complexity: O(V) for the recursion stack and the visited set.
        ans = dfs(0, -1)

        # The graph is a valid tree if:
        # 1. The DFS traversal does not detect any cycles (ans == True).
        # 2. All nodes are visited during the DFS (len(visited) == n), ensuring the graph is connected.
        return ans and len(visited) == n
