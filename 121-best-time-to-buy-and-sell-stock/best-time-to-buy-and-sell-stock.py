class Solution:
    # def maxProfit(self, prices: List[int]) -> int:
    #     best_buy=prices[0]
    #     profit=0
    #     for todays_price in prices:
    #         profit=max(profit, todays_price-best_buy)
    #         best_buy=min(best_buy, todays_price)
        
    #     return 0 if profit<0 else profit

# BETTER APPROACH
    def maxProfit(self, prices):
        min_price = float('inf')
        max_profit = 0
        
        for price in prices:
            if price < min_price:
                min_price = price
            elif price - min_price > max_profit:
                max_profit = price - min_price

        return max_profit