class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i <= right; i++){
            int divisorCount = 0;
            for(int divisor=1; divisor<= i/2; divisor++){
                if(i%divisor==0){
                    divisorCount++;
                }
            }
            divisorCount++;
            if(divisorCount%2==0){
                answer += i;
            }else{
                answer -= i;
            }
        }
        return answer;
    }
}

