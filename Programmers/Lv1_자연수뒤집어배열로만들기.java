import java.util.LinkedList;

class Solution {
    public int[] solution(long n) {
        LinkedList<Integer> digit = new LinkedList<>();
        int[] answer;
        while(n!=0){
            long rest = n % 10;
            n /= 10;
            digit.add((int) rest);
        }
        answer = digit.stream().mapToInt( i -> i ).toArray();
        return answer;
    }
}

