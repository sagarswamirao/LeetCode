class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        max_area=0
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c]==1:
                    curr_area=[0]
                    self.worker(grid, r, c, len(grid)-1, len(grid[0])-1, curr_area)
                    max_area = max(max_area, curr_area[0])
        return max_area

    def worker(self, grid, curr_r, curr_c, max_r, max_c, curr_area):
        grid[curr_r][curr_c]=0
        curr_area[0]+=1
        directions=[[-1,0],[1,0],[0,-1],[0,1]]
        for direction in directions:
            dr, dc=direction
            next_r=curr_r+dr
            next_c=curr_c+dc

            if next_r>=0 and next_r<=max_r and next_c>=0 and next_c<=max_c:
                if grid[next_r][next_c]==1:
                    self.worker(grid, next_r, next_c, max_r, max_c, curr_area)
        