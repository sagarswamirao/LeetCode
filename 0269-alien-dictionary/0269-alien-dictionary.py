class Solution:
    def alienOrder(self, words: List[str]) -> str:
        #2 things to keep in mind
        # if the first min(a.length, b.length) characters do not differ, then the shorter string is the lexicographically smaller one.

        adj={c:set() for w in words for c in w}

        for i in range(len(words)-1):
            w1, w2=words[i], words[i+1]
            min_length=min(len(w1), len(w2))
            if len(w1)>len(w2) and w1[:min_length]==w2[:min_length]:
                return ""
            for j in range(min_length):
                if w1[j]!=w2[j]:
                    adj[w1[j]].add(w2[j])
                    break
        
        visited={}
        result=[]
        def dfs_to_check_if_cycle_exists(c):
            if c in visited:
                return visited[c]
        
            visited[c]=True
            for nei in adj[c]:
                if dfs_to_check_if_cycle_exists(nei):
                    return True
            visited[c]=False
            result.append(c)
        
        for c in adj:
           if dfs_to_check_if_cycle_exists(c):
                return ""
        result.reverse()
        return "".join(result)