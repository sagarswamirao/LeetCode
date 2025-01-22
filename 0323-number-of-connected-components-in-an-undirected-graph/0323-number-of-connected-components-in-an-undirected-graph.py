class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        visited=[False]*n
        adj_list={i:set() for i in range(n)}
        for i,j in edges:
            adj_list[i].add(j)
            adj_list[j].add(i)

        def dfs_explore(node):
            if visited[node]:
                return
            visited[node]=True
            for nei in adj_list[node]:
                if not visited[nei]:
                    dfs_explore(nei)

        count_components=0
        for i in range(n):
            if not visited[i]:
                count_components+=1
                dfs_explore(i)
        
        return count_components
