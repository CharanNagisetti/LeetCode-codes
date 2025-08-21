class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length()==0 || num2.length()==0 || (num1.equals("0") || num2.equals("0"))){
            return "0";
        }
        int[] ans=new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int a=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int pos1=i+j;
                int pos2=i+j+1;
                int total=a+ans[pos2];
                ans[pos2]=total%10;
                ans[pos1]+=total/10;                
            }
        }
        StringBuilder sb=new StringBuilder();
        boolean flag=true;
        for(int a=0;a<ans.length;a++){
            if(flag && ans[a]==0){
                flag=true;
            }
            else{
                flag=false;
            }
            if(!flag){
                sb.append(ans[a]);
            }
        }
        return sb.toString();
    }
}