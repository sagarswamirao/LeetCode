class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> allAns=new ArrayList<>();
        Arrays.sort(candidates);
        computeCombination(target, candidates, 0, new ArrayList<Integer>(), allAns);
        return allAns;
    }

    public void computeCombination(int target, int[] candidates, int currIndex, List<Integer> currAns, List<List<Integer>> allAns){
        //base case
        if(target==0){
            if(!allAns.contains(currAns)){
                allAns.add(new ArrayList<>(currAns));
            }
            return;
        }
        if(currIndex>=candidates.length || target<0){
            return;
        }
        //take
        target-=candidates[currIndex];
        currAns.add(candidates[currIndex]);
        computeCombination(target, candidates, currIndex+1, currAns, allAns);
        //untake
        target+=candidates[currIndex];
        currAns.removeLast();
        //not take
        int j = currIndex+1;
        while(j<candidates.length && candidates[j]==candidates[j-1]) j++;
        computeCombination(target, candidates, j, currAns, allAns);
    }

}