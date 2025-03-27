class Solution:
    def minimumIndex(self, nums: List[int]) -> int:
        
        def check_and_get_majority_element():
            majority_ele=int(1e10)
            freq=0
            for num in nums:
                if freq<=0:
                    freq=0
                    majority_ele=num
                if majority_ele==num:
                    freq+=1
                else:
                    freq-=1

            freq_verify=0
            for num in nums:
                if majority_ele==num:
                    freq_verify+=1
            return [majority_ele, freq_verify] if freq_verify>=len(nums)//2 else [int(1e10), -1]            
        
        majority_ele, freq_verify =check_and_get_majority_element()

        if majority_ele==int(1e10):
            return -1

        left_count=0

        for idx, num in enumerate(nums):
            if num==majority_ele:
                left_count+=1

            # if left_count!=0 and left_count>(idx+1)//2 and (freq_verify-left_count)>=((len(nums)-idx - 1)//2):
            #     return idx
            if left_count > (idx + 1) // 2 and (freq_verify - left_count) > (len(nums) - idx - 1) // 2:
                return idx
        return -1