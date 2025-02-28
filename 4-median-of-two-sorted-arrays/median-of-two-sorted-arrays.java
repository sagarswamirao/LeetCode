class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) { // Ensuring nums1 is always the smaller array
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;
        int left = 0, right = nums1.length;

        while (left <= right) {
            int midA = (left + right) >> 1;
            int midB = half - midA;

            int leftA = (midA > 0) ? nums1[midA - 1] : Integer.MIN_VALUE;
            int leftB = (midB > 0) ? nums2[midB - 1] : Integer.MIN_VALUE;

            int rightA = (midA < nums1.length) ? nums1[midA] : Integer.MAX_VALUE;
            int rightB = (midB < nums2.length) ? nums2[midB] : Integer.MAX_VALUE;

            if (leftA <= rightB && leftB <= rightA) {
                if (total % 2 == 1) {
                    return Math.max(leftA, leftB);
                } else {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                }
            } else if (leftA > rightB) {
                right = midA - 1;  // Fix: Decrease right boundary
            } else {
                left = midA + 1;   // Fix: Increase left boundary
            }
        }
        return 0;
    }
}
