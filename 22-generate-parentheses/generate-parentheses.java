class Solution {
    public List<String> generateParenthesis(int n) {
    ArrayList<String> result= new ArrayList<String>();
    this.recursive(new ArrayList<String>(), result, 0, 0, n);
    return result;
    }

    public void recursive(ArrayList<String> currString, ArrayList<String> result, int open, int close, int n) {
        if(currString.size()==2*n){
            result.add(String.join("",currString));
            return;
        }
        if(open<n){
            currString.add("(");
            this.recursive(currString, result, open+1, close, n);
            currString.removeLast();
        }
        if(open > close){
            currString.add(")");
            this.recursive(currString, result, open, close+1, n);
            currString.removeLast();
        }
    }
}