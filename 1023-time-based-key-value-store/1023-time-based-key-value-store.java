//Refer Neetcode for binary search method
// https://neetcode.io/solutions/time-based-key-value-store
// class TimeMap {
//     private Map<String, TreeMap<Integer, String>> m;

//     public TimeMap() {
//         m = new HashMap<>();
//     }

//     public void set(String key, String value, int timestamp) {
//         m.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
//     }

//     public String get(String key, int timestamp) {
//         if (!m.containsKey(key)) return "";
//         TreeMap<Integer, String> timestamps = m.get(key);
//         Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);
//         return entry == null ? "" : entry.getValue();
//     }
// }

//SSRK Own Approach
class TimeMap {
    private HashMap<String, HashMap<String, Integer>> hMap;
    public TimeMap() {
        this.hMap=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // if(!this.hMap.containsKey(key)){
        //     this.hMap.put(key, new HashMap<>());
        // }
        this.hMap.computeIfAbsent(key, k -> new HashMap<>()).put(value,timestamp);
    }
    
    public String get(String key, int timestamp) {

        if(this.hMap.size()==0 || !this.hMap.containsKey(key)){
            return "";
        }
        
        int nearest_timestamp=0;
        String nearestValue="";
        for(Map.Entry<String, Integer> entry:this.hMap.get(key).entrySet()){
            Integer curr_timestamp=entry.getValue();
            String curr_value=entry.getKey();
            if(curr_timestamp>timestamp){
                continue;
            }
            if(nearest_timestamp<curr_timestamp){
                nearestValue=curr_value;
                nearest_timestamp=curr_timestamp;
            }
        }
        return nearestValue;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */