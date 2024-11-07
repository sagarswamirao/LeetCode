class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        globalMaxLength=1
        prevSign=""
        l=0
        r=1
        while r<len(arr):
            if arr[r-1]>arr[r] and prevSign!=">":
                globalMaxLength=max(globalMaxLength, r-l+1)
                r+=1
                prevSign=">"
            elif arr[r-1]<arr[r] and prevSign!="<":
                globalMaxLength=max(globalMaxLength, r-l+1)
                r+=1
                prevSign="<"
            else:
                r = r+1 if arr[r-1]==arr[r] else r
                l = r - 1
                prevSign=""
        
        return globalMaxLength
