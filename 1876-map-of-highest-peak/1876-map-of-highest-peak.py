class Solution:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        rows, cols=len(isWater), len(isWater[0])
        result=[[-1] * cols for i in range(rows)]
        queue=deque()
        for i in range(rows):
            for j in range(cols):
                if isWater[i][j]==1:
                    queue.append((i,j,0))
        
        while queue:
            item=queue.popleft()
            i=item[0]
            j=item[1]
            height=item[2]
            if i<0 or j<0 or i>=rows or j>=cols or result[i][j]!=-1:
                continue

            result[i][j]=height
            queue.append((i+1,j,height+1))
            queue.append((i,j+1,height+1))
            queue.append((i-1,j,height+1))
            queue.append((i,j-1,height+1))
            
        return result