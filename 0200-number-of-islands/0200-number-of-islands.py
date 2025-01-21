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
                    self.worker(grid, r, c, len(grid), len(grid[0]))
        return num_islands

    def worker(self, grid, curr_r, curr_c, rows, cols):
        if curr_r<0 or curr_c<0 or curr_r>=rows or curr_c>=cols or grid[curr_r][curr_c]=="0":
            return 
        grid[curr_r][curr_c]="0"

        self.worker(grid, curr_r+1, curr_c, rows, cols)
        self.worker(grid, curr_r, curr_c+1, rows, cols)
        self.worker(grid, curr_r-1, curr_c, rows, cols)
        self.worker(grid, curr_r, curr_c-1, rows, cols)

        