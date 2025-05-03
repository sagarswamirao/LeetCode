class Point{
    public double dist;
    public int index;

    Point(double dist, int index){
        this.dist=dist;
        this.index=index;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //k is the heap size; k-closest means k-lowest, so max-heap will work
        PriorityQueue<Point> maxHeap=new PriorityQueue<>((a,b)->(int) (b.dist-a.dist));
        for(int i=0;i<points.length;i++){
            maxHeap.add(new Point(getEuclideanDistance(points[i][0], points[i][1]), i));
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int[][] ans=new int[maxHeap.size()][2];
        int i=0;
        while(!maxHeap.isEmpty()){
            Point popItem=maxHeap.poll();
            ans[i]=points[popItem.index];
            i++;
        }
        return ans;
    }

    public double getEuclideanDistance(int x2, int y2){
        int x1=0;
        int y1=0;
        return Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2);
    }
}