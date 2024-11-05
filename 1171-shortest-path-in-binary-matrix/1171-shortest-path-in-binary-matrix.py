class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        n=len(grid)-1
        queue=deque()
        if grid[0][0]==1: 
            return -1
        grid[0][0]=1
        queue.append((0,0))
        directions=[[1,0],[0,1],[-1,0],[0,-1],[1,1],[-1,-1],[-1,1],[1,-1]]
        while queue:
            x,y=queue.popleft()
            if x==n and y==n:
                return grid[x][y]

            for dx, dy in directions:
                next_x=x+dx
                next_y=y+dy

                if next_x<0 or next_x>n or next_y<0 or next_y>n:
                    continue
                
                if grid[next_x][next_y]==0:
                    grid[next_x][next_y]=(grid[x][y]+1)
                    queue.append((next_x,next_y))
                
        return -1

