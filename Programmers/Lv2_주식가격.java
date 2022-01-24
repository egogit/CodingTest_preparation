import java.util.LinkedList;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        LinkedList<Integer> result = new LinkedList<>();
        for(int i=0; i<prices.length -1; i++){
            int time = 0;
            for(int j=i+1; j< prices.length; j++) {
                time++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            result.add(time);
        }
        result.add(0);
        answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}

