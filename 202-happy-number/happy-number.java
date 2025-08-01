class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> l=new HashSet<>();
        while(n!=1 && !l.contains(n)){
            l.add(n);
            int temp=n;
            int x=0;
            while(temp>0){
                int sqr=temp%10;
                x+=sqr*sqr;
                temp=temp/10;
            }
            n=x;
            System.out.println(x);
        }
        return n==1;
    }
}