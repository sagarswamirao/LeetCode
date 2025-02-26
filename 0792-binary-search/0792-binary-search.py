class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low < high:
            mid = low + (high - low) // 2
            if nums[mid] >= target:
                high = mid
            else:
                low = mid + 1

        if nums[low] == target:
            return low
        return -1


# while(left <= right) is correct. There are 2 cases:

# target is between left & right. Ex: arr = 3 1 9 , target = 1
# array has 1 element

# when all the numbers are unique ==> while(left <= right)
# when there are duplicate numbers ==> while(left < right)
