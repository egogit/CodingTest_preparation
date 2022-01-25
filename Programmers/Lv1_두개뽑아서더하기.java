import java.util.TreeSet;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        TreeSet<Integer> result = new TreeSet<>();
        for(int i=0; i<numbers.length - 1; i++){
            for(int j=i+1; j <numbers.length;j++){
                result.add(numbers[i]+numbers[j]);
            }
        }
        answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}

