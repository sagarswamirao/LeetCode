class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        ans=0
        while low<=high:
            mid= low + (high-low)//2
            if mid==0 or nums[mid] > nums [mid-1]: #maybe a possible answer, let's store and see on the right for more
                ans= mid
                low=mid+1
            else:
                high=mid-1
        return ans
