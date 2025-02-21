class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hset=set()
        l,length=0,0

        for r in range(len(s)):
            while s[r] in hset:
                hset.remove(s[l])
                l+=1
            
            hset.add(s[r])
            length=max(length,r-l+1)

        return length