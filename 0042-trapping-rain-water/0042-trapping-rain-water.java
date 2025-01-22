class Solution {
    public int trap(int[] height) {
        /**
         * Calculates the total amount of water that can be trapped between bars in the elevation map.
         * 
         * Time Complexity: O(n) - The array is traversed once using two pointers.
         * Space Complexity: O(1) - No additional space is used apart from a few variables.
         * 
         */
        
        // If the array is empty, no water can be trapped.
        if (height.length == 0) {
            return 0;
        }

        int n = height.length; // Length of the elevation map.
        
        // Initialize two pointers: one starting from the left and one from the right.
        int left = 0, right = n - 1;
        
        // Initialize variables to track the maximum height seen from the left and right.
        int leftMax = height[left], rightMax = height[right];
        
        // Variable to store the total amount of water trapped.
        int ans = 0;

        // Traverse the array using two pointers.
        while (left < right) {
            // Update the maximum height seen so far from the left.
            leftMax = Math.max(leftMax, height[left]);
            
            // Update the maximum height seen so far from the right.
            rightMax = Math.max(rightMax, height[right]);

            // The amount of water trapped at the current position is determined
            // by the smaller of the two maximums (leftMax and rightMax).
            if (leftMax < rightMax) {
                // If the left maximum is smaller, calculate water trapped at 'left'
                // and move the left pointer to the right.
                ans += leftMax - height[left];
                left++;
            } else {
                // If the right maximum is smaller or equal, calculate water trapped at 'right'
                // and move the right pointer to the left.
                ans += rightMax - height[right];
                right--;
            }
        }

        // Return the total water trapped.
        return ans;
    }
}
