class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        result=[]
        min_len=min(len(word1),len(word2))
        for w1,w2 in zip(word1,word2):
            result.append(w1+w2)
        
        if len(word1)>min_len:
            result.append(word1[min_len:])
        if len(word2)>min_len:
            result.append(word2[min_len:])
        return "".join(result)