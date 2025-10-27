class Solution {
    public int numberOfBeams(String[] bank) {
        int ans=0;
        int n=bank.length;
        ArrayList<Integer> check=new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] arr=bank[i].toCharArray();
            int count=0;
            for(char x: arr){
                if(x=='1'){
                    count++;
                }
            }
            if(count>0) check.add(count);
        }
        for(int i=1;i<check.size();i++){
            ans+=check.get(i)*check.get(i-1);
        }
        return ans;
    }
}