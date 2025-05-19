class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        in_use = [False for i in range(len(nums))]
        answer = []

        def recursive(n, ds):
            if len(ds) == n:
                answer.append(ds.copy())
                return

            for next_i in range(len(in_use)):
                if in_use[next_i] is True:
                    continue
                in_use[next_i] = True
                ds.append(nums[next_i])
                recursive(n, ds)
                in_use[next_i] = False
                ds.pop()

        recursive(len(nums), [])

        return answer
