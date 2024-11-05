class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m=len(grid)-1
        n=len(grid[0])-1

        queue=deque()

        #get all the rotten oranges and put it in a queue(r,c,time)
        #go through the queue and check if it has neighbors who are fresh; if fresh, add them to the queue
        #smartly while getting the oranges, check if any fresh/rotten oranges are there
        fresh_orange_count=0
        for i in range(m+1):
            for j in range(n+1):
                if grid[i][j]==2:
                    queue.append((i,j,0))
                elif grid[i][j]==1:
                    fresh_orange_count+=1
        
        time_taken=0

        if not queue and fresh_orange_count==0: #no rotten and no fresh oranges
            return 0
        if not queue: #means not rotten orange
            return -1
        
        if fresh_orange_count==0: #nothing to rotten
            return 0
        
        directions=[[1,0], [0,1],[-1,0], [0,-1]]

        while queue:
            x,y,curr_count=queue.popleft()
            time_taken=max(time_taken,curr_count)
            for dx,dy in directions:
                next_x=x+dx
                next_y=y+dy

                if next_x<0 or next_x>m or next_y<0 or next_y>n:
                    continue
                
                if grid[next_x][next_y]==1:
                    fresh_orange_count-=1
                    grid[next_x][next_y]=2
                    queue.append((next_x,next_y,curr_count+1))
        
        return time_taken if fresh_orange_count==0 else -1