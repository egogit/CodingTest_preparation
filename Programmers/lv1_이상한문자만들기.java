class Solution {
    public String solution(String s) {
        String answer = "";
        char[] array = s.toLowerCase().toCharArray();
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(array[i]!=' '){
                if(cnt%2==0){
                    array[i] = (char) (array[i] - 32);
                }
                cnt++;
            }else{
                cnt = 0;
            }
        }
        answer = String.valueOf(array);
        return answer;
    }
}

