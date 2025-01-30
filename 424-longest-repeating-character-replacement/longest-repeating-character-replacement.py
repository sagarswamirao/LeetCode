class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_exceptions=k
        l=0
        length=1
        max_freq=0
        freq=[0]*26

        @cache
        def getIndexValueChar(ch):
            return ord(ch) - ord('A')

        for r in range(len(s)):
            freq[getIndexValueChar(s[r])]+=1
            max_freq=max(max_freq, freq[getIndexValueChar(s[r])])
            curr_exceptions= (r-l+1) - max_freq     
            if curr_exceptions>max_exceptions:
                freq[getIndexValueChar(s[l])]-=1
                curr_exceptions=(r-l+1) - max(freq)
                l+=1

            length=max(length, r-l+1)

        return length
            


