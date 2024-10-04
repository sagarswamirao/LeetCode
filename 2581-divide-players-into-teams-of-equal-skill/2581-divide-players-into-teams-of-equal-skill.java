class Solution {
    public long dividePlayers(int[] skill) {
        if(skill.length%2==1 || skill.length==0){
            return -1;
        }
        Arrays.sort(skill);
        long productSum=0;
        long target=skill[0]+skill[skill.length-1];
        for(int i=0;i<skill.length/2;i++){
            if(target!=(skill[i]+skill[skill.length-i-1])) return -1;
            productSum+=(skill[i]*skill[skill.length-i-1]);
        }
        return productSum;
    }
}