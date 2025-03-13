class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        if not self.isZeroArrayPossible(nums, queries):
            return -1

        low = 0
        high = len(queries)

        while low <= high:
            mid = (low + high) // 2
            if self.isZeroArrayPossible(nums, queries[0:mid]):
                high = mid - 1
            else:
                low = mid + 1

        return low

    def isZeroArrayPossible(self, nums, queries):
        reduction_arr = [0] * (len(nums) + 1)

        for query in queries:
            reduction_arr[query[0]] += query[2]
            reduction_arr[query[1] + 1] -= query[2]

        for i in range(1, len(reduction_arr)):
            reduction_arr[i] += reduction_arr[i - 1]
            if nums[i - 1] > reduction_arr[i - 1]:
                return False

        # for i in range(len(nums)):
        #     if nums[i] > reduction_arr[i]:
        #         return False

        return True
