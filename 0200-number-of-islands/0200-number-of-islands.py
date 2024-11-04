class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #we need worker to visit one island only and come back; we will send i workers to visit i islands
        # we know find i find an island, then we will send a worker and wait for him to explore and come back
        #keep count of workers sent

        num_islands=0
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c]=="1":
                    num_islands+=1
                    self.worker(grid, r, c, len(grid)-1, len(grid[0])-1)
        return num_islands

    def worker(self, grid, curr_r, curr_c, max_r, max_c):
        grid[curr_r][curr_c]="0"
        directions=[[-1,0],[1,0],[0,-1],[0,1]]
        for direction in directions:
            dr, dc=direction
            next_r=curr_r+dr
            next_c=curr_c+dc

            if next_r>=0 and next_r<=max_r and next_c>=0 and next_c<=max_c:
                if grid[next_r][next_c]=="1":
                    self.worker(grid, next_r, next_c, max_r, max_c)
        