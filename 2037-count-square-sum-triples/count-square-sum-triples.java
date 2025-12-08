class Solution {
    public int countTriples(int n) {
        int cnt=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) continue;
                int n1=(int)Math.pow(i,2);
                int n2=(int)Math.pow(j,2);
                if(Math.sqrt(n1+n2)<=n){
                    int n3=(int)Math.sqrt(n1+n2);
                    if(n3*n3==n1+n2) cnt++;
                }
            }
        }
        return cnt;
    }
}