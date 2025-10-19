class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> set=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        String ans=s;
        q.offer(s);
        set.add(s);
        while(!q.isEmpty()){
            String curr=q.poll();
            if(curr.compareTo(ans)<0) ans=curr;
            char[] chars = curr.toCharArray();
            for(int i=1;i<chars.length;i+=2){
                chars[i]=(char)(((chars[i]-'0'+a)%10)+'0');
            }
            String add=new String(chars);
            String rotated=curr.substring(curr.length()-b)+curr.substring(0,curr.length() - b);
            if(set.add(add)) q.offer(add);
            if(set.add(rotated)) q.offer(rotated);
        }
        return ans;
    }
}