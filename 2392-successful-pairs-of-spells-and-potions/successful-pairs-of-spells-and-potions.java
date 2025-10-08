class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        int[] ans=new int[n];
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            int x=spells[i];
            int count=0;
            int start=0;
            int end=m-1;
            int idx = potions.length; 
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if ((long)x * potions[mid] >= success) {
                    idx = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            ans[i]=m-idx;
        }
        return ans;
    }
}