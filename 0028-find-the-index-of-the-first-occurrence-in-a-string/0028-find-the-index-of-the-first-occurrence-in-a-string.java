class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length();i++){
            if(haystack.substring(i,haystack.length()).startsWith(needle)){
                return i;
            }
        }
        return -1;
    }
}