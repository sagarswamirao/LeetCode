class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if n==0:
            return True
        visited=set()
        map=defaultdict(set)

        for i,j in edges:
            map[i].add(j)
            map[j].add(i)
        count=[0]
        def dfs(node,parent):
            if node in visited:
                return False
            count[0]+=1
            visited.add(node)
            for nei in map[node]:
                if nei==parent:
                    continue
                if not dfs(nei, node):
                    return False

            return True

        ans=dfs(0,-1)        
        return  ans and count[0]==n