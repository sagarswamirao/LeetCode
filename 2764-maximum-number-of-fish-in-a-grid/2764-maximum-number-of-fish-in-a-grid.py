class Solution:
    def findMaxFish(self, grid: List[List[int]]) -> int:
        visited_set=set()

        rows=len(grid)
        cols=len(grid[0])

        max_count=0

        def dfs(r,c):
            if r<0 or r>=rows or c<0 or c>=cols or grid[r][c]==0 or (r,c) in visited_set:
                return 0

            visited_set.add((r,c))

            l=dfs(r+1, c)
            m=dfs(r, c+1)
            n=dfs(r-1, c)
            o=dfs(r, c-1)

            return (grid[r][c] + l + m + n +o)
            

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] > 0 and (r,c) not in visited_set:
                    curr_count=dfs(r, c)
                    max_count=max(max_count, curr_count)
        return max_count