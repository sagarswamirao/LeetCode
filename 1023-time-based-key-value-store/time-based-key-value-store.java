class TimeMap {
    private Map<String, TreeMap<Integer, String>> m;

    public TimeMap() {
        m = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        m.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!m.containsKey(key)) return "";
        TreeMap<Integer, String> timestamps = m.get(key);
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}

//Brute Force
// class TimeMap {
//     private HashMap<Integer, HashMap<String, String>> hMap;
//     public TimeMap() {
//         this.hMap=new HashMap<>();
//     }
    
//     public void set(String key, String value, int timestamp) {
//         if(!this.hMap.containsKey(timestamp)){
//             this.hMap.put(timestamp, new HashMap<>());
//         }
//         this.hMap.get(timestamp).put(key,value);
//     }
    
//     public String get(String key, int timestamp) {
//         String result="";

//         if(this.hMap.size()==0){
//             return "";
//         }
//         for(int curr_timestamp=timestamp;curr_timestamp>0;curr_timestamp--){
//             if(hMap.containsKey(curr_timestamp) && hMap.get(curr_timestamp).containsKey(key)){
//                 return hMap.get(curr_timestamp).get(key);
//             }
//         }

//         return result;
//     }
// }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */