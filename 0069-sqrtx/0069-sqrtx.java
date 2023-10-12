class Solution {
    public int mySqrt(int x) {
        Double a=Math.sqrt(x);
        String s1=Double.toString(Math.sqrt(x));
        String[] s=s1.split("\\.");
    return Integer.parseInt(s[0]);   
    }
}