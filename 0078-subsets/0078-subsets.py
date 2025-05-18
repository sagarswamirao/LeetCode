class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ds = []
        ans = []

        def recursive(nums, i, n, ds, ans):
            # using pick/not-pick
            if i == n:
                ans.append(list(ds))
                return

            # pick
            ds.append(nums[i])
            recursive(nums, i + 1, n, ds, ans)
            ds.pop()

            # not-pick
            recursive(nums, i + 1, n, ds, ans)

        recursive(nums, 0, len(nums), ds, ans)
        return ans
