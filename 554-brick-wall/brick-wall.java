class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hMap=new HashMap<>();
        for(List<Integer> row:wall){
            int row_sum=0;
            for(int col=0;col<row.size()-1;col++){
                row_sum+=row.get(col);
                hMap.put(row_sum, hMap.getOrDefault(row_sum, 0)+1);
            }
        }
        int res = wall.size();
        for (int key: hMap.keySet())
            res = Math.min(res, wall.size() - hMap.get(key));
        return res;
    }
}