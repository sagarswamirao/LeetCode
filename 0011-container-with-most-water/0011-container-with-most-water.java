class Solution {
    public int maxArea(int[] height) {
      int ans=0;
      int l=0,r=height.length-1;
      int l_max=0,r_max=0;
      while(l<r){
        l_max=Math.max(l_max,height[l]);
        r_max=Math.max(r_max,height[r]);
        int curr_area=0;
        if(l_max<r_max){
            curr_area=l_max*(r-l);
            l+=1;
        }else{
            curr_area=r_max*(r-l);
            r-=1;
        }
        ans=Math.max(ans,curr_area);
      }
    return ans;
    }
}