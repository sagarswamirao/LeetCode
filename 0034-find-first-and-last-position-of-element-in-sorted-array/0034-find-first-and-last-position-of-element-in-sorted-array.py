class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first=self.findFirstOccurance(nums, target)
        if first==-1:
            return [-1, -1]
        last=self.findLastOccurance(nums, target)

        return [first, last]
    
    def findFirstOccurance(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        ans=-1
        while left <= right:
            mid = (left + right) // 2
            
            if nums[mid]==target:
                ans=mid
                right=mid-1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid -1

        return ans  

    def findLastOccurance(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        ans=-1
        while left <= right:
            mid = (left + right) // 2
            
            if nums[mid]==target:
                ans=mid
                left=mid+1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid -1

        return ans  