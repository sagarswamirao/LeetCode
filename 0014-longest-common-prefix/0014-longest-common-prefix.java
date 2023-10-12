class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longestSubString="";
        String currSubStr="";
        if(strs.length==1){
            return strs[0];
        }
        String currChar="";
        for(Character c:strs[0].toCharArray()){
            currChar=currSubStr+c.toString();
            for(String str:strs){
                if(!str.startsWith(currChar)){
                    return currSubStr;
                }
            }
            currSubStr=currSubStr.concat(c.toString());
        }
                    return currSubStr;
    }
}