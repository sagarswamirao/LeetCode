class Solution:
    def mySqrt(self, x: int) -> int:
        if x<2:
            return x
        low = 2
        high = x//2
        while low <= high:
            mid = low + (high - low) // 2
            ans = mid * mid

            if ans > x:
                high = mid - 1
            elif ans < x:
                low = mid + 1
            else:
                return mid

        return high
