import java.util.Arrays;

public class PermutateTwoArrays {
    public static boolean sort(int[] a, int[] b, int k){
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0, j=b.length-1; i<j; i++,j--){
            int temp = b[i];
            b[i] = b[j];
            b[j] = temp;
        }
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));

        for(int i=0; i<a.length; i++){
            if(a[i]+b[i]<k) return false;
        }
        return true;
        
    }
    public static void main(String[] args) {
        int[] a = {1,5,3,7,4};
        int[] b = {1,5,3,7,4};
        
        if(sort(a, b, 10)) System.out.println("YES");
        else System.out.println("NO");
        
    }
}
