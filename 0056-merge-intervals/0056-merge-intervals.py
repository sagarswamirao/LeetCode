class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])
        prev=None
        result=[intervals[0]]
        for i in range(1,len(intervals)):
            next=intervals[i]
            if result[-1][1]<next[0]:
                result.append(next)
            else:
                result[-1][1]=max(result[-1][1], next[1])
        
        
        return result

