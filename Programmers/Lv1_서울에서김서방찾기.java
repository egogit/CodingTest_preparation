import java.lang.StringBuffer;
class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<seoul.length;i++){
            if(seoul[i].equals("Kim")){
                sb.append("김서방은 ");
                sb.append(i);
                sb.append("에 있다");
                answer = sb.toString();
                break;
            }
        }
        return answer;
    }
}

