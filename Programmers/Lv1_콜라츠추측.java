class Solution {
    public int solution(int num) {
        int answer = 0;
        long tmp = num;
        while(tmp != 1){
            tmp = (tmp%2==0) ? tmp/2 : tmp*3 + 1;
            answer++;
            if(answer > 500){
                answer = -1;
                break;
            }
        }
        return answer;
    }
}

