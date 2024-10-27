from collections import Counter
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #Bucket Sort
        arr=[0]*3
        for i in nums:
            arr[i]+=1
        i=0
        for ind in range(len(arr)):
            for _ in range(arr[ind]):
                nums[i]=ind
                i+=1