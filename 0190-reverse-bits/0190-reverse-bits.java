public class Solution {
    // you need treat n as an unsigned value
    // consider all 32 bits to reverse
    public int reverseBits(int n) {
        long answer = 0;
        for (int i = 0; i < 32; i++) {
            long bit = n & 1;
            answer = answer | (bit << (31 - i));
            n = n >> 1;
        }
        return (int) answer;
    }

}