class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> s=new ArrayList<String>();
        for(int i=1;i<=n;i++){
            Boolean a=i%3==0;
            Boolean b=i%5==0;
            if(a && b){
                s.add("FizzBuzz");
            }else if(a){
                s.add("Fizz");
            }else if(b){
                s.add("Buzz");
            }else{
                s.add(Integer.toString(i));
            }
        }
        return s;
    }
}