class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_exceptions=k
        l=0
        length=1
        max_freq=0
        freq=[0]*26
        for r in range(len(s)):
            freq[ord(s[r])-ord('A')]+=1
            max_freq=max(max_freq, freq[ord(s[r])-ord('A')])
            curr_exceptions= (r-l+1) - max_freq     
            if curr_exceptions>max_exceptions:
                freq[ord(s[l])-ord('A')]-=1
                curr_exceptions=(r-l+1) - max(freq)
                l+=1

            length=max(length, r-l+1)

        return length
            


