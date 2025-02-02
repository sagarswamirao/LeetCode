class Solution:
    def check(self, nums: List[int]) -> bool:
        pattern_breaks=0

        for i in range(0,len(nums)-1):
            if nums[i]<=nums[i+1]:
                continue
            else:
                pattern_breaks+=1
        
        if pattern_breaks>0 and nums[0]<nums[-1]:
            return False
        return True if (pattern_breaks<2) else False