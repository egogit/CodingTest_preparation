import java.util.LinkedList;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        LinkedList<Integer> result = new LinkedList<>();
        int currentElement = arr[0];
        for(int i=1;i<arr.length;i++){
            if(currentElement != arr[i]){
                result.add(currentElement);
                currentElement = arr[i];
            }
            if(i == arr.length -1){
                result.add(currentElement);
            }
        }
        answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}

