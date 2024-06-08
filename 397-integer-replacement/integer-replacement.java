class Solution {
    public int integerReplacement(int n) {
        return recursion(n, 0);
    }

    // For int: 2^31 - 1
    // For long: 2^63 - 1
    // For float: 2^128
    // For double: 2^1024
    // Although the constraint in 2^31 -1, but as we are doing n+1, I code goes for a toss
    public int recursion(long n, int curr_steps){
        if(n==1){
            return curr_steps;
        }
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
        if(n%2==0){
            return recursion(n/2, curr_steps+1);
        }else{
            // if(n>0){
                return Math.min(recursion(n-1, curr_steps+1), recursion(n+1, curr_steps+1));
            // }else{         
            //     return recursion(n+1, curr_steps+1);
            // }
        }
        // return Math.min(a, b);
    }
}