class Solution:
    def countSubstrings(self, s: str) -> int:
        
        result=0
        for mid_idx in range(len(s)):
            left=mid_idx
            right=mid_idx
            while left>=0 and right<len(s) and s[left]==s[right]:
                result+=1
                left-=1
                right+=1
            
            left=mid_idx
            right=mid_idx+1
            while left>=0 and right<len(s) and s[left]==s[right]:
                result+=1
                left-=1
                right+=1
        return result