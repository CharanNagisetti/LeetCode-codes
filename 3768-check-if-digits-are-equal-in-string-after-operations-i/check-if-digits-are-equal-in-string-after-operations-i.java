class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()!=2){
            char[] arr=s.toCharArray();
            int n=s.length();
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n-1;i++){
            char x = (char)(((arr[i] - '0') + (arr[i + 1] - '0')) % 10 + '0');
                sb.append(x+"");
            }
            s=sb.toString();
        }
        char[] arr=s.toCharArray();
        if(arr[0]==arr[1]) return true;
        return false;
    }
}