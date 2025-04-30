class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result_str_list=[]
        self.recursive(n, 0, [], result_str_list)
        return result_str_list

    def recursive(self, n, open_count, curr_list, result_str_list):
        if len(curr_list)==2*n:
            if open_count==0:
                result_str_list.append(''.join(curr_list))
            return

        if open_count<n:
            curr_list.append('(')
            self.recursive(n, open_count+1, curr_list, result_str_list)
            curr_list.pop()               
        
        if open_count>0:
            curr_list.append(')')
            self.recursive(n, open_count-1, curr_list, result_str_list)
            curr_list.pop()
            