class Solution {
    public String decodeString(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuffer main_sb= new StringBuffer();
        for(Character c: s.toCharArray()){
            if(!c.equals(']')){
                stack.push(c);
            }else{
                StringBuilder sb= new StringBuilder();
                while(stack.peek()!='['){
                    sb.insert(0, stack.pop());
                }
                stack.pop();// remove [
                int k=0;
                int base=1;
                 while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k= k + (Character.getNumericValue(stack.pop()) * base);
                    base *= 10;
                 }
                while(k!=0){
                    // main_sb.insert(0,sb.toString());
                    for(int i=0;i<sb.length();i++){
                        stack.push(sb.charAt(i));
                    }
                    k--;
                }
            }
        }
        while(!stack.isEmpty()){
            main_sb.append(stack.removeFirst());
        }
        
        return main_sb.toString();
    }
}