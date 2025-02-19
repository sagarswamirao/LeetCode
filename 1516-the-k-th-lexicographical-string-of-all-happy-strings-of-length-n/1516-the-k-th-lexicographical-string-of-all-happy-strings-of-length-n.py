class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        chars=['a','b','c']
        result_array=[]

        memo={}
        def recursive(idx,n,ans):
            if len(ans)==n:
                result_array.append("".join(ans))
                return
            if len(ans)>n:
                return 

            for i in range(len(chars)):
                if i!=idx:
                    ans.append(chars[i])
                    recursive(i,n,ans)
                    ans.pop()
        
        x=[]
        recursive(-1,n,x)
        return result_array[k-1] if len(result_array)>=k else ""