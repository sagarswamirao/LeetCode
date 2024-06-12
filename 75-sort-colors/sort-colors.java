class Solution {
    public static void swap(int[] arr,int i,int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
    public void sortColors(int[] nums) {
        //similar to dutch national flag algorithm
        //0 to low 0's
        //low to mid 1's
        //mid to high mix
        //high to n 2's'
        int low=0,mid=0,high=nums.length-1,n=nums.length-1;
        while(mid<=high){
            if(nums[mid]==1){
                mid++;
            }else if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
}