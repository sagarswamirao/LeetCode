class Solution:
    def multiply(self, num1: str, num2: str) -> str:

        if num1=='0' or num2=='0':
            return '0'

        ans_arr=[0 for i in range(len(num1)+len(num2)+1)]
        
        num1=num1[::-1]
        num2=num2[::-1]

        for idx1 in range(len(num1)):
            for idx2 in range(len(num2)):
                ans_arr[idx1+idx2] += (int(num1[idx1]) * int(num2[idx2]))
                ans_arr[idx1+idx2+1]+=ans_arr[idx1+idx2]//10  #carry to next position
                ans_arr[idx1+idx2]=ans_arr[idx1+idx2]%10 #sum after removing overflow

        ans_arr.reverse()

        start_idx=0
        for i in range(len(ans_arr)):
            if ans_arr[i]==0:
                start_idx+=1
            else:
                break
        return ''.join(map(str, ans_arr[start_idx:]))