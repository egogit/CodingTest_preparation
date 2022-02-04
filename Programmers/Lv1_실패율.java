import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        HashMap<Integer, Double> ratio = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(stages);

        for(int i = 0; i < stages.length; i++){
            if(!map.containsKey(stages[i])){
                map.put(stages[i],1);
            }else{
                map.replace(stages[i],map.get(stages[i])+1);
            }
        }

        int total_people = (map.get(N+1)== null) ? 0 : map.get(N+1);

        for(int i = N; i > 0; i--){
            if(map.get(i)==null){
                ratio.put(i, 0.0);
            }else {
                total_people += map.get(i);
                ratio.put(i, (double) map.get(i) / total_people);
            }
        }
        LinkedList<Integer> keyList = new LinkedList<>(ratio.keySet());
        Collections.sort(keyList, (n1, n2) -> (ratio.get(n2).compareTo(ratio.get(n1))));
        int idx = 0;
        for(int i : keyList){
            answer[idx++] = i;
        }
        return answer;
    }
}

