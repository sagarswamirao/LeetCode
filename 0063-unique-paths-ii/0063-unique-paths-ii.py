class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        cache={}
        if obstacleGrid[0][0]==1 or obstacleGrid[len(obstacleGrid)-1][len(obstacleGrid[0])-1]==1:
            return 0
        return self.dfs(obstacleGrid, 0, 0, len(obstacleGrid)-1, len(obstacleGrid[0])-1, set(),cache)

    def dfs(self,obstacleGrid, curr_i, curr_j, max_i, max_j, visited, cache):
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
                
            if (next_i,next_j) not in visited and obstacleGrid[next_i][next_j]!=1:
                visited.add((next_i,next_j))
                ans+=self.dfs(obstacleGrid, next_i, next_j, max_i, max_j, visited, cache)
                visited.remove((next_i,next_j))
            cache[(curr_i, curr_j)]=ans
        return ans       