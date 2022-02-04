import java.util.LinkedList;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length-2;i++){
            for(int j=i+1; j <nums.length-1;j++){
                for(int k=j+1; k<nums.length;k++){
                    int num = nums[i] + nums[j] + nums[k];
                    if(isPrime(num)){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    
    public boolean isPrime(int num){
        boolean check = true;
        for(int i=2; i<num/2; i++){
            if(num%i==0){
                check = false;
                break;
            }
        }
        return check;
    }
}

