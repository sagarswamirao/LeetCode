class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_index_can_reach = 0
        for i in range(0, len(nums)):
            if i > max_index_can_reach:
                return False
            max_index_can_reach = max(i + nums[i], max_index_can_reach)

            if max_index_can_reach >= len(nums) - 1:
                return True
        return True


# This greedy solution checks whether you can reach the end of the array by tracking the 
# farthest index (max_index_can_reach) reachable so far. As you iterate through the array, 
# if the current index i is ever greater than max_index_can_reach, it means you're stuck and 
# can't move forward—so return False. Otherwise, update the farthest reachable index using i + nums[i]. 
# If at any point this value reaches or exceeds the last index, return True early. This ensures an efficient
# solution with O(n) time and O(1) space complexity.

# Recursion + Memo
# class Solution:
#     def canJump(self, nums: List[int]) -> bool:
#         memo={}
#         def recursive(nums, curr_index, n):
#             nonlocal memo

#             if curr_index in memo:
#                 return memo[curr_index]

#             if curr_index==n:
#                 return True

#             for i in range(nums[curr_index]):
#                 next_index=curr_index+i+1
#                 if next_index>n:
#                     continue
#                 if recursive(nums, next_index, n):
#                     memo[curr_index]=True
#                     return True
#             memo[curr_index]=False
#             return False
#         return recursive(nums, 0, len(nums)-1)
