class Solution:
    def multiply(self, num1: str, num2: str) -> str:

        if num1=='0' or num2=='0':
            return '0'

        ans_arr=[0 for i in range(len(num1)+len(num2)+1)]
        
        for idx1 in range(len(num1)):
            pos=idx1
            carry=0
            for n2 in reversed(num2):
                ans_arr[pos] = ans_arr[pos] + (int(num1[len(num1)-idx1-1]) * int(n2)) + carry
                carry=ans_arr[pos]//10
                ans_arr[pos]=ans_arr[pos]%10
                pos+=1

            if carry!=0:
               ans_arr[pos]+=carry 
        ans_arr.reverse()

        start_idx=0
        for i in range(len(ans_arr)):
            ans_arr[i]=str(ans_arr[i])

        for i in range(len(ans_arr)):
            if ans_arr[i]=='0':
                start_idx+=1
            else:
                break

        return ''.join(ans_arr[start_idx:])