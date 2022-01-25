class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long nextPrice = price;
        long totalPrice = 0;
        for(int i=0;i<count;i++){
            totalPrice += nextPrice;
            nextPrice += price;
        }
        answer = totalPrice - money;
        if(answer <= 0){
            answer = 0;
        }
        return answer;
    }
}

