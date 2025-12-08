class Solution {
    public int countTriples(int n) {
        int cnt=0;
        for(int i=1;i<=n;i++){
            int n1=i*i;
            for(int j=1;j<i;j++){
                int n2=n1-j*j;
                int n3=(int)Math.sqrt(n2);
                if(n3*n3==n2) cnt++;
            }
        }
        return cnt;
    }
}