class Solution {
    public int smallestNumber(int n) {
        int[] arr=new int[30];
        for(int i=1;i<=30;i++){
            arr[i-1]=(int) Math.pow(2,i)-1;
        }
        int i=0;
        while(arr[i]<n){
            i++;
        }
        return arr[i];
    }
}