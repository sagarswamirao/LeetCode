class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min_recolors=k;
        int curr_recolors=0; //count of white blocks in the window
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W')
            curr_recolors+=1;
        }
        min_recolors=curr_recolors;
        for(int right=k;right<blocks.length();right++){
            if(blocks.charAt(right-k)=='W'){
                curr_recolors-=1;
            }
            if(blocks.charAt(right)=='W'){
                curr_recolors+=1;
            }
            if(curr_recolors<min_recolors){
                min_recolors=curr_recolors;
            }
        }
        return min_recolors;       
    }
}