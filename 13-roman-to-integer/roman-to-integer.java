class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanIntMap = new HashMap<>();
        romanIntMap.put('I', 1);
        romanIntMap.put('V', 5);
        romanIntMap.put('X', 10);
        romanIntMap.put('L', 50);
        romanIntMap.put('C', 100);
        romanIntMap.put('D', 500);
        romanIntMap.put('M', 1000);
        int number=0;
        int i=0;
        while(i<s.length()){
            if(i!=s.length()-1 && romanIntMap.get(s.charAt(i))<romanIntMap.get(s.charAt(i+1))){
                number= number + (romanIntMap.get(s.charAt(i+1)) - romanIntMap.get(s.charAt(i)));
                i+=2;
            } else{
                number= number + (romanIntMap.get(s.charAt(i)));
                i+=1;
            }
        }
        return number;
    }
}