class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        hset=set()

        l=0
        for r in range(len(nums)):
            if nums[r] in hset:
                return True
            
            hset.add(nums[r])
            if (r-l+1)>k:
                hset.remove(nums[l])
                l+=1
        
        return False