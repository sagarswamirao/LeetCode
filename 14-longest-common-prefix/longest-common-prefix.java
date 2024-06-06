class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longestPrefix="";
        String currSubStr="";
        if(strs.length==1){
            return strs[0];
        }
        StringBuilder sb=new StringBuilder(strs[0]);
        int curr_max_length=sb.length();
        for(int i=1;i<strs.length;i++){
            String letters=strs[i];
            if(letters.length()<sb.length()){
                curr_max_length=Math.min(curr_max_length,letters.length());
                sb.setLength(curr_max_length);
            }
            for(int sb_i=0;sb_i<sb.length();sb_i++){
                if(letters.charAt(sb_i)!=sb.charAt(sb_i)){
                    curr_max_length=Math.min(curr_max_length,sb_i);
                }
            }
            sb.setLength(curr_max_length);
        }

        return sb.toString();
    }
}

// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         String longestSubString="";
//         String currSubStr="";
//         if(strs.length==1){
//             return strs[0];
//         }
//         String currChar="";
//         for(Character c:strs[0].toCharArray()){
//             currChar=currSubStr+c.toString();
//             for(String str:strs){
//                 if(!str.startsWith(currChar)){
//                     return currSubStr;
//                 }
//             }
//             currSubStr=currSubStr.concat(c.toString());
//         }
//                     return currSubStr;
//     }
// }