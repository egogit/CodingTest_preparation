import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pickCount = nums.length/2;
        int[] pokemon = Arrays.stream(nums).distinct().toArray();
        int variety = pokemon.length;
        if(variety > pickCount){
            answer = pickCount;
        }else{
            answer = variety;
        }
        return answer;
    }
}

