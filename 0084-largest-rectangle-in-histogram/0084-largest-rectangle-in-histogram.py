class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []  # Stack will store pairs: (index, height)
        max_area = 0  # Variable to keep track of the maximum area found so far

        # Iterate over all bars in the histogram
        for i, h in enumerate(heights):
            start = i  # Initially assume the rectangle starts at the current index

            # If the current bar is shorter than the bar at the top of the stack,
            # it means we can't extend the previous rectangle beyond this point.
            while stack and stack[-1][1] > h:
                index, height = stack.pop()  # Pop the last rectangle from the stack
                # Calculate the area using the height of the popped bar
                max_area = max(max_area, height * (i - index))
                start = index  # Update the start to the index where this popped height started

            # Push the current height and its corresponding start index onto the stack
            stack.append((start, h))

        # After processing all bars, there might still be items in the stack
        # These represent increasing heights that extend to the end of the histogram
        while stack:
            index, height = stack.pop()
            max_area = max(max_area, height * (len(heights) - index))

        return max_area
