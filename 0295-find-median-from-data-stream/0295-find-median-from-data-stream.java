class MedianFinder {

    PriorityQueue<Integer> minHeapForLargeNums;
    PriorityQueue<Integer> maxHeapForSmallNums;

    public MedianFinder() {
        maxHeapForSmallNums = new PriorityQueue<>(Collections.reverseOrder());
        minHeapForLargeNums = new PriorityQueue<>();
    }

    public void addNum(int num) {
            PriorityQueue<Integer> minHeapForLargeNums1=minHeapForLargeNums;
            PriorityQueue<Integer> maxHeapForSmallNums1=maxHeapForSmallNums;
        if (maxHeapForSmallNums.size() == 0 || maxHeapForSmallNums.peek() >= num) {
            maxHeapForSmallNums.offer(num);
            if (maxHeapForSmallNums.size() > minHeapForLargeNums.size()+ 1 ) {
                minHeapForLargeNums.offer(maxHeapForSmallNums.poll());
            }
        } else {
            minHeapForLargeNums.offer(num);
            if (minHeapForLargeNums.size() > maxHeapForSmallNums.size()) {
                maxHeapForSmallNums.offer(minHeapForLargeNums.poll());
            }
        }

    }

    public double findMedian() {
        int total = minHeapForLargeNums.size() + maxHeapForSmallNums.size();
        if (total == 0) {
            return 0;
        }
        int b = minHeapForLargeNums.size() != 0 ? minHeapForLargeNums.peek() : 0;
        int a = maxHeapForSmallNums.size() != 0 ? maxHeapForSmallNums.peek() : 0;
        if (total % 2 == 0) {
            return (a + b) / (double) 2;
        } else {
            return a;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */