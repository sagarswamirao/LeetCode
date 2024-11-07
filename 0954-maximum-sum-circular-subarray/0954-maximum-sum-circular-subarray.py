class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        total_sum=0
        curr_max=0
        global_max=nums[0]
        curr_min=0
        global_min=nums[0]
        for num in nums:
            total_sum+=num

            if curr_max<0:
                curr_max=0
            curr_max+=num

            if curr_min>0:
                curr_min=0
            curr_min+=num

            if curr_max>global_max:
                global_max=curr_max
            
            if curr_min<global_min:
                global_min=curr_min
        
        if (total_sum == global_min):
            return global_max
    
        return max(total_sum-global_min, global_max)
