class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        int d = n%7;
        int w = n/7;
        for(int i = 0; i < w; i++) {
            sum += 28 + (7*i);
        }
        for(int i = 1; i <= d; i++) {
            sum += i+w; 
        }
        return sum;
    }
}