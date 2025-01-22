class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        """
        Counts the number of islands in the given grid.
        An island is a group of connected '1's (land), where connections are horizontal or vertical.
        
        Time Complexity: O(m * n) - Every cell is visited once.
        Space Complexity: O(m * n) - Recursion stack in the worst case (if all cells are land).
        
        Parameters:
        grid (List[List[str]]): A 2D grid where '1' represents land and '0' represents water.

        Returns:
        int: The number of distinct islands.
        """
        # Initialize the count of islands to 0.
        num_islands = 0
        
        # Iterate through each cell in the grid.
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                # If the cell contains '1' (unvisited land), it's a new island.
                if grid[r][c] == "1":
                    num_islands += 1  # Increment the island count.
                    
                    # Send a "worker" to explore the entire island.
                    self.worker(grid, r, c, len(grid), len(grid[0]))
        
        # Return the total number of islands found.
        return num_islands

    def worker(self, grid: List[List[str]], curr_r: int, curr_c: int, rows: int, cols: int) -> None:
        """
        Recursively marks all connected '1's of the current island as '0' (visited).
        
        Time Complexity: O(1) per cell (constant time to visit and mark each cell).
        Space Complexity: O(m * n) in the worst case due to the recursion stack.

        Parameters:
        grid (List[List[str]]): The grid representing the map of islands and water.
        curr_r (int): The current row index.
        curr_c (int): The current column index.
        rows (int): The total number of rows in the grid.
        cols (int): The total number of columns in the grid.
        """
        # Base case: Stop recursion if out of bounds or the cell is water ('0').
        if curr_r < 0 or curr_c < 0 or curr_r >= rows or curr_c >= cols or grid[curr_r][curr_c] == "0":
            return 
        
        # Mark the current cell as visited by setting it to '0'.
        grid[curr_r][curr_c] = "0"

        # Recursively explore all four directions (down, right, up, left).
        self.worker(grid, curr_r + 1, curr_c, rows, cols)  # Down
        self.worker(grid, curr_r, curr_c + 1, rows, cols)  # Right
        self.worker(grid, curr_r - 1, curr_c, rows, cols)  # Up
        self.worker(grid, curr_r, curr_c - 1, rows, cols)  # Left
