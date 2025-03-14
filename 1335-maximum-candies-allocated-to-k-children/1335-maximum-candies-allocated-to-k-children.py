class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        max_candies= max(candies)
        
        def can_all_k_children_get_x_candies(x, k):
            sub_piles=0
            for pile in candies:
                sub_piles+= floordiv(pile, x)
            return True if sub_piles>=k else False
        

        low=1
        high=max_candies

        while low<=high:
            mid=low+(high-low)//2

            if not can_all_k_children_get_x_candies(mid, k):
                high=mid-1
            else:
                low=mid+1
        
        return high