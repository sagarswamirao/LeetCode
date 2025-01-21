class Solution:
    def alienOrder(self, words: List[str]) -> str:
        # Create an adjacency list to represent the graph.
        # Each character in the words will have an empty set as its value initially.
        adj = {c: set() for w in words for c in w}

        # Build the graph by comparing adjacent words.
        for i in range(len(words) - 1):
            w1, w2 = words[i], words[i + 1]
            min_length = min(len(w1), len(w2))

            # If the first `min_length` characters of w1 and w2 are the same, 
            # but w1 is longer than w2, it violates lexicographical order.
            if len(w1) > len(w2) and w1[:min_length] == w2[:min_length]:
                return ""

            # Compare characters of the two words to find the first mismatch.
            # Create a directed edge from the character in w1 to the character in w2.
            for j in range(min_length):
                if w1[j] != w2[j]:
                    adj[w1[j]].add(w2[j])
                    break

        # Initialize a dictionary to keep track of visited nodes during DFS.
        # True indicates the node is being visited (part of the current path).
        # False indicates the node has already been processed (no cycle from this node).
        visited = {}

        # Initialize a list to store the topological order of characters.
        result = []

        # Helper function to perform DFS and check for cycles.
        def dfs_to_check_if_cycle_exists(c):
            # If the node has already been visited, return its state.
            if c in visited:
                return visited[c]

            # Mark the node as being visited.
            visited[c] = True

            # Recursively visit all neighbors.
            for nei in adj[c]:
                # If any neighbor leads to a cycle, return True.
                if dfs_to_check_if_cycle_exists(nei):
                    return True

            # Mark the node as processed (no cycle found from this node).
            visited[c] = False

            # Append the character to the result list (post-order traversal).
            result.append(c)

        # Perform DFS for each character in the adjacency list.
        for c in adj:
            if dfs_to_check_if_cycle_exists(c):
                return ""

        # Reverse the result list to get the correct topological order.
        result.reverse()

        # Return the topological order as a string.
        return "".join(result)
