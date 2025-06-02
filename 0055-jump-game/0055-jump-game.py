class Solution:
    def canJump(self, nums: List[int]) -> bool:
        goal = len(nums) - 1
        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= goal:
                goal = i
        return goal == 0


# class Solution:
#     def canJump(self, nums: List[int]) -> bool:
#         can_reach=False
#         def recursive(nums, curr_index, n):
#             nonlocal can_reach
#             if curr_index==n:
#                 can_reach=True
#                 return True
#             if curr_index>n:
#                 return False

#             for i in range(nums[curr_index]):
#                 next_index=curr_index+i+1
#                 if recursive(nums, next_index, n):
#                     return True
            
#             return False
#         recursive(nums, 0, len(nums)-1)
#         return can_reach