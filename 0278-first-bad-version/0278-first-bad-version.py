# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        # we wish to find a bad version, store it, and check if previous versions are bad
        low=1
        high=n
        while low<high:
            mid= low + (high-low)//2
            if not isBadVersion(mid):  #means mid<target
                low=mid+1
            else:
                high=mid

        return low