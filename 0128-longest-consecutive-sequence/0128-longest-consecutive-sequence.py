class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        """
        Finds the length of the longest consecutive elements sequence in the array.
        Time Complexity: O(n) - Each element is processed once.
        Space Complexity: O(n) - Additional space used for the hash set.
        """
        # Create a set from the input list for O(1) lookups.
        hset = set(nums)
        
        # Variable to store the maximum length of consecutive sequences.
        max_seq_length = 0

        # Iterate through each number in the hash set.
        for num in hset:           
            # Check if 'num' is the start of a sequence by ensuring (num - 1) is not in the set.
            # This ensures each sequence is only processed once, avoiding redundant computations.
            if num - 1 not in hset:
                # Initialize the current sequence's starting element.
                curr_seq_element = num
                
                # Start the length of the current sequence at 1.
                curr_seq_length = 1

                # Extend the sequence by checking if the next consecutive number exists in the set.
                while curr_seq_element + 1 in hset:
                    # Move to the next element in the sequence.
                    curr_seq_element += 1
                    
                    # Increment the current sequence length.
                    curr_seq_length += 1
                
                # Update the maximum sequence length found so far.
                max_seq_length = max(max_seq_length, curr_seq_length)

        # Return the length of the longest consecutive sequence.
        return max_seq_length
