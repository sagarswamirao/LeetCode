class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # first we have to find a high value of k, so we can have a range to search; so we take the max of the piles
        low = 1
        high = max(piles)
        while low < high:
            mid = (low + high) // 2
            if not self.checkIfKokoIsAbleToFinish(piles, mid, h):
               low= mid+1
            else:
                high = mid
        return low

    def checkIfKokoIsAbleToFinish(self, piles, eating_speed, max_hours):
        time = 0
        for pile in piles:
            time += math.ceil(pile / eating_speed)
            if time > max_hours:
                return False
        return True
