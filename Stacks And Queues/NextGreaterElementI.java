public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] arr = new int[n1];

        for(int i=0; i<n1; i++){
            int j=0;
            boolean breaked = false;
            for( ; j<n2; j++){
                if(nums1[i] == nums2[j]){
                    j++;
                    for( ; j<n2; j++){
                        int e = nums2[j];
                        if(e > nums1[i]){
                            arr[i] = e;
                            breaked = true;
                            break;
                        }
                    }
                    if(!breaked) arr[i] = -1;
                }
                if(breaked) break;
            }
        }
        return arr;
    }    
}
