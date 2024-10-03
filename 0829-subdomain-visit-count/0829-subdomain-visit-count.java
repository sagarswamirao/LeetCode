class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> hMap=new HashMap<>();
        List<String> newStrList=new ArrayList<>();
        for(String domain:cpdomains){
            String[] packs=domain.split(" ");
            String substr=packs[1];
            Integer value=Integer.valueOf(packs[0]);
            hMap.put(substr, hMap.getOrDefault(substr, 0)+value);
            for(int i=0;i<substr.length();i++){
                if(substr.charAt(i)=='.'){
                    String newSubStr=substr.substring(i+1,substr.length());
                    hMap.put(newSubStr, hMap.getOrDefault(newSubStr, 0)+value);
                }
            }
        }
        
        for(Map.Entry<String,Integer> entry:hMap.entrySet()){
            newStrList.add(String.valueOf(entry.getValue())+" "+entry.getKey());
        }
        return newStrList;
    }
}