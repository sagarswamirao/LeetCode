class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        def get_index(c):
            return ord(c) - ord('a')

        num_of_substr = 0
        char_counts = [0, 0, 0]  # counts for 'a', 'b', 'c'

        left = 0
        for right in range(len(s)):
            char_counts[get_index(s[right])] += 1
            while (char_counts[0] >= 1 and char_counts[1] >= 1 and char_counts[2] >= 1):
                num_of_substr += (len(s) - right)
                char_counts[get_index(s[left])] -= 1
                left += 1

        return num_of_substr