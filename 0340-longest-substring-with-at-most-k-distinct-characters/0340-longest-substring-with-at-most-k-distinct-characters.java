class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l=0;
        int max_length=0;
        HashMap<Character, Integer> hMap=new HashMap<>();
        for(int r=0;r<s.length();r++){
            hMap.put(s.charAt(r),hMap.getOrDefault(s.charAt(r),0)+1);
            if(hMap.size()>k){
                hMap.put(s.charAt(l), hMap.get(s.charAt(l))-1);
                if(hMap.get(s.charAt(l))==0){
                    hMap.remove(s.charAt(l));
                }
                l++;
            }
        max_length=Math.max(max_length, r-l+1);
        }
        return max_length;
    }
}