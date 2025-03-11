class Solution:
    def numberOfSubstrings1(self, s: str) -> int:
        char_last_seen_at_list=[-1,-1,-1]
        count_of_substrings=0

        for i, char in enumerate(s):
            char_last_seen_at_list[ord(char)-ord('a')]=i

            if char_last_seen_at_list[0]!=-1 and char_last_seen_at_list[1]!=-1 and char_last_seen_at_list[2]!=-1:
                count_of_substrings+= (1 + min(char_last_seen_at_list[0],min(char_last_seen_at_list[1], char_last_seen_at_list[2])))
        
        return count_of_substrings


    def all_3_chars_at_least_k(self, char_counts, k):
        return char_counts[0] >= k and char_counts[1] >= k and char_counts[2] >= k

    def helper(self, s: str, k: int) -> int:
        count_of_substrings = 0
        char_counts = [0, 0, 0]  # counts for 'a', 'b', 'c'

        left = 0
        for right in range(len(s)):
            char_counts[ord(s[right]) - ord('a')] += 1
            while self.all_3_chars_at_least_k(char_counts, k):
                count_of_substrings += (len(s) - right)
                char_counts[ord(s[left]) - ord('a')] -= 1
                left += 1

        return count_of_substrings

    def numberOfSubstrings(self, s: str) -> int:
        return self.helper(s, 1)  # count substrings that have at least one 'a', 'b', 'c'