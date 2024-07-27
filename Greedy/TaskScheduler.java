import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        int len = tasks.length;

        for(int i=0; i<len; i++) arr[tasks[i]-'A']++;

        Arrays.sort(arr);
        int max = arr[25];
        int idle = (max-1) * n;

        for(int i=24; i>=0; i--){
            idle -= Math.min(max-1, arr[i]);
        }
        return len + Math.max(0,idle);
    }
}
