// Problem link
// https://leetcode.com/problems/gas-station/description/

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int n = gas.length;

        for(int i=0; i<n; i++){
            sum += gas[i] - cost[i];
        }
        if(sum < 0) return -1;

        int petrol = 0;
        int start = 0;

        for(int i=0; i<n; i++){
            petrol += gas[i] - cost[i];
            if(petrol < 0){
                petrol = 0;
                start = i+1;
            }
        }
        return start;
    }
}
