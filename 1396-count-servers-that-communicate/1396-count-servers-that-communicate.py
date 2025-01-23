class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0

        rows=len(grid)
        cols=len(grid[0])
        row_counts = [0] * len(grid)
        col_counts = [0] * len(grid[0])

        # Count servers in each row and each column
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col]:
                    row_counts[row] += 1
                    col_counts[col] += 1
        
        communicable_servers_count = 0

        # Count servers that can communicate (in the same row or column)
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col]:
                    if row_counts[row] > 1 or col_counts[col] > 1:
                        communicable_servers_count += 1

        return communicable_servers_count
            
