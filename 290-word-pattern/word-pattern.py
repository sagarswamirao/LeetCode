class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        hMap={}
        words=s.split()
        pattern_list=list(pattern)
        if len(words)!=len(pattern_list):
            return False
        
        for word,pat in zip(words,pattern_list):
            if (pat in hMap.keys() and hMap[pat]!=word) or (pat not in hMap.keys() and word in hMap.values()):
                return False
            else:
                hMap[pat]=word

        return True