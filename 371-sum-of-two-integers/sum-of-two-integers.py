class Solution:
    def getSum(self, a: int, b: int) -> int:
        # Mask to handle 32-bit integer overflow
        MASK = 0xFFFFFFFF
        INT_MAX = 0x7FFFFFFF

        while b != 0:
            # Carry is the AND of a and b
            carry = (a & b) & MASK
            # XOR gives the sum without carry
            a = (a ^ b) & MASK
            # Shift carry to the left
            b = (carry << 1) & MASK

        # Handle overflow for negative numbers
        return a if a <= INT_MAX else ~(a ^ MASK)
