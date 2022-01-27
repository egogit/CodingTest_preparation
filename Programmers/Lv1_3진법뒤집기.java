import java.lang.StringBuffer;
class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        int digit = 0;
        
        while(n!=0){
            int rest = n%3;
            n /= 3;
            digit *= 3;
            digit += rest;
        }
        return digit;
    }
}

