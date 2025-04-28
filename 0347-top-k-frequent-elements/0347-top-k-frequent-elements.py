from collections import Counter
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]: 
        # O(1) time 
        if k == len(nums):
            return nums
        
        # 1. Build hash map: character and how often it appears
        # O(N) time
        # count = Counter(nums)   
        # 2-3. Build heap of top k frequent elements and
        # convert it into an output array
        # O(N log k) time
        # return heapq.nlargest(k, count.keys(), key=count.get) 

        #BEST TC O(n), get hashmaps, then use bucketsort where index is counts of occurances, and value is arraylist of element
        size=len(nums)+1
        h_map={}
        for num in nums:
            h_map[num]=h_map.get(num,0)+1
        
        bucket_arr=[list() for _ in range(size)]

        for key,freq in h_map.items():
            bucket_arr[freq].append(key)
        
        result_arr=[]

        for idx in range(size-1, -1, -1):
            if len(result_arr)>=k:
                break
            
            if len(bucket_arr[idx])!=0:
                result_arr.extend(bucket_arr[idx])
        return result_arr[:k]