class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //given that nums has the length of m + n
        //so we can fill in from the back to front
        int i=m-1;
        int j=n-1;
        int insert_idx=(m+n)-1;
        while(i>=0 && j>=0){
            if(nums2[j]<nums1[i]){
                nums1[insert_idx]=nums1[i];
                i--;
            }else if(nums2[j]>=nums1[i]){
                nums1[insert_idx]=nums2[j];
                j--;
            }
            insert_idx--;
        }
        while(i>=0){
            nums1[insert_idx]=nums1[i];
            i--;
            insert_idx--;
        }
        while(j>=0){
            nums1[insert_idx]=nums2[j];
            j--;
            insert_idx--;
        }
    }
}