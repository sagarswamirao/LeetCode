class Solution:
    def climbStairs(self, n: int) -> int:
        memo=[0] * (n+1)
        return self.climbStepsRecursive(0,n,memo)
    def climbStepsRecursive(self, i, n, memo):
        if i==n:
            return 1
        if i>n:
            return 0
        
        if memo[i]!=0:
            return memo[i]
        
        memo[i]=self.climbStepsRecursive(i+1,n, memo) + self.climbStepsRecursive(i+2,n, memo)
        return memo[i]