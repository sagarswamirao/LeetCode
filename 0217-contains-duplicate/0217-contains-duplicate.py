from collections import Counter
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        count_pairs=Counter(nums)
        return True if max(count_pairs.values())>1 else False