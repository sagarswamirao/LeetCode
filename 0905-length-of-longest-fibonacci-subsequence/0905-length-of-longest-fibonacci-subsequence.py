class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        arr_map={n:i for i,n in enumerate(arr)}
        max_length=0
        dp={}
        # for i in reversed(range(len(arr)-1)):
        #     for j in reversed(range(i+1,len(arr))):
        for i in range(len(arr)-2,-1,-1):
            for j in range(len(arr)-1,i,-1):
                curr_length=2
                
                prev=i
                curr=j
                next_element=arr[prev]+arr[curr]

                if next_element in arr_map:
                    curr_length= 1+ dp[(curr, arr_map[next_element])]
                    max_length=max(curr_length,max_length)
                dp[(prev, curr)]=curr_length
                
        
        return max_length