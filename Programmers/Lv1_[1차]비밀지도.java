import java.lang.StringBuffer;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i < n; i++){
            String result = drawWall(n, arr1[i], arr2[i]);
            answer[i] = result;
        }
        return answer;
    }
    public String drawWall(int length, int map1, int map2){
        StringBuffer wall = new StringBuffer();
        String result;
        for(int i=0; i<length; i++){
            int bin1 = map1 % 2;
            int bin2 = map2 % 2;
            map1 /= 2;
            map2 /= 2;
            if(bin1+bin2 != 0){
                wall.append("#");
            }else{
                wall.append(" ");
            }
        }
        wall.reverse();
        result = wall.toString();
        return result;
    }
    
}

