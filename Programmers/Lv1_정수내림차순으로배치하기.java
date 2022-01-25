import java.util.Collections;
import java.util.LinkedList;

class Solution {
    public long solution(long n) {
        long answer = 0;
        LinkedList<Integer> array = new LinkedList<>();
        while(n!=0){
            long rest = n % 10;
            n /= 10;
            array.add((int) rest);
        }
        Collections.sort(array, Collections.reverseOrder());
        for(int i : array){
            answer *= 10;
            answer += i;
        }
        return answer;
    }
}

