class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] plain = s.toCharArray();
        for(int i=0;i<plain.length;i++){
            if(plain[i]!=' '){
                if(Character.isUpperCase(plain[i])){
                    plain[i] += n;
                    if(plain[i]>=91){
                        plain[i] -= 26;
                    }
                }else{
                    plain[i] += n;
                    if(plain[i]>=123){
                        plain[i] -= 26;
                    }
                }
            }
        }
        answer = String.valueOf(plain);
        return answer;
    }
}

