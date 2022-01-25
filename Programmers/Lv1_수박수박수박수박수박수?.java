import java.lang.StringBuffer;
class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        int div = n/2;
        
        for(int i=0;i<div;i++){
            sb.append("수박");
        }
        if(n%2==1){
            sb.append("수");
        }
        answer = sb.toString();
        return answer;
    }
}

