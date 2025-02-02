class Solution:
    def check(self, nums: List[int]) -> bool:
        pattern_breaks=0

        for j in range(0,2*len(nums)-1):
            i= (j%len(nums))-1
            if nums[i]<=nums[i+1]:
                continue
            else:
                pattern_breaks+=1
        
        return True if (pattern_breaks<=2) else False