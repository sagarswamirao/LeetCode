class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        

        cache={}

        return self.dfs(0, 0, m-1, n-1, set(),cache)

    def dfs(self,curr_i, curr_j, max_i, max_j, visited, cache):
        if curr_i==max_i and curr_j==max_j:
            return 1
        if (curr_i, curr_j) in cache:
            return cache[(curr_i, curr_j)]

        directions=[[0,1],[1,0]]
        ans=0
        for dx, dy in directions:
            next_i=curr_i+dx
            next_j=curr_j+dy
            if next_i<0 or next_i>max_i or next_j<0 or next_j>max_j:
                continue
                
            if (next_i,next_j) not in visited:
                visited.add((next_i,next_j))
                ans+=self.dfs(next_i, next_j, max_i, max_j, visited, cache)
                visited.remove((next_i,next_j))
            cache[(curr_i, curr_j)]=ans
        return ans