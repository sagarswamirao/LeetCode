class Solution:
    def canJump(self, nums: List[int]) -> bool:
        goal = len(nums) - 1
        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= goal:
                goal = i
        return goal == 0

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