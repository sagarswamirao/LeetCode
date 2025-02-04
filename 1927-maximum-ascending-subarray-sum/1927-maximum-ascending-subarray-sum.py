class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        max_total_sum=nums[0]
        curr_total_sum=nums[0]
        for i in range(1,len(nums)):
            if nums[i]>nums[i-1]:
                curr_total_sum+=nums[i]
            else:
                curr_total_sum=nums[i]
            max_total_sum=max(max_total_sum,curr_total_sum)
        return max_total_sum