class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0;
        int n=s.length();
        int longest=0;
        HashMap<Character, Integer> hMap=new HashMap<>();
        while(i<n){
            Character currChar=s.charAt(i);
            if(hMap.containsKey(currChar) && hMap.get(currChar)>=j){
                j=hMap.get(currChar)+1;
            }
            hMap.put(currChar, i);
            longest=Math.max(longest, i-j+1);
            i+=1;
        }
        return longest;
    }
}