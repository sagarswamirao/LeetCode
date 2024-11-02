import heapq
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        if len(stones)==0:
            return 0
        if len(stones)==1:
            return stones[0]
        
        heap=[-x for x in stones]
        heapq.heapify(heap)

        while len(heap)>1:
            y=heapq.heappop(heap)
            x=heapq.heappop(heap)
            if x==y:
                continue
            else:
                heapq.heappush(heap, y-x)
            
        val= 0 if len(heap)==0 else -1 * heap[0]
        
        return val