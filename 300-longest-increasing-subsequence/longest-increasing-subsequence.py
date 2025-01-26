class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp=[1]*len(nums) #we can have min length as 1

        for i in range(len(nums)-1,-1,-1):
            for j in range(i+1,len(nums)):
                if nums[i]<nums[j]: #strictly increasing
                    dp[i]=max(dp[i], dp[j]+1)
        
        return max(dp)

        #TC: O(n^2)
