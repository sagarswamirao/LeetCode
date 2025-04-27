class Solution:
    # def hammingWeight(self, num: int) -> int:
    #     count_of_set_bits=0
    #     n=num
    #     while n>0:
    #         if (n & 1) ==1:
    #             count_of_set_bits+=1
    #         n=n>>1
    #     return count_of_set_bits
    def hammingWeight(self, num: int) -> int:
        count_of_set_bits=0
        n=num
        while n>0:
            n= n & (n-1) #unset the last set bit
            count_of_set_bits+=1
        return count_of_set_bits