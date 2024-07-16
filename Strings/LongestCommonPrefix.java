package Strings;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int count = 0;
        boolean breaked =false;
        int min = Integer.MAX_VALUE;
        for(String s : strs){
            min = Math.min(min, s.length());
        }
        for(int j=0; j<min; j++){
            for(int i=0; i<strs.length-1; i++){
                if(strs[i].charAt(j) == strs[i+1].charAt(j)){
                    continue;
                }
                else{
                    breaked = true;
                    break;
                }
            }
            if(breaked) break;
            count++;
        }
        return strs[0].substring(0,count);
    }
}
