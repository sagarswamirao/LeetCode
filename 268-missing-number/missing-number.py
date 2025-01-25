class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        ans=len(nums)
        for i in range(len(nums)):
            ans= ans ^ i
            ans = ans ^ nums[i]
        return ans