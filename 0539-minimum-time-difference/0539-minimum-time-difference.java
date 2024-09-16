class Solution {
    public int findMinDifference(List<String> timePoints) {
        TreeSet<Integer> tSet=new TreeSet<>();
        for(String timePoint: timePoints){
            String[] split=timePoint.split(":");
            int minutes= Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
            if(tSet.contains(minutes)){
                return 0;
            }
            tSet.add(minutes);
        }
        
        Integer minimalDifference=Math.abs((24*60)-tSet.getLast() + tSet.getFirst());
        Integer previousElement=tSet.last();
        for(Integer key:tSet){
            minimalDifference=Math.min(minimalDifference, Math.abs(key-previousElement));
            previousElement=key;
        }
        return minimalDifference;
    }
}