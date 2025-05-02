class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller (or equal-sized) array for binary search efficiency
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;  // Midpoint of combined array (handles both even/odd total lengths)
        int left = 0, right = nums1.length;

        // Binary search on the smaller array
        while (left <= right) {
            int midA = (left + right) >> 1;         // Partition index for nums1
            int midB = half - midA;                 // Complement partition index for nums2

            // Handle edge cases by using Integer.MIN_VALUE and Integer.MAX_VALUE
            int leftA = (midA > 0) ? nums1[midA - 1] : Integer.MIN_VALUE;  // Max of left part in nums1
            int leftB = (midB > 0) ? nums2[midB - 1] : Integer.MIN_VALUE;  // Max of left part in nums2

            int rightA = (midA < nums1.length) ? nums1[midA] : Integer.MAX_VALUE;  // Min of right part in nums1
            int rightB = (midB < nums2.length) ? nums2[midB] : Integer.MAX_VALUE;  // Min of right part in nums2

            // Valid partition condition: All left elements <= right elements
            if (leftA <= rightB && leftB <= rightA) {
                // If total length is odd, return max of left elements
                if (total % 2 == 1) {
                    return Math.max(leftA, leftB);
                } else {
                    // If even, return average of max left and min right
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                }
            } else if (leftA > rightB) {
                // Move left in nums1
                right = midA - 1;
            } else {
                // Move right in nums1
                left = midA + 1;
            }
        }

        // This return should not be reached; added to satisfy compiler
        return 0;
    }
}
