class Solution {
    public boolean isPalindrome(String s) {
    s=s.toUpperCase().trim();
     int i=0,j=s.length()-1;
     while(i<j){
        Character iC, jC;
        if(!Character.isLetterOrDigit(s.charAt(i))){
            i++;
            continue;   
        }

        if(!Character.isLetterOrDigit(s.charAt(j))){
            j--;
            continue;
        }

        iC=s.charAt(i);
        jC=s.charAt(j);

        if(!iC.equals(jC)){
            return false;
        }
        i++;
        j--;
     }
     return true;   
    }
}