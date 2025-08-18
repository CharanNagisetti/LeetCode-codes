class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<Integer> eval=new Stack<>();
        for(int i=0;i<n;i++){
            if(tokens[i].equals("+")){
                int a2=eval.pop();
                int a1=eval.pop();
                int x=a1+a2;
                eval.push(x);
            }
            else if(tokens[i].equals("-")){
                int a2=eval.pop();
                int a1=eval.pop();
                int y=a1-a2;
                eval.push(y);
            }else if(tokens[i].equals("*")){
                int a2=eval.pop();
                int a1=eval.pop();
                int z=a1*a2;
                eval.push(z);
            }else if(tokens[i].equals("/")){
                int a2=eval.pop();
                int a1=eval.pop();
                if(a2!=0){
                    int l=a1/a2;
                    eval.push(l);
                }
            }else{
                eval.push(Integer.parseInt(tokens[i]));
            }
        }
        return eval.pop();
    }
}