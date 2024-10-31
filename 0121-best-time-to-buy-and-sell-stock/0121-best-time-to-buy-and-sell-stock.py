class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        best_buy=prices[0]
        profit=0
        for todays_price in prices:
            profit=max(profit, todays_price-best_buy)
            best_buy=min(best_buy, todays_price)
        
        return 0 if profit<0 else profit