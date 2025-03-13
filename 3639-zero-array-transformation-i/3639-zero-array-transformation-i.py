class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        # Step 1: Initialize a difference array for efficient range updates.
        # We use length (n + 1) to avoid index errors during the decrement operation.
        reduction_arr = [0] * (len(nums) + 1)

        # Step 2: Apply range increment operations using difference array technique.
        for query in queries:
            l, r = query  # Extract start and end indices of the range.
            reduction_arr[l] += 1  # Mark the start of reduction (+1)
            reduction_arr[r + 1] -= 1  # Mark end+1 to neutralize reduction beyond 'r'.

        # Step 3: Compute the prefix sum to get the total reduction applied at each index.
        # After this loop, reduction_arr[i] will hold the number of times nums[i] is reduced.
        for i in range(1, len(reduction_arr)):
            reduction_arr[i] += reduction_arr[i - 1]

        # Step 4: Check if every number in 'nums' can be reduced to zero or less.
        # If any nums[i] requires more reductions than applied, return False.
        for i in range(len(nums)):
            if nums[i] > reduction_arr[i]:  # Not enough reductions applied.
                return False  # Impossible to reduce nums[i] to zero or below.

        # Step 5: If all numbers can be reduced to zero or below, return True.
        return True
