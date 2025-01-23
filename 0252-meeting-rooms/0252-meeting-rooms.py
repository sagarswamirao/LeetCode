class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        intervals.sort(key=lambda x: x[0])

        for i in range(len(intervals)-1):
            m1, m2=intervals[i],intervals[i+1]
            if m1[1]>m2[0]:
                return False 

        return True