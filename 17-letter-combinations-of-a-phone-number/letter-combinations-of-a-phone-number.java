class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        List<String> ans=new ArrayList<>();
        backTrack(digits,0,new StringBuilder(), ans);
        return ans;
    }
    private static final String[] digitToLetters={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private void backTrack(String digits, int i, StringBuilder sb, List<String> ans){
        if(i==digits.length()){
            ans.add(sb.toString());
            return;
        }
        for(final char c: digitToLetters[digits.charAt(i)-'0'].toCharArray()){
            sb.append(c);
            backTrack(digits,i+1,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}