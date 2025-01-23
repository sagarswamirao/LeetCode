class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])
        result=[intervals[0]]
        for i in range(1,len(intervals)):
            curr=intervals[i]
            if result[-1][1]<curr[0]:
                result.append(curr)
            else:
                result[-1][1]=max(result[-1][1], curr[1])
        

        return result

