import java.util.LinkedList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for(int i=0;i<moves.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[j][moves[i]-1]!=0){
                    int item = board[j][moves[i]-1];
                    board[j][moves[i]-1]=0;
                    if(stack.getLast()== item){
                        stack.removeLast();
                        answer += 2;
                    }else{
                        stack.add(item);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}

