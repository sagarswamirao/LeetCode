class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        char_last_seen_at_list=[-1,-1,-1]
        count_of_substrings=0

        for i, char in enumerate(s):
            char_last_seen_at_list[ord(char)-ord('a')]=i

            if char_last_seen_at_list[0]!=-1 and char_last_seen_at_list[1]!=-1 and char_last_seen_at_list[2]!=-1:
                count_of_substrings+= (1 + min(char_last_seen_at_list[0],min(char_last_seen_at_list[1], char_last_seen_at_list[2])))
        
        return count_of_substrings
        