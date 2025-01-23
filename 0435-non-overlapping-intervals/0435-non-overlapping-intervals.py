class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x: x[1])
        ans = 0
        curr_max_end_time = -inf
        
        for start, end in intervals:
            if start >= curr_max_end_time:
                # Case 1         start >= curr_max_end_time
                curr_max_end_time = end
            else:
                # Case 2         start < curr_max_end_time
                ans += 1
        
        return ans