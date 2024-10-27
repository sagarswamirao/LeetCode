class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # first we have to find a high value of k, so we can have a range to search; so we take the max of the piles
        low=1
        high=max(piles)
        min_eating_speed_k=high
        while low<=high:
            mid= (low+high)//2
            if self.checkIfKokoIsAbleToFinish(piles, mid, h):
                #she is able to eat, then we store and reduce eating_speed as we ahve to return the min value
                high=mid-1
                min_eating_speed_k=min(min_eating_speed_k,mid)
            else:
                low=mid+1
        return min_eating_speed_k

        
    def checkIfKokoIsAbleToFinish(self, piles, eating_speed, max_hours):
        time=0
        for pile in piles:
            time+= math.ceil(pile/eating_speed)
            if time>max_hours:
                return False
        return True
            