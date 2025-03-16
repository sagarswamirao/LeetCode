class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""

        freq_dict = {}
        minimum_left = 0
        minimum_right = 0

        for i in range(len(t)):
            freq_dict[t[i]] = freq_dict.get(t[i], 0) + 1
        unique_elements=len(freq_dict)
        left = 0
        matches = 0
        for right in range(len(s)):
            freq_dict[s[right]] = freq_dict.get(s[right], 0) - 1
            if freq_dict[s[right]] == 0:
                matches += 1

            # match found
            while matches == unique_elements and left<=right:
                if (minimum_right - minimum_left) == 0 or (
                    minimum_right - minimum_left
                ) > (right - left + 1):
                    minimum_left = left
                    minimum_right = right + 1

                freq_dict[s[left]] += 1
                if freq_dict[s[left]] > 0:
                    matches -= 1
                left += 1

            right += 1

        return s[minimum_left:minimum_right]


# class Solution:
#     def minWindow(self, s: str, t: str) -> str:

#         def get_match_count(ss,tt):
#             count=26
#             for key, value in tt.items():
#                 s_val=ss.get(key,0)
#                 if s_val<value:
#                     count-=1
#             return count

#         def check_if_all_t_in_s(ss,tt):
#             for key, value in tt.items():
#                 s_val=ss.get(key,0)
#                 if s_val<value:
#                     return False
#             return True

#         if len(t)>len(s):
#             return ""

#         s_dict={}
#         t_dict={}
#         f_l=0
#         f_r=0
#         for i in range(len(t)):
#             s_dict[s[i]]=s_dict.get(s[i],0)+1
#             t_dict[t[i]]=t_dict.get(t[i],0)+1

#         if check_if_all_t_in_s(s_dict,t_dict):
#             f_l=0
#             f_r=len(t)

#         left=0
#         right=len(t)

#         matches=get_match_count(s_dict,t_dict)

#         while right < len(s):
#             s_dict[s[right]]=s_dict.get(s[right],0)+1
#             if s[right] in t_dict and s_dict[s[right]]==t_dict[s[right]]:
#                 matches+=1

#             #match found
#             # while check_if_all_t_in_s(ss,tt): BRUTE FORCE
#             while matches==26:
#                 if (f_r-f_l)==0 or (f_r-f_l)>(right-left+1):
#                     f_l=left
#                     f_r=right+1

#                 if s[left] in t_dict and s_dict[s[left]]==t_dict[s[left]]:
#                     matches-=1

#                 s_dict[s[left]]-=1
#                 left+=1

#             right+=1

#         return s[f_l:f_r]
