class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        left=0
        curr_bits=0
        nice_subarr=0
        for right in range(len(nums)):
            '''
            For a & b to be 0, the bits set should be in different positions.
            The point is, as we deal with bits, if we update curr_bits, directly, it may break the bits set till now
            So we will compute the curr_bits & nums[right] and store it in a temporary variable temp_curr
            If temp_curr is not 0, then we know that the nice subarray is violated
            
            While temp_curr !=0
                We will have to unset the bits set earlier, so we XOR curr_bits with nums[left]
                Now the temp_curr will be curr_bits & nums[right]
                left+=1
            
            now we AND curr_bits with nums[right]
            Compute the max_nice_substring
            
            '''
            temp_curr=curr_bits & nums[right]

            while temp_curr!=0:
                curr_bits = curr_bits ^ nums[left]
                temp_curr = curr_bits & nums[right]
                left+=1
                
            curr_bits = curr_bits | nums[right]
            nice_subarr=max(nice_subarr, (right-left+1))
        
        return nice_subarr