class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        even_count=0
        for num in nums:
            # xx=int(log10(num))
            even_count+= 1 if int((log10(num)+1))%2==0 else 0
        return even_count