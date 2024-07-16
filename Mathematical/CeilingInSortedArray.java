package Mathematical;

public class CeilingInSortedArray {
    public int ceiling(int[] arr, int x){
        int ceil = -1;

        for(int i : arr){
            if(i > x){
                ceil = i;
                break;
            }
        }
        return ceil;
    }
    public static void main(String[] args) {
        CeilingInSortedArray obj = new CeilingInSortedArray();
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int ans = obj.ceiling(arr, 20);
        if(ans==-1) System.out.println("ceil doesn't exist in array");
        else System.out.println(ans);
    }
}
