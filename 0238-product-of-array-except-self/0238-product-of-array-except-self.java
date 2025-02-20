class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct=1;
        int n=nums.length;
        int[] prefixProduct=new int[n];
        // int[] postfixProduct=new int[n];
        prefixProduct[0]=1;
        // postfixProduct[n-1]=1;
        for(int i=1;i<n;i++){
            prefixProduct[i]=prefixProduct[i-1]*nums[i-1];
            // postfixProduct[n-i-1]= postfixProduct[n-i] * nums[n-i];
        }
        int postfix_product=1;
        for(int i=n-2;i>=0;i--){
            prefixProduct[i]*=(postfix_product*nums[i+1]);
            postfix_product=(postfix_product*nums[i+1]);
            // postfixProduct[i]= postfixProduct[i+1] * nums[i+1];
        }
        // for(int i=0;i<n;i++){
        //     nums[i]=prefixProduct[i]*postfixProduct[i];
        // }
        return prefixProduct;
    }
}