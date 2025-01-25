from typing import List

class Solution:
    def maxArea(self, height: List[int]) -> int:
        i, j = 0, len(height) - 1  # Two pointers
        ans = 0  # Variable to store the maximum area

        while i < j:
            # Calculate the area between the two pointers
            area = (j - i) * min(height[i], height[j])
            ans = max(ans, area)

            # Move the pointer pointing to the shorter line
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1

        return ans
