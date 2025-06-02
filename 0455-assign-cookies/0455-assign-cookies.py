class Solution:
    def findContentChildren(self, greed_arr: List[int], cookie_size_arr: List[int]) -> int:
        greed_arr.sort()
        cookie_size_arr.sort()

        children_satisfied_count=0

        left=0
        right=0
        while left<len(cookie_size_arr) and right<len(greed_arr):
            if cookie_size_arr[left]>=greed_arr[right]:
                children_satisfied_count+=1
                left+=1
                right+=1
            else:
                left+=1
        
        return children_satisfied_count
