import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n!=0){
            int rest = n%10;
            n /= 10;
            answer += rest;
        }

        return answer;
    }
}

