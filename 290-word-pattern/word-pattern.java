class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> hMap=new HashMap<>();
        int i=0;
        String[] words=s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        for(String word:words){
            char patternChar=pattern.charAt(i);
            if((hMap.containsKey(patternChar) && !hMap.get(patternChar).equals(word)) ||
            (!hMap.containsKey(patternChar) && hMap.containsValue(word))){
                return false;
            }else{
                hMap.putIfAbsent(patternChar, word);
            }
            i++;
        }
        return true;
    }
}




// class Solution {
//     public boolean wordPattern(String pattern, String s) {
//         HashMap<Character,String> hm=new HashMap<>();
//         HashSet<String> targetUsed=new HashSet<>();
//         String[] s_arr=s.split(" ");
//         if(s_arr.length!=pattern.length()){
//             return false;
//         }
//         for(int i=0;i<s_arr.length;i++){
//             if(hm.containsKey(pattern.charAt(i))){
//                 String follow=hm.get(pattern.charAt(i));
//                 if(!s_arr[i].equals(follow)){
//                     return false;
//                 }
//             }else{
//                 if(targetUsed.contains(s_arr[i])){
//                     return false;
//                 }
//                 targetUsed.add(s_arr[i]);
//                 hm.put(pattern.charAt(i),s_arr[i]);
//             }
//         }
//         return true;
//     }
// }