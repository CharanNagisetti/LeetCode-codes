class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n1=v1.length;
        int n2=v2.length;
        int i=0, j=0;
        while(i<n1 && j<n2){
            int x=Integer.parseInt(v1[i]);
            int y=Integer.parseInt(v2[j]);
            if(x!=y){
                if(x<y){
                    return -1;
                }
                else{
                    return 1;
                }
            }
            i++;
            j++;
        }
        while(i<n1){
            if(Integer.parseInt(v1[i])!=0){
                return 1;
            }
            i++;
        }
        while(j<n2){
            if(Integer.parseInt(v2[j])!=0){
                return -1;
            }
            j++;
        }
        return 0;
        
    }
}