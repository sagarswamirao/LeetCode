class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        rows=len(heights)
        cols=len(heights[0])
        alt_set=set()
        pac_set=set()

        for j in range(cols):
            self.dfs(heights, pac_set, 0 , j, rows, cols, heights[0][j])
            self.dfs(heights, alt_set, rows-1 , j, rows, cols, heights[rows-1][j])

        for i in range(rows):
            self.dfs(heights, pac_set, i , 0, rows, cols, heights[i][0])
            self.dfs(heights, alt_set, i , cols-1, rows, cols, heights[i][cols-1])

        result=[]

        for i in range(rows):
            for j in range(cols):
                if (i,j) in pac_set and (i,j) in alt_set:
                    result.append([i,j])
        
        return result

    #if in visited_set then route exists
    def dfs(self, heights, visited_set, i,j,rows,cols, prev_height):
        if (i,j) in visited_set or i<0 or j<0 or i>=rows or j>=cols or heights[i][j]<prev_height:
            return 
        visited_set.add((i,j))

        self.dfs(heights, visited_set, i-1 , j, rows, cols, heights[i][j])
        self.dfs(heights, visited_set, i , j-1, rows, cols, heights[i][j])
        self.dfs(heights, visited_set, i , j+1, rows, cols, heights[i][j])
        self.dfs(heights, visited_set, i+1 , j, rows, cols, heights[i][j])