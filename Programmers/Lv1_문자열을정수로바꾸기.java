class Solution {
    public int solution(String s) {
        char[] array = s.toCharArray();
        int answer = 0;

        if(array[0] == '-'){
            answer = -1 * stringToInt(1, s);
        }else if(array[0] == '+'){
            answer = stringToInt(1, s);
        }else{
            answer = stringToInt(0,  s);
        }
        System.out.println(answer);
        
        return answer;
    }
    
    public int stringToInt(int startIdx, String s){
        int result = 0;
        for(int i=startIdx; i <s.length(); i++) {
            result *= 10;
            result += s.charAt(i) - '0';
        }
        return result;
    }
}

