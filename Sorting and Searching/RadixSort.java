// Problem link:
// https://www.geeksforgeeks.org/problems/radix-sort/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

import java.util.Arrays;

class RadixSort{
    static void radixSort(int arr[], int n){ 
        int max = Arrays.stream(arr).max().getAsInt();
        
        for(int exp = 1; max/exp > 0; exp *= 10){
            countSort(arr, n, exp);
        }
    }
    static void countSort(int[] arr, int n, int exp){
        int count[] = new int[10];
        int output[] = new int[n];
        
        for(int num : arr){
            count[(num / exp)%10]++;
        }
        
        for(int i=1; i<10; i++){
            count[i] += count[i-1];
        }
        
        for(int i=n-1; i>=0; i--){
            output[count[(arr[i] / exp)%10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        for(int i=0; i<n; i++){
            arr[i] = output[i];
        }
    }
}