class Solution:
    def coloredCells(self, n: int) -> int:

        multiplier=4
        ans=0
        for i in range(1,n+1):
            if i==1:
                ans=1
            else:
                new_boxes=(multiplier * (i-1))
                ans= ans + (multiplier * (i-1))
        
        return ans



