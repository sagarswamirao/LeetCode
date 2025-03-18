class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        left=0
        curr_bits=0
        nice_subarr=0
        for right in range(len(nums)):
            temp_curr=curr_bits & nums[right]

            while temp_curr!=0:
                curr_bits = curr_bits ^ nums[left]
                temp_curr = curr_bits & nums[right]
                left+=1
                
            curr_bits = curr_bits | nums[right]

            nice_subarr=max(nice_subarr, (right-left+1))
        
        return nice_subarr