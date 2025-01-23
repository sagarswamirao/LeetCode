class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        result=[]
        if len(intervals)==0:
            result.append(newInterval)
            return result
        
        #iterate and put in all schedule until overlapping
        n=len(intervals)
        i=0
        while i<n and intervals[i][1]<newInterval[0]:
            result.append(intervals[i])
            i+=1

        if i>=n:
            result.append(newInterval)
            return result

        while i<n and intervals[i][0]<=newInterval[1]:
            newInterval[0]=min(newInterval[0], intervals[i][0])
            newInterval[1]=max(newInterval[1], intervals[i][1])
            i+=1
        
        result.append(newInterval)

        while i<n:
            result.append(intervals[i])
            i+=1
        
        return result