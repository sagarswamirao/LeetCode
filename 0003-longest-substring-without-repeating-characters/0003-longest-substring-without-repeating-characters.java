class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] occurances=new int[26];
        int i=0, j=0;
        int n=s.length();
        int longest=0;
        HashMap<Character, Integer> hMap=new HashMap<>();
        while(i<n){
            Character currChar=s.charAt(i);
            hMap.put(currChar, hMap.getOrDefault(currChar,0)+1);
            while(hMap.get(currChar)>1){
                hMap.put(s.charAt(j), hMap.get(s.charAt(j))-1);
                j+=1;
            }
            longest=Math.max(longest, i-j+1);
            i+=1;
        }
        return longest;
    }
}