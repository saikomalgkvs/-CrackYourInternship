package Arrays;

import java.util.Arrays;

class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];

        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                i++;
            }
            else{
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<m){
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while(j<n){
            arr[k] = nums2[j];
            j++;
            k++;
        }
        i=0;

        for(int ele : arr){
            nums1[i] = ele;
            i++;
        }
        
    }
    public static void main(String[] args) {
        int[] b = {2,5,6};
        int n = b.length;

        int[] a = {1,2,3,0,0,0};
        int m = a.length -n;

        merge(a, m, b, n);
        
        System.out.println(Arrays.toString(a));
    }
}
