class Solution:
    def hammingWeight(self, n: int) -> int:
        count_of_set_bits=0
        while n>0:
            if (n & 1) ==1:
                count_of_set_bits+=1
            n=n>>1
        return count_of_set_bits