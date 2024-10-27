# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        low=1
        high=n
        while low<=high:
            mid=low + (high - low)// 2

            guess_response= guess(mid)

            if guess_response==-1: # means we choose a higher val, we have to reduce
                high=mid-1
            elif guess_response==1: # means we choose a smaller val, we have to increase
                low=mid+1
            else:
                return mid

        return -1