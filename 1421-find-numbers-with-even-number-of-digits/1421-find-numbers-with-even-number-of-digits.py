class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        even_count=0
        for num in nums:
            even_count+= 1 if math.floor((log10(num)+1))%2==0 else 0
        return even_count