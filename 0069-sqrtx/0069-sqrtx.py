class Solution:
    def mySqrt(self, x: int) -> int:
        low=0
        high=x
        while low<=high:
            mid= low + (high-low)//2
            ans=mid**2
            if floor(ans)>x:
                high=mid-1
            else:
                low=mid+1
            
        
        return high
        