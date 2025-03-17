class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        freq_dict = {}
        unpaired_count = 0
        for num in nums:
            freq_dict[num] = freq_dict.get(num, 0) + 1
            if freq_dict[num] % 2 == 1:
                unpaired_count += 1
            else:
                unpaired_count -= 1
        return unpaired_count == 0
