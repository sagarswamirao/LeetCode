class Solution {
    public int integerReplacement(int n) {
        return recursion(n, 0);
    }

    public int recursion(long n, int curr_steps){
        if(n==1){
            return curr_steps;
        }
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
        if(n%2==0){
            a= recursion(n/2, curr_steps+1);
        }else{
            if(n>0){
                b = Math.min(recursion(n-1, curr_steps+1), recursion(n+1, curr_steps+1));
            }else{         
                b = recursion(n+1, curr_steps+1);
            }
        }
        return Math.min(a, b);
    }
}