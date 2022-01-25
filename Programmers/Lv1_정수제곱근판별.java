class Solution {
    public long solution(long n) {
        long answer = 0;
        double sqrt = Math.sqrt(n);
        long real = (long) sqrt;
        if(real == sqrt){
            answer = (real+1)*(real+1);
        }else{
            answer = -1;
        }
        return answer;
    }
}

