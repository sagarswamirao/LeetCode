class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        s_c=collections.Counter(s)        
        s_t=collections.Counter(t)

        return s_c==s_t