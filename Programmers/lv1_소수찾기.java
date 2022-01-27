class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] array = new boolean[n+1];
        for(int i=2; i<=n; i++){
            if(!array[i]){
                answer++;
                for(int j=2; i*j<=n; j++){
                    array[i*j] = true;
                }
            }
        }
        return answer;
    }
}

