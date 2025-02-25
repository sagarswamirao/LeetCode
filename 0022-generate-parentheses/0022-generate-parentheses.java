class Solution {
    public List<String> generateParenthesis(int n) {
    ArrayList<String> result= new ArrayList<String>();
    this.recursive(new ArrayList<String>(), result, 0, n);
    return result;
    }

    public void recursive(ArrayList<String> currString, ArrayList<String> result, int open, int n) {
        if(open == 0 && currString.size()==2*n){
            result.add(String.join("",currString));
        }
        if(open < 0 || open>n || currString.size()>2*n){
            return;
        }
        currString.add("(");
        this.recursive(currString, result, open+1, n);
        currString.removeLast();
        currString.add(")");
        this.recursive(currString, result, open-1, n);
        currString.removeLast();
}
}