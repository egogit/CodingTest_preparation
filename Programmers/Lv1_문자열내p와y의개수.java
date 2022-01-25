class Solution {
    boolean solution(String s) {
        boolean answer;
        int pCount = 0;
        int yCount = 0;
        
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p'){
                pCount++;
            }else if(s.charAt(i)=='y'){
                yCount++;
            }
        }
        answer = (pCount == yCount) ? true : false;
        return answer;
    }
}

