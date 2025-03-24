class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        no_meeting_count=days
        meetings.sort(key= lambda x:x[0])
        stack=[]

        for curr_meeting in meetings:
            if len(stack)==0 or stack[-1][1]<curr_meeting[0]:
                stack.append(list(curr_meeting))
            else:
                updated_start=min(stack[-1][0], curr_meeting[0])
                updated_end=max(stack[-1][1], curr_meeting[1])
                stack[-1]=[updated_start, updated_end]

        while stack:
            item= stack.pop()
            no_meeting_count-= (item[1]-item[0]+1)
        return no_meeting_count
