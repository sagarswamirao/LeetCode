class Solution:
    def checkPowersOfThree(self, n: int) -> bool:
        powers_of_3=[1]*17
        max_power=0
        for i in range(1,17):
            powers_of_3[i]=powers_of_3[i-1]*3
            max_power=i
            if powers_of_3[i]>=n:
                break
        
        def recursive(i, max_power, curr_sum, target):
            if curr_sum==target:
                return True
            
            if curr_sum>target:
                return False

            if i>max_power:
                return False


            take = recursive(i+1, max_power, curr_sum+powers_of_3[i], target)

            nottake = recursive(i+1, max_power, curr_sum, target)

            return take or nottake

        return recursive(0, max_power, 0, n)