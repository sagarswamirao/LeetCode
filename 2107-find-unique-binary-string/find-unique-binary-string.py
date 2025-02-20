class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        hset=set()
        curr_len=len(nums[0])
        for num in nums:
            curr_num=int(num,2) #converting to decimal
            hset.add(curr_num)
        
        n = len(nums)
        for num in range(n + 1): #works as the length is same
            if num not in hset:
                ans = bin(num)[2:]
                return "0" * (n - len(ans)) + ans
            
        return ""
