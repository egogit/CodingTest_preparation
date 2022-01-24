import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int passedVehicleCount = 0;
        int nextVehicleIndex = 0;
        int totalWeight = 0;

        LinkedList<Integer> bridge = new LinkedList<>();
        for(int i=0;i<bridge_length;i++){
            bridge.add(0);
        }

        while(passedVehicleCount!=truck_weights.length){
            answer++;
            int vehicleOut = bridge.remove();
            if(vehicleOut != 0) {
                totalWeight -= vehicleOut;
                passedVehicleCount++;
            }
            if(nextVehicleIndex < truck_weights.length && weight >= totalWeight + truck_weights[nextVehicleIndex]){
                totalWeight += truck_weights[nextVehicleIndex];
                bridge.add(truck_weights[nextVehicleIndex]);
                nextVehicleIndex++;
            }else{
                bridge.add(0);
            }
        }
        
        return answer;
    }
}


