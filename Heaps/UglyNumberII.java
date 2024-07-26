package Heaps;

import java.util.Arrays;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;

        int[] list = new int[n];

        list[0] = 1;

        for(int i=1; i<n; i++){
            int a = list[i1] * 2;
            int b = list[i2] * 3;
            int c = list[i3] * 5;

            int next = Math.min(a,b);
            next = Math.min(next, c);
            list[i] = next;

            if(next == a) i1++;
            if(next == b) i2++;
            if(next == c) i3++;
        }
        System.out.println(Arrays.toString(list));
        return list[n-1];
    }
}
