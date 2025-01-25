class Solution:
    def coinChange(self, coins: List[int], targetAmount: int) -> int:
        dp = [float('inf')] * (targetAmount + 1)
        dp[0] = 0
        
        #So basically for each of the coin in the coins,
        for coin in coins:
            # we check starting from that coin value to the targetAmount repeatedly, the minimum 
            # number of moves it will take and store the global minimum into the dp
            for x in range(coin, targetAmount + 1):
                dp[x] = min(dp[x], dp[x - coin] + 1)
        return dp[targetAmount] if dp[targetAmount] != float('inf') else -1 