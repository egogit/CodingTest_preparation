import java.util.regex.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Matcher m = Pattern.compile("[0-9]+[S,D,T][*,#]?").matcher(dartResult);
        int[] scoreList = new int[3];
        int chance=0;

        while(m.find()){
            char[] token = m.group().toCharArray();
            int score;
            char bonus;
            char option;

            if(token[1]=='0'){
                score = 10;
                bonus = token[2];
                option = (token.length==4) ? token[3] : 'x';
            }else{
                score = token[0] - '0';
                bonus = token[1];
                option = (token.length==3) ? token[2] : 'x';
            }

            switch (bonus) {
                case 'S':
                    scoreList[chance] = score;
                    break;
                case 'D':
                    scoreList[chance] = score * score;
                    break;
                case 'T':
                    scoreList[chance] = score * score * score;
                    break;
            }

            if(option!= 'x'){
                switch (option){
                    case '*':
                        if(chance != 0){
                            scoreList[chance-1] *= 2;
                        }
                        scoreList[chance] *= 2;
                        break;
                    case '#':
                        scoreList[chance] *= -1;
                }
            }
            chance++;
        }
        
        for(int i=0; i<3; i++) {
            answer += scoreList[i];
        }
        return answer;
    }
}

