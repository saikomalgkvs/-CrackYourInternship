import java.util.Arrays;

public class SmallestPositiveMissing {
    static int missingNumber(int arr[], int size)
    {
        if(size == 1){
            if(arr[0] != 1) return 1;
            else return 2;
        }
        Arrays.sort(arr);
        if(arr[0] > 0 && arr[0]!=1) return 1;
        for(int i=0; i<size-1; i++){
            if(arr[i] < 0 && arr[i+1] < 0) continue;
            else{
                if(arr[i] < 0){
                    if(arr[i+1] == 0 || arr[i+1] ==1) continue;
                    else return 1;
                }
                else{
                    if(arr[i+1] - arr[i] > 1) return arr[i]+1;
                }
            }
        }
        return (arr[size-1]<0) ? 1 : arr[size-1]+1;
    }
}
