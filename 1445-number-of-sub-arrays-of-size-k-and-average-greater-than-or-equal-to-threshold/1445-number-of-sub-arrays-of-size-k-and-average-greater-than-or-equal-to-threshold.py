class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        countOfSubarrays=0
        l=0
        currSubarraySum=0
        for r in range(len(arr)):
            currSubarraySum+=arr[r]
            while (r-l+1)>k:
                currSubarraySum-=arr[l]
                l+=1
            if (r-l+1)==k and (currSubarraySum/k)>=threshold:
                countOfSubarrays+=1
        return countOfSubarrays
