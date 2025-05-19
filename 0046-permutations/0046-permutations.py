class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        in_use=[False for i in range(len(nums))]
        answer=[]

        def recursive(i, n, ds):
            if len(ds)==n:
                answer.append(ds[:])
                return
            if i>=n:
                return
            
            for next_i in range(len(in_use)):
                if in_use[next_i]==False:
                    in_use[next_i]=True
                    ds.append(nums[next_i])
                    recursive(next_i, n, ds)
                    in_use[next_i]=False
                    ds.pop()
            
            
        
        recursive(0, len(nums), [])

        return answer