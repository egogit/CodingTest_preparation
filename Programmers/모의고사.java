import java.util.LinkedList;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] supo1 = {1, 2, 3, 4, 5};
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] check = {0, 0, 0};
        LinkedList<Integer> result = new LinkedList<>();
        for(int i=0; i<answers.length; i++){
            if(answers[i]==supo1[i%5]){
                check[0]+=1;
            }
            if(answers[i]==supo2[i%8]){
                check[1]+=1;
            }
            if(answers[i]==supo3[i%10]){
                check[2]+=1;
            }
        }
        int max=0;
        for(int i=0;i<3;i++){
            if(max < check[i]){
                max = check[i];
            }
        }
        for(int i=0;i<3;i++){
            if(max==check[i]){
                result.add(i+1);
            }
        }
        answer = result.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}

