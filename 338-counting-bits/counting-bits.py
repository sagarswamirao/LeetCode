class Solution:
    def countBits(self, n: int) -> List[int]:
        dp= [0] * (n+1)
        off_set_bit=1
        for i in range(1,n+1):
            if (off_set_bit * 2) == i:
                off_set_bit = (off_set_bit * 2)
            dp[i] = 1 + dp[i - off_set_bit]
        return dp