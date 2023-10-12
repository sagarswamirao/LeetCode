class Solution {
    public int mySqrt(int x) {
    return Integer.parseInt(Double.toString(Math.sqrt(x)).split("\\.")[0]);   
    }
}