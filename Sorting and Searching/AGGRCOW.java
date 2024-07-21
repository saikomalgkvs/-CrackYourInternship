import java.util.*;

public class AGGRCOW {
    List<List<Integer>> subsets;
    
    AGGRCOW(){
        subsets = new ArrayList<>();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no.of test cases: ");
        int t = sc.nextInt();

        AGGRCOW obj = new AGGRCOW();
        for(int i=0; i<t; i++){
            System.out.print("Enter no.of sheds: ");
            int N = sc.nextInt();
            
            System.out.print("Enter no.of cows: ");
            int C = sc.nextInt();
            
            int[] arr = new int[N];
            System.out.print("Enter sheds numbers seperated by space: ");
            for(int j=0; j<N; j++){
                arr[j] = sc.nextInt();
            }
            obj.minimumDistance(arr, N, C, 0, new Stack<>());
            int maxdiff = 0;
            for(List<Integer> sub : obj.subsets){
                int diff = Integer.MAX_VALUE;
                for(int j=0; j<sub.size()-1; j++){
                    diff = Math.min(diff, sub.get(j+1) - sub.get(j));
                }
                maxdiff = Math.max(maxdiff, diff);
            }
            System.out.println("Largest Minimum distance of cows for case " + i+1 + " is: " + maxdiff);
        }
    }

    private void minimumDistance(int[] arr, int n, int c, int i, Stack<Integer> sub) {
        if(sub.size() == c){
            Collections.sort(sub);
            subsets.add(new ArrayList<Integer>(sub));
            return;
        }
        for(int idx=i; idx<n; idx++){
            sub.push(arr[idx]);
            minimumDistance(arr, n, c, idx+1, sub);
            sub.pop();
        }
    }
}
