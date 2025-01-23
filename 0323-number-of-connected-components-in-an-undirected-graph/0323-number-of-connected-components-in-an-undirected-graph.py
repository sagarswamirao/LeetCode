from typing import List

class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        parent=[i for i in range(n)]

        def find(x):
            if parent[x]!=x:
                parent[x]=find(parent[x])
            return parent[x]
            

        def union(x1, x2):
            root1 = find(x1)
            root2 = find(x2)
            parent[root2] = root1

        for i,j in edges:
            union(i,j)
        
        return len(set(find(x) for x in range(n)))

# METHOD 2: DFS + COUNTER
    # def countComponents(self, n: int, edges: List[List[int]]) -> int:
    #     # Initialize a visited array to keep track of visited nodes during DFS.
    #     # Time complexity for initialization: O(n)
    #     # Space complexity: O(n), where n is the number of nodes.
    #     visited = [False] * n

    #     # Create an adjacency list to represent the graph.
    #     # Each node maps to a set of its neighbors.
    #     # Time complexity for building the adjacency list: O(E), where E is the number of edges.
    #     # Space complexity: O(V + E), where V is the number of nodes.
    #     adj_list = {i: set() for i in range(n)}
    #     for i, j in edges:
    #         adj_list[i].add(j)  # Add edge from node i to node j.
    #         adj_list[j].add(i)  # Add edge from node j to node i (undirected graph).

    #     # Helper function to perform DFS and explore all connected nodes.
    #     def dfs_explore(node):
    #         # Mark the current node as visited.
    #         visited[node] = True

    #         # Explore all unvisited neighbors of the current node.
    #         for nei in adj_list[node]:
    #             if not visited[nei]:
    #                 dfs_explore(nei)

    #     # Initialize a counter for connected components.
    #     count_components = 0

    #     # Iterate through all nodes to check if they have been visited.
    #     # If a node is not visited, it starts a new connected component.
    #     for i in range(n):
    #         if not visited[i]:
    #             count_components += 1  # Increment the connected components counter.
    #             dfs_explore(i)  # Perform DFS to mark all nodes in this component as visited.

    #     # Return the total count of connected components in the graph.
    #     return count_components
