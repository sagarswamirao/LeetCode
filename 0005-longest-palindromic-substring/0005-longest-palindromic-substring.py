# class Solution:
#     def longestPalindrome(self, s: str) -> str:
#         @cache
#         def check(i, j):
#             left = i
#             right = j - 1

#             while left < right:
#                 if s[left] != s[right]:
#                     return False

#                 left += 1
#                 right -= 1

#             return True

#         for end in range(len(s), 0, -1):
#             for start in range(0, len(s) - end + 1):
#                 if check(start, start + end):
#                     return s[start:start + end]

#         return ""

class Solution:
    def longestPalindrome(self, s: str) -> str:
        ans = [0, 0]
        res_len=0
        left=0
        res=''

        for i in range(len(s)):
            left, right =i,i
            # odd_length = expand(i, i)

            while left >= 0 and right < len(s) and s[left] == s[right]:
                if (right -left + 1) > res_len:
                    res=s[left : right+1]
                    res_len=(right -left + 1)
                left -= 1
                right += 1

            left, right=i, i+1
            while left >= 0 and right < len(s) and s[left] == s[right]:
                if (right -left + 1) > res_len:
                    res=s[left: right+1]
                    res_len=(right -left + 1)
                left -= 1
                right += 1
        return res

