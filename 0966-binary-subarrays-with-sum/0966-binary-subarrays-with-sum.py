class Solution:
    def temp(self, nums, goal):
        l=0
        curr_sum=0
        count=0
        for r in range(len(nums)):
            curr_sum+=nums[r]
            while l<=r and curr_sum>goal:
                curr_sum-=nums[l]
                l+=1
            if curr_sum<=goal:
                count+=(r-l+1)
                
        return count

    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        return self.temp(nums,goal) - self.temp(nums,goal-1)
 