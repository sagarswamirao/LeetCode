# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        # we wish to find a bad version, store it, and check if previous versions are bad
        low=1
        high=n
        ans=-1
        while low<=high:
            mid= low + (high-low)//2
            if isBadVersion(mid):  
                ans=mid
                high=mid-1
            else: #means mid<target
                low=mid+1

        return ans