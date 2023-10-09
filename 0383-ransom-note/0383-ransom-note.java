class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        for(int i=0;i<ransomNote.length();i++){
            if(!magazine.contains(String.valueOf(ransomNote.charAt(i)))){
                return false;
            }
                magazine=magazine.replaceFirst(String.valueOf(ransomNote.charAt(i)),"");
        }
        return true;
    }
}