class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> hashy = new HashMap<>();
        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(!hashy.containsKey(key)){
                hashy.put(key, new ArrayList<String>());
            }
            hashy.get(key).add(s);
        }
        return new ArrayList<>(hashy.values());
    }
}