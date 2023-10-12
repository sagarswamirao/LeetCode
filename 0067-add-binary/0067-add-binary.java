class Solution {
    public String addBinary(String a, String b) {
        ArrayList<String> strList=new ArrayList<>();
        int a_index=a.length()-1;
        int b_index=b.length()-1;
        int carry=0;
        int max_count=(a_index>b_index)?a_index:b_index;
        for(int i=0;i<=max_count;i++){
            Character a_char=(a_index-i>=0)?a.charAt(a_index-i):'0';
            Character b_char=(b_index-i>=0)?b.charAt(b_index-i):'0';
            if(a_char.equals('1') && b_char.equals('1')){
                if(carry==1){
                    strList.add("1");
                    carry=1;
                }else{
                    strList.add("0");
                    carry=1;
                }
            }else if(a_char.equals('1') || b_char.equals('1')){
                if(carry==1){
                    strList.add("0");
                    carry=1;
                }else{
                    strList.add("1");
                    carry=0;
                } 
            }else{
                if(carry==1){
                    strList.add("1");
                    carry=0;
                }else{
                    strList.add("0");
                }
            }
        }
        String s1="";
        for(String s:strList){
            s1=s+s1;
        }
        s1=carry==1?"1"+s1:s1;
        return s1;
    }
}