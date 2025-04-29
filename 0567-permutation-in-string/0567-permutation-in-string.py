class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        s1_freq=[0] * 26
        s2_freq=[0] * 26

        for i in range(len(s1)):
            s1_freq[ord(s1[i])-ord('a')]+=1
            s2_freq[ord(s2[i])-ord('a')]+=1

        matches=0
        for i in range(26):
            matches+= 1 if s1_freq[i]==s2_freq[i] else 0

        if matches==26:
            return True

        l=0
        for r in range(len(s1), len(s2)):
            s2_freq[ord(s2[r])-ord('a')]+=1
            
            if s1_freq[ord(s2[r])-ord('a')]==s2_freq[ord(s2[r])-ord('a')]:
                matches+=1
            elif s1_freq[ord(s2[r])-ord('a')]==s2_freq[ord(s2[r])-ord('a')]-1:
                matches-=1
            
            s2_freq[ord(s2[l])-ord('a')]-=1
            if s1_freq[ord(s2[l])-ord('a')]==s2_freq[ord(s2[l])-ord('a')]:
                matches+=1
            elif s1_freq[ord(s2[l])-ord('a')]==s2_freq[ord(s2[l])-ord('a')]+1:
                matches-=1

            l+=1
            
            if matches==26:
                return True
        
        return False