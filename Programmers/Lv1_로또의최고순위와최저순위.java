class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int unknown = 0;
        int winCount = 0;
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0){
                unknown +=1;
            }else{
                for(int j=0;j< win_nums.length;j++){
                    if(lottos[i]==win_nums[j]){
                        winCount++;
                        break;
                    }
                }
            }
        }
        answer[0] = 7 - (winCount + unknown) > 5 ? 6 : 7 - (winCount + unknown);
        answer[1] = 7 - winCount > 5 ? 6 : 7 - winCount;
        
        return answer;
    }
}

