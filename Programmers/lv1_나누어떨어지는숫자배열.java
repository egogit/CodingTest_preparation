import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        LinkedList<Integer> result = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0){
                result.add(arr[i]);
            }
        }
        if(result.size()==0){
            result.add(-1);
        }
        Collections.sort(result);
        answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}

