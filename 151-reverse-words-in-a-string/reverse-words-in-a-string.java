class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] x=s.split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=x.length-1;i>=0;i--){
            sb.append(x[i]+" ");
        }
        return sb.toString().trim();
    }
}