import heapq
class MedianFinder:

    def __init__(self):
        self.total=0
        self.minHeapForLargeNums=[]
        self.maxHeapForSmallNums=[]
    def addNum(self, num: int) -> None:
        if len(self.maxHeapForSmallNums)==0 or len(self.minHeapForLargeNums)+1 > len(self.maxHeapForSmallNums):
            heapq.heappush(self.maxHeapForSmallNums, -num)
        else:
            heapq.heappush(self.minHeapForLargeNums, num)
        
        if (len(self.maxHeapForSmallNums)!=0 and len(self.minHeapForLargeNums)!=0):
            while -self.maxHeapForSmallNums[0]>self.minHeapForLargeNums[0]:
                ele=heapq.heappop(self.maxHeapForSmallNums)
                ele1=heapq.heappop(self.minHeapForLargeNums)
                heapq.heappush(self.maxHeapForSmallNums,-ele1)
                heapq.heappush(self.minHeapForLargeNums,-ele)

        self.total+=num

    def findMedian(self) -> float:
        if (len(self.maxHeapForSmallNums)+ len(self.minHeapForLargeNums))%2==0:
            return (-self.maxHeapForSmallNums[0]+self.minHeapForLargeNums[0])/2
            # return self.total/(len(self.maxHeapForSmallNums)+len(self.minHeapForLargeNums))
        else:
            return -self.maxHeapForSmallNums[0]


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()