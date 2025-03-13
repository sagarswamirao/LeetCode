class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        reduction_arr = [0]*(len(nums)+1)

        for query in queries:
            reduction_arr[query[0]]+=1
            reduction_arr[query[1]+1]-=1

        for i in range(1, len(reduction_arr)):
            reduction_arr[i]+=reduction_arr[i-1]

        for i in range(len(nums)):
            if nums[i]>reduction_arr[i]:
                return False
                
        return True