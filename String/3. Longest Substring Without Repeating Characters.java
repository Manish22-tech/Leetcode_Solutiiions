class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low=0,high=0;
        Set<Character>man=new HashSet<>();
        int max=0;
        while(high<s.length()){
            char c=s.charAt(high);
            if(man.add(c)){
                max=Math.max(max,high-low+1);
                high++;
            } else{
                while(s.charAt(low)!=c){
                    man.remove(s.charAt(low));
                    low++;
                }
                man.remove(c);
                low++;
                
            }
        }
        return max;
    }
}
