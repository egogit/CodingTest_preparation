class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int digitSum = 0;
        int tmp = x;
        while(tmp!=0){
            int rest = tmp % 10;
            tmp /= 10;
            digitSum += rest;
        }
        if( x%digitSum!=0){
            answer = false;
        }
        return answer;
    }
}

