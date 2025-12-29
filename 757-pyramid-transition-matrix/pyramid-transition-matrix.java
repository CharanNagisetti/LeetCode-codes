class Solution {
    public boolean backTrack(String bottom,Map<String, List<Character>> map, StringBuilder sb, int idx){
        if(bottom.length()==1) return true;
        if(sb.length()==bottom.length()-1){
            bottom=sb.toString();
            sb=new StringBuilder();
            return backTrack(bottom,map,sb,0);
        }
        String curr=bottom.substring(idx,idx+2);
        if(!map.containsKey(curr)) return false;
        for(char ch: map.get(curr)){
            sb.append(ch);
            if(backTrack(bottom,map,sb,idx+1)) return true;
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map=new TreeMap<>();
        for(String s: allowed){
            String str=s.substring(0,2);
            Character c=s.charAt(2);
            map.computeIfAbsent(str,k -> new ArrayList<>()).add(c);
        }
        StringBuilder sb=new StringBuilder();
        return backTrack(bottom,map,sb,0);
    }
}