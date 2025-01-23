from heapq import heappush, heappop
from typing import List

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0

        # Step 1: Sort intervals by start time
        intervals.sort(key=lambda x: x[0])

        # Step 2: Use a min-heap to track the end times of meetings
        heap = []

        # Add the end time of the first meeting
        heappush(heap, intervals[0][1])

        for i in range(1, len(intervals)):
            # If the room with the earliest end time is free, reuse it
            if heap[0] <= intervals[i][0]:
                heappop(heap)

            # Allocate a new room (push the end time of the current meeting)
            heappush(heap, intervals[i][1])

        # The size of the heap is the number of rooms needed
        return len(heap)
