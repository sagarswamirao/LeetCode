class Solution:
    def maxPoints(self, grid: List[List[int]], queries: List[int]) -> List[int]:
        result=[0]*len(queries)
        minheap=[(grid[0][0],0,0)]

        q=[(n,i) for i,n in enumerate(queries)]
        q.sort(key=lambda x:x[0])


        ROWS=len(grid)
        COLS=len(grid[0])

        point=0

        visited=set()
        visited.add((0,0))
        for limit, index in q:
            while minheap and minheap[0][0] < limit:
                value, i, j = heappop(minheap)
                point+=1
                DIRECTIONS=[(i, j+1),(i+1, j),(i, j-1),(i-1, j)]

                for new_i, new_j in DIRECTIONS:
                    if (0<=new_i<ROWS and 0<=new_j<COLS) and (new_i, new_j) not in visited:
                        visited.add((new_i, new_j))
                        heappush(minheap, (grid[new_i][new_j],new_i,new_j))
                
            result[index]=point

        return result
