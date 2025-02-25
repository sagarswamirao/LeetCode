class Solution {

    public int numOfSubarrays(int[] arr) {
        int MOD = (int) Math.pow(10, 9)+7;
        int count = 0, prefixSum = 0;
        // evenCount starts as one since the initial sum (0) is even
        int oddCount = 0, evenCount = 0;

        for (int num : arr) {
            prefixSum += num;
            // If current prefix sum is even, add the number of odd subarrays
            if (prefixSum % 2 == 0) {
                count += oddCount;
                evenCount++;
            } else {
                // If current prefix sum is odd, add the number of even
                // subarrays
                count += 1+ evenCount;
                oddCount++;
            }

            count %= MOD; // To handle large results
        }

        return count;
    }
}