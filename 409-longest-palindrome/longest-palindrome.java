class Solution {
    public int longestPalindrome(String s) {
        if(s.length()<2){
            return s.length();
        }
        HashMap<Character, Integer> sHashMap=new HashMap<>();
        for(Character c: s.toCharArray()){
            sHashMap.put(c, sHashMap.getOrDefault(c, 0)+1);
        }

        int pair_count=0;
        boolean one_odd=false;
        for(Character c: sHashMap.keySet()){
            int freq=sHashMap.get(c);
            pair_count+=Math.floorDiv(freq, 2);
            if(freq%2==1){
                one_odd=true;
            }
        }
        return (pair_count*2)+(one_odd?1:0);
    }
}