class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        HashSet<String> hset=new HashSet<>();
        hset.add("+");
        hset.add("-");
        hset.add("/");
        hset.add("*");
        for(String token:tokens){
            if(hset.contains(token)){
                Integer i1=stack.pop();
                Integer i2=stack.pop();
                Integer result=0;
                if(token.equals("+")){
                    result=i1+i2;
                }else if(token.equals("-")){
                    result=i2-i1;
                }else if(token.equals("*")){
                    result=i1*i2;
                } else{
                    result=i2/i1;
                }
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(token));
            }
            
        }
        return stack.pop();
    }
}