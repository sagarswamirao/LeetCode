class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x: x[1])
        ans = 0
        prev_max_end_time = -inf
        
        for curr_start, curr_end in intervals:
            if curr_start >= prev_max_end_time:
                # Case 1         curr_start >= curr_max_end_time
                prev_max_end_time = curr_end
            else:
                # Case 2         curr_start < curr_max_end_time
                ans += 1
        
        return ans