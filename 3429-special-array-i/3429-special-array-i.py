class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        if len(nums)==1:
            return True
        
        prevParity=nums[0]%2

        for i in range(1,len(nums)):
            currParity=nums[i]%2

            if prevParity==currParity:
                return False
            
            prevParity=currParity
        
        return True