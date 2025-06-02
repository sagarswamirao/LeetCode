class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_index_can_reach=0
        for i in range(0, len(nums)):
            if i > max_index_can_reach:
                return False
            max_index_can_reach = max(i + nums[i], max_index_can_reach)

            if max_index_can_reach>=len(nums)-1:
                return True
        return True

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