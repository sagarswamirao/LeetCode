class Solution:
    def is_valid(self, houses, capability, k):
        index = 0
        possible_thefts=0
        while index < len(houses):
            if houses[index] <= capability:
                possible_thefts += 1
                index += 2  # Skip the next house to maintain the non-adjacent condition
            else:
                index += 1
            
        return possible_thefts>=k

    def minCapability(self, nums, k):
        # Store the maximum nums value in maxReward.
        min_reward, max_reward = min(nums), max(nums)
        result=0
        # Use binary search to find the minimum reward possible.
        while min_reward <= max_reward:
            mid_reward = (min_reward + max_reward) // 2
            if self.is_valid(nums, mid_reward, k):
                result=mid_reward
                max_reward=mid_reward-1
            else:
                min_reward = mid_reward + 1
        return result

