import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] answer;
        int idx = 0;
        int capacity = progresses.length;
        while(idx != capacity){
            int cnt = 0;
            for(int i=idx; i< capacity; i++){
                progresses[i] += speeds[i];
            }
            while(idx!=capacity && progresses[idx]>=100){
                idx++;
                cnt++;
            }
            if(cnt!=0){
                result.add(cnt);
            }
        }
        answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}

