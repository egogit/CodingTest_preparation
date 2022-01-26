import java.util.Collections;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        LinkedList<Integer> tmp = new LinkedList<>();
        for(int i=0;i<commands.length;i++){
            LinkedList<Integer> token = new LinkedList<>();
            for(int k=commands[i][0]-1 ;k<=commands[i][1]-1 ;k++){
                token.add(array[k]);
            }
            Collections.sort(token);
            tmp.add(token.get(commands[i][2]-1));
        }
        answer = tmp.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}

