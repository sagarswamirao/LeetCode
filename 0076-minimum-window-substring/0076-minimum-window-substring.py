class Solution:
    def minWindow(self, s: str, t: str) -> str:

        def check_if_all_t_in_s(ss,tt):
            for key, value in tt.items():
                s_val=ss.get(key,0)
                if s_val<value:
                    return False
            return True

        if len(t)>len(s):
            return ""

        s_dict={}
        t_dict={}
        f_l=0
        f_r=0
        for i in range(len(t)):
            s_dict[s[i]]=s_dict.get(s[i],0)+1
            t_dict[t[i]]=t_dict.get(t[i],0)+1

        if check_if_all_t_in_s(s_dict,t_dict):
            f_l=0
            f_r=len(t)
        left=0
        right=len(t)

        # if not (right < len(s)):
        #     return ""check_if_all_t_in_s(s_dict,t_dict)

        while right < len(s):
            s_dict[s[right]]=s_dict.get(s[right],0)+1

            #match found
            while check_if_all_t_in_s(s_dict,t_dict):
                if (f_r-f_l)==0 or (f_r-f_l)>(right-left):
                    f_l=left
                    f_r=right+1
                s_dict[s[left]]-=1
                left+=1         

            right+=1

        return s[f_l:f_r]
            