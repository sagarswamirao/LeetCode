class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] result=new int[]{-1,-1};
        ArrayList<Integer> primes= generatePrimesInRange(left, right);   
        if(primes.size()<2){
            return result;
        }
        Integer minDifference= Integer.MAX_VALUE;
        for(int i=0;i<primes.size()-1;i++){
            if((primes.get(i+1)-primes.get(i))<minDifference){
                result[0]=primes.get(i);
                result[1]=primes.get(i+1);
                minDifference=primes.get(i+1)-primes.get(i);
            }
        }
        return result;     

    }
    public ArrayList<Integer> generatePrimesInRange(int left, int right){
        ArrayList<Integer> primes=new ArrayList<>();
        for(int num=left;num<=right;num++){
            Boolean isPrime=true;
            for(int j=2;j<=Math.sqrt(num);j++){
                if(num%j==0){
                    isPrime= false;
                    break;
                }
            }
            if(!isPrime || num<2){
                continue;
            }
            primes.add(num);
        }
        return primes;
    }
}