class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] result=new int[]{-1,-1};

        ArrayList<Integer> primes = generatePrimesInRangeUsingSieveOfEratosthenes(left, right);

        // takes O(n log n)
        // ArrayList<Integer> primes = generatePrimesInRange(left, right);   
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

    public ArrayList<Integer> generatePrimesInRangeUsingSieveOfEratosthenes(int left, int right){
        ArrayList<Integer> primes=new ArrayList<>();
        boolean[] isPrimes=new boolean[right+1];
        Arrays.fill(isPrimes,true);
        isPrimes[0]=false;
        isPrimes[1]=false;
        for(int num=0;num<=Math.sqrt(right);num++){
            if(!isPrimes[num]) continue;
            int j=num*2;
            while(j<=(right)){
                isPrimes[j]= false;
                j+=num;
            }
        }

        for(int num=left;num<=right;num++){
            if(isPrimes[num])
            primes.add(num);
        }

        return primes;
    }


// takes O(n log n)
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