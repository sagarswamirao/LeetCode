class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:

        if max(nums)==0:
            return 0
        low=0
        high=len(queries)-1
        k=float('inf')
        while low<=high:
            mid= (low+high)//2
            if self.isZeroArrayPossible(nums,queries[0:mid+1]):
                k=min(k, mid+1)
                high=mid-1  
            else:
                low=mid+1
        
        if k==float('inf'):
            return -1
        return k

    def isZeroArrayPossible(self, nums, queries):
        reduction_arr = [0]*(len(nums)+1)

        for query in queries:
            reduction_arr[query[0]]+=query[2]
            reduction_arr[query[1]+1]-=query[2]
        
        for i in range(1, len(reduction_arr)):
            reduction_arr[i]+=reduction_arr[i-1]
        
        for i in range(len(nums)):
            if nums[i]>reduction_arr[i]:
                return False
        
        return True
