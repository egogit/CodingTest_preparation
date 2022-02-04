import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] alpha = s.toCharArray();
        Arrays.sort(alpha);
        answer = new StringBuilder(new String(alpha)).reverse().toString();
        return answer;
    }
}

