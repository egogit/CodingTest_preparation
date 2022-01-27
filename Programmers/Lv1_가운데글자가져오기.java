class Solution {
    public String solution(String s) {
        String answer = "";

        int length = s.length();
        int mid;
        if(length%2==1){
            mid = (length+1)/2 - 1;
            answer = s.substring(mid, mid+1);
        }else{
            mid = (length)/2 - 1;
            answer = s.substring(mid, mid+2);
        }
        
        return answer;
    }
}

