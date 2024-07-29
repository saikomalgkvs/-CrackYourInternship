package Arrays;

import java.util.Arrays;

public class ReversePairs {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return count;
    }

    private void mergeSort(int[] nums, int i, int j){
        if(i<j){
            int mid = i + (j-i)/2;
            mergeSort(nums, i, mid);
            mergeSort(nums, mid+1, j);
            merge(nums, i, mid, j);
        }
    }
    private void merge(int[] arr, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

        Arrays.sort(L);
        Arrays.sort(R);

        // counting reverse pairs
        int i=0;
        int j=0;
        int c = 0;
        while(i<n1 && j<n2){
            long e = R[j];
            if(L[i] > 2*e){
                c += (n1-i);
                j++;
            }
            else i++;
        }
        count += c;
        c=0;

        i = 0;
        j = 0;
        int k = l;
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
