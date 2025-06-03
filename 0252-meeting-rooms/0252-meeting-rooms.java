class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int[] lastSchedule=new int[]{-1,-1};
        for(int i=0;i<intervals.length;i++){
            int[] currentSchedule=intervals[i];
            if(currentSchedule[0]<lastSchedule[1]){
                return false;
            }
            lastSchedule=currentSchedule;
        }
        
        return true;
    }
}