class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int maxOnesInWindow = 0;
        int overallMaxOnes = 0;
        int totalOnes = 0;

        // Count total number of 1s
        for (int num : nums) {
            if (num == 1) totalOnes++;
        }

        // Edge case: if there are 0 or all 1s, no swaps needed
        if (totalOnes <= 1) return 0;

        // Create extended array to simulate circular array
        int[] extended = new int[2 * n];
        for (int i = 0; i < n; i++) {
            extended[i] = nums[i];
            extended[i + n] = nums[i];
        }

        // Initial window count
        for (int i = 0; i < totalOnes; i++) {
            if (extended[i] == 1) maxOnesInWindow++;
        }
        overallMaxOnes = maxOnesInWindow;

        // Slide the window
        for (int i = 1; i < extended.length - totalOnes; i++) {
            if (extended[i - 1] == 1) maxOnesInWindow--;
            if (extended[i + totalOnes - 1] == 1) maxOnesInWindow++;
            overallMaxOnes = Math.max(overallMaxOnes, maxOnesInWindow);
        }

        return totalOnes - overallMaxOnes;
    }
}
