class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_exceptions=k
        length=1
        max_freq=0

        def getIndexValueChar(ch):
            return ord(ch) - ord('A')

        l=0
        freq=[0]*26
        for r in range(len(s)):
            freq[getIndexValueChar(s[r])]+=1
            max_freq=max(max_freq, freq[getIndexValueChar(s[r])])  
            while ((r-l+1) - max_freq) >max_exceptions:
                freq[getIndexValueChar(s[l])]-=1
                max_freq=max(freq)
                l+=1

            length=max(length, r-l+1)

        return length
            


