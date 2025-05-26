class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        if(n1!=n2) return false;
        int[] x=new int[n1];
        int[] y=new int[n2];
        for(int i=0;i<n1;i++){
            x[i]=s.indexOf(s.charAt(i));
        }
        for(int j=0;j<n2;j++){
            y[j]=t.indexOf(t.charAt(j));
        }
        return Arrays.equals(x,y);
    }
}