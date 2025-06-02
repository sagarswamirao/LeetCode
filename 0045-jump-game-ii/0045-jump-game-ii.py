class Solution:
    def jump(self, nums: List[int]) -> int:
        l=0
        r=0
        jumps_count=0

        while r < len(nums)-1:
            farthest=0
            jumps_count+=1
            for idx in range(l, r+1):
                farthest=max(farthest, idx + nums[idx])
            
            l=r+1
            r=farthest
        return jumps_count


    # def jump(self, nums: List[int]) -> int:
    #     minimum_jumps_to_target= 10**4
    #     def recursive(nums, curr_index, n, curr_jumps):
    #         nonlocal memo
    #         nonlocal minimum_jumps_to_target

    #         if curr_index==n:
    #             minimum_jumps_to_target=min(minimum_jumps_to_target, curr_jumps)

    #         if curr_index>n:
    #             return

    #         for i in range(nums[curr_index]):
    #             next_index=curr_index+i+1
    #             recursive(nums, next_index, n, curr_jumps+1)
    #     recursive(nums, 0, len(nums)-1, 0)

    #     return minimum_jumps_to_target