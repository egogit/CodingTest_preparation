import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<Integer> queue = new LinkedList<>();
        int size = priorities.length;
        int answer;
        
        for(int i : priorities){  // Queue에 삽입
            queue.add(i);
        }
        
        while(size!=0){
            int idx = findMaxIndex(queue); // 중요도가 큰 작업의 index 찾기
            for(int i=0; i<idx; i++){  // 중요도가 큰 작업으로 이동
                int element = queue.remove();
                queue.add(element);
                location--;
                if(location < 0){
                    location += size;
                }
            }
            queue.remove();  
            size--;
            if(location==0){
                break;
            }
            location--;
        }
        answer = priorities.length - size;
        return answer;
    }
    
    public int findMaxIndex(LinkedList<Integer> list){
        int max = -1;
        int maxidx = -1;
        int idx = 0;
        for(int i : list){
            if( i > max){
                max = i;
                maxidx = idx;
            }
            idx++;
        }
        return maxidx;
    }
}

