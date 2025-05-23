class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
            n=len(candidates)
            ans=[]
            def recursive(candidates, target, curr_i, n, ds, ans):
                if target==0:
                    ans.append(ds[:])                    
                    return
                if curr_i>=n or target<0:
                    return
                
                # Optimal: For Loop
                for next_i in range(curr_i,n):
                    ds.append(candidates[next_i])
                    recursive(candidates, target-candidates[next_i], next_i, n, ds, ans)
                    ds.pop()

                #Better: Pick Unpick
                # ds.append(candidates[curr_i])
                # recursive(candidates, target-candidates[curr_i], curr_i, n, ds, ans)
                # ds.pop()
                # recursive(candidates, target, curr_i+1, n, ds, ans)
                
            recursive(candidates, target, 0, n, [], ans)
            return ans