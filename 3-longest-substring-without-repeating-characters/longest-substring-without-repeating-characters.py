class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hMap = {}
        max_length = 0
        l = 0
        for r in range(0, len(s)):
            if s[r] in hMap and hMap[s[r]] >= l:
                l = hMap[s[r]] + 1
            hMap[s[r]] = r
            max_length = max(max_length, r - l + 1)
        return max_length

    # def lengthOfLongestSubstring(self, s: str) -> int:
    #     hset=set()
    #     l,length=0,0

    #     for r in range(len(s)):
    #         while s[r] in hset:
    #             hset.remove(s[l])
    #             l+=1

    #         hset.add(s[r])
    #         length=max(length,r-l+1)

    #     return length
