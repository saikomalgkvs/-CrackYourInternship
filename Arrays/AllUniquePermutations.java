package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class AllUniquePermutations {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        Set<ArrayList<Integer>> uniquePermsSet = new HashSet<>();
        
        permute(arr, 0, n, uniquePermsSet);
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(uniquePermsSet);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                    int cmp = Integer.compare(o1.get(i), o2.get(i));
                    if (cmp != 0) return cmp;
                }
                return Integer.compare(o1.size(), o2.size());
            }
        });

        return result;
    }

    private static void permute(ArrayList<Integer> arr, int index, int n, Set<ArrayList<Integer>> set) {
        if (index == n) {
            set.add(new ArrayList<>(arr));
            return;
        }

        for (int i = index; i < n; i++) {
            Collections.swap(arr, i, index); 
            permute(arr, index + 1, n, set); 
            Collections.swap(arr, i, index);
        }
    }
}
