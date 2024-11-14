class Solution:
    def can_distribute(self, quantity_val_to_distribute: int, quantities: List[int], num_retail_stores: int) -> bool:
        # Pointer to the first not fully distributed product type
        j = 0
        # Remaining quantity of the 0th product type
        remaining = quantities[0]

        # Loop through each store
        for i in range(num_retail_stores):
            # Check if the remaining quantity of the 0th product type
            # can be fully distributed to the ith store
            if remaining <= quantity_val_to_distribute:
                # If yes, move the pointer to the next product type
                j += 1
                # Check if all products have been distributed
                if j == len(quantities):
                    return True
                else:
                    remaining = quantities[j]
            else:
                # Distribute the maximum possible quantity (x) to the ith store
                remaining -= quantity_val_to_distribute

        return False

    def minimizedMaximum(self, num_retail_stores: int, quantities: List[int]) -> int:
        # Initialize the boundaries of the binary search
        left = 0
        right = max(quantities)

        # Perform binary search until the boundaries converge
        while left < right:
            middle = (left + right) // 2
            quantity_val_to_distribute = middle
            if self.can_distribute(quantity_val_to_distribute, quantities, num_retail_stores):
                # Try for a smaller maximum
                right = middle
            else:
                # Increase the minimum possible maximum
                left = middle + 1

        return left

# Determine the range of binary search

# We want to keep checking for a lower value of quanitity to distribute to each of the companies.

# Binary search using the can_distribute -> return boolean whether if possible or not. Aim of the can_distribute function is to see whether if given the distribution_rate, can we distribute to all the companies or not. 