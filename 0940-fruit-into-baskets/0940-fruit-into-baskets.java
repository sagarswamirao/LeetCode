class Solution {
    public int totalFruit(int[] fruits) {
        int max_fruit_types=2;
        int max_length=0;
        HashMap<Integer, Integer> hmap=new HashMap<>();
        int l=0;
        for (int r=0;r<fruits.length;r++){
            hmap.put(fruits[r], hmap.getOrDefault(fruits[r],0)+1);
            if(hmap.size()>max_fruit_types && hmap.getOrDefault(fruits[l], 0)!=0){
                hmap.put(fruits[l], hmap.getOrDefault(fruits[l],0)-1);
                if(hmap.get(fruits[l])<=0){
                    hmap.remove(fruits[l]);
                }
                l++;
            }
            max_length=Math.max(max_length, r-l+1);
        }
        return max_length;
    }
}