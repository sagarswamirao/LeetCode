class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right=0, left=0;
        int n=s.length();
        int longest=0;
        HashMap<Character, Integer> hMap=new HashMap<>();
        while(right<n){
            Character currChar=s.charAt(right);
            if(hMap.containsKey(currChar) && hMap.get(currChar)>=left){
                left=hMap.get(currChar)+1;
            }
            hMap.put(currChar, right);
            longest=Math.max(longest, right-left+1);
            right+=1;
        }
        return longest;
    }
}