class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        chars=['a','b','c']
        result_array=[]

        patterns_generated=0
        def recursive(idx,n,ans):
            nonlocal patterns_generated
            if len(ans)==n:
                patterns_generated+=1
                if patterns_generated==k:
                    result_array.append("".join(ans)) 
                return
                
            if len(ans)>n:
                return 

            for i in range(len(chars)):
                if i!=idx:
                    ans.append(chars[i])
                    recursive(i,n,ans)
                    ans.pop()
        
        recursive(-1,n,[])
        return result_array[0] if len(result_array)==1 else ""