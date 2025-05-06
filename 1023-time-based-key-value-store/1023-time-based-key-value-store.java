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
    private HashMap<String, ArrayList<Pair<Integer, String>>> hMap;
    public TimeMap() {
        this.hMap=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // if(!this.hMap.containsKey(key)){
        //     this.hMap.put(key, new HashMap<>());
        // }
        this.hMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp,value));
    }
    
    public String get(String key, int target_timestamp) {

        if(this.hMap.size()==0 || !this.hMap.containsKey(key)){
            return "";
        }
        
        String nearestValue="";


        ArrayList<Pair<Integer, String>>list=this.hMap.get(key);
        int left=0;
        int right=list.size()-1;
        if(list.size()==0){
            return "";
        }
        while(left<=right){
            int mid=left + (right-left)/2;
            
            if(list.get(mid).getKey()<=target_timestamp){
                nearestValue=list.get(mid).getValue();
                left=mid+1;
            }else{
                right=mid-1;
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