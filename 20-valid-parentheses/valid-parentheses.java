class Solution {
    public boolean isValid(String s) {
        Stack<Character> ans=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char x=s.charAt(i);
            if(x=='(' || x=='{' || x=='['){
                ans.push(x);
            }else{
                if(ans.isEmpty()){
                    return false;
                }
                    char top=ans.peek();
                    ans.pop();
               if((top == '(' && x == ')') || 
                (top == '[' && x == ']') || 
                (top == '{' && x == '}')) {
                    continue;
                } else {
                    return false;
                }
                }
            }
            
        if(ans.isEmpty()) return true;
        return false;
        }
}