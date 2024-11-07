class Solution:
    def countBits(self, n: int) -> List[int]:
        ans=[]
        for i in range(n+1):
            count_set=0
            while i>0:
                if i&1:
                    count_set+=1
                i=i>>1
            ans.append(count_set)
        return ans