class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int yNo=0;
        int nNo=0;
        for(char x: customers.toCharArray()){
            if(x=='Y') yNo++;
            else if(x=='N') nNo++;
        }
        int[] penalty=new int[n+1];
        penalty[0]=yNo;
        int noCust=0;
        for(int i=1;i<=n;i++){
            if(customers.charAt(i-1)=='Y'){
                yNo--;
            }
            penalty[i]=noCust+yNo;
            if(customers.charAt(i-1)=='N'){
                noCust++;
            }
        }
        int min=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<=n;i++){
            if(min>penalty[i]){
                min=penalty[i];
                ans=i;
            }
        }
        return ans;
    }
}