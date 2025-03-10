class Solution {
    public boolean hasAllVowels(HashMap<Character, Integer> hMap){
        ArrayList<Character> vowels = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));
        for(Character vowel: vowels){
            if(hMap.getOrDefault(vowel,0)==0){
                return false;
            }
        }
        return true;
    }
    public long countOfSubstrings(String word, int k){
        return this.countOfSubstringsGTEqK(word, k) - this.countOfSubstringsGTEqK(word, k+1);
    }
    public boolean isVowel(Character c){
        return c.equals('a') || c.equals('e') || c.equals('i') || c.equals('o') || c.equals('u');
    }
    public long countOfSubstringsGTEqK(String word, int k) {
        int left=0;
        long count=0;
        int non_vowel=0;
        HashMap<Character, Integer> hMap=new HashMap<>();
        for(int right=0;right<word.length();right++){
            if(!this.isVowel(word.charAt(right))){
                non_vowel+=1;
            }else{
                hMap.put(word.charAt(right),hMap.getOrDefault(word.charAt(right),0)+1);
            }
            while(this.hasAllVowels(hMap) && non_vowel>=k){
                count+=(word.length()-right);
                if(!this.isVowel(word.charAt(left))){
                    non_vowel-=1;
                }else{
                    hMap.put(word.charAt(left),hMap.get(word.charAt(left))-1);
                }
                left+=1;
                
            }
        }
        return count;
    }
}