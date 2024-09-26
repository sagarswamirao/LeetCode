class MyCalendar {
    SortedSet<int[]> sSet;
    public MyCalendar() {
        sSet=new TreeSet<>((k1,k2)->{
            return k1[0] - k2[0];
        });
    }
    
    public boolean book(int start, int end) {
        if(start>=end) return false;
        for(int[] event:sSet){
            if((start>=event[0] && start<event[1]) || (end>event[0] && end<=event[1]) || (start<=event[0] && end>=event[1])){
                return false;
            }
        }
        sSet.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */