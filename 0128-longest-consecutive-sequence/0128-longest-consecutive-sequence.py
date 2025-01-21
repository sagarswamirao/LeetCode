class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        hset=set()
        max_seq_length=0
        
        for num in nums:
            hset.add(num)
        for num in nums:
            
            if num in hset:
                curr_seq_element=num
                while curr_seq_element-1 in hset:
                    curr_seq_element-=1
                curr_seq_length=0
                while curr_seq_element in hset:
                    hset.remove(curr_seq_element)
                    curr_seq_element+=1
                    curr_seq_length+=1
                max_seq_length=max(max_seq_length, curr_seq_length)
            else:
                continue

        return max_seq_length