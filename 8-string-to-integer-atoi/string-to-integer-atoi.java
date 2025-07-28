class Solution {
    public int myAtoi(String s) {
        int ans=0;
        int n=s.length();
        if(n==0) return 0;
        int i=0;
        int sign=1;
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i++)-'0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans=ans*10+digit;
        }
        return ans*sign;
    }
}