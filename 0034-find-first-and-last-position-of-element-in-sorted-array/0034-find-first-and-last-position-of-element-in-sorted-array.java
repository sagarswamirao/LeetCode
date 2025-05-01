class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurrence = this.findLowerBound(nums, target);

        if (firstOccurrence == -1) {
            return new int[] { -1, -1 };
        }

        int lastOccurrence = this.findUpperBound(nums, target);

        return new int[] { firstOccurrence, lastOccurrence };
    }

    private int findLowerBound(int[] nums, int target) {
        int N = nums.length;
        int begin = 0, end = N - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;

            if (nums[mid] == target) {
                // This means we found our lower bound.
                if (mid == begin || nums[mid - 1] != target) {
                    return mid;
                }

                // Search on the left side for the bound.
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return -1;
    }

    private int findUpperBound(int[] nums, int target) {
        int N = nums.length;
        int begin = 0, end = N - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;

            if (nums[mid] == target) {
                // This means we found our upper bound.
                if (mid == end || nums[mid + 1] != target) {
                    return mid;
                }

                // Search on the right side for the bound.
                begin = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return -1;
    }
}