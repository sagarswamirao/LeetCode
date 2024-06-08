class Solution {
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        //S: O(2n); Doubly LinkedList Impl
        HashMap<Integer, String> romanIntMap=new LinkedHashMap<>();
        romanIntMap.put(1000,"M");
        romanIntMap.put(900,"CM");
        romanIntMap.put(500,"D");
        romanIntMap.put(400,"CD");
        romanIntMap.put(100,"C");
        romanIntMap.put(90,"XC");
        romanIntMap.put(50,"L");
        romanIntMap.put(40,"XL");
        romanIntMap.put(10,"X");
        romanIntMap.put(9,"IX");
        romanIntMap.put(5,"V");
        romanIntMap.put(4,"IV");
        romanIntMap.put(1,"I");

        //goal is to start from the highest denomination; so 4 and 9 scenarios are well covered
        for(Map.Entry<Integer, String> entry: romanIntMap.entrySet()){
            while (entry.getKey() <= num) {
                num = num - entry.getKey();
                sb.append(entry.getValue());
            } 
        }
        return sb.toString();
    }

}