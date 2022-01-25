class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gm=0;
        int lm=0;
        if(n>m){
            int tmp = n;
            n = m;
            m = tmp;
        }
        for(int i=n;i>=1;i--){
            if(n%i==0 && m%i==0){
                gm = i;
                break;
            }
        }
        lm = n * m / gm;
        answer[0]=gm;
        answer[1]=lm;
        return answer;
    }
}

