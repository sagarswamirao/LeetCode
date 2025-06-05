// class Solution {
//     public void duplicateZeros(int[] arr) {
//         boolean nonZeroTrigger=false;
//         int zeroCount=0;
//         int ii=0;
//         int ij=0;
//         while(ij<arr.length){
//             if(arr[ii]==0){
//                 ij+=1;
//                 zeroCount+=1;
//             }
//             ii+=1;
//             ij+=1;
//         }

//         ii-=1;
//         // ij-=1;
//         int i=ii;
//         int j=arr.length-1;

//         while(i>=0 && j>=0){
//             if(arr[i]!=0){
//                 arr[j]=arr[i];
//                 i--;
//                 j--;
//             }else{
//                 arr[j]=0;
//                 if(j-1>=0) arr[j-1]=0;
//                 j=j-2;
//                 i=i-1;
//             }
//         }
//     }
// }
class Solution {
    public void duplicateZeros(int[] arr) {
        boolean nonZeroTrigger=false;
        int zeroCount=0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]!=0){
                nonZeroTrigger=true;
            }
            if(arr[i]==0){
                zeroCount++;
            }
        }
        // if(!nonZeroTrigger){
        //     return;
        // }
        int i=arr.length-1;
        int j=arr.length-1+zeroCount;

        while(i>=0){
            if(arr[i]!=0){
                if(j<arr.length) arr[j]=arr[i];
                i--;
                j--;
            }else{
                if(j<arr.length){
                    arr[j]=0;
                }
                j-=1;
                if(j<arr.length){
                    arr[j]=0;
                }
                j-=1;
                i=i-1;
            }
        }
    }
}