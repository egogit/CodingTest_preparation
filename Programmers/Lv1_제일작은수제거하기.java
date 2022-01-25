import java.util.LinkedList;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        LinkedList<Integer> array = new LinkedList<>();
        int min = arr[0];
        for(int i=1;i<arr.length;i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=min){
                array.add(arr[i]);
            }
        }
        if(array.size()==0){
            array.add(-1);
        }
        answer = array.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}

