// Problem link: https://www.geeksforgeeks.org/problems/total-number-of-spanning-trees-in-a-graph/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

import java.util.ArrayList;
import java.util.List;

public class TotalNumberOfSpanningTrees {
    public static int countSpanningTrees(int[][] graph,int n,int m) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
            for(int j=0; j<n; j++){
                adj.get(i).add(0);
            }
        }
        
        for(int i=0; i<m; i++){
            adj.get(graph[i][0]).set(graph[i][1],1);
            adj.get(graph[i][1]).set(graph[i][0],1);
        }
        
        List<Integer> degree = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			degree.add(0);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (adj.get(i).get(j) == 1) degree.set(i, degree.get(i) + 1);
			}
		}
		
		for (int i = 0; i < n; i++) {
			adj.get(i).set(i, degree.get(i));
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i != j) && adj.get(i).get(j) == 1) adj.get(i).set(j, -1);
			}
		}

		List<List<Integer>> submatrix = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			submatrix.add(new ArrayList<Integer>());
			for (int j = 0; j < n - 1; j++) {
				submatrix.get(i).add(adj.get(i + 1).get(j + 1));
			}
		}

		return calcDet(submatrix);
	}
	private static int calcDet(List<List<Integer>> matrix) {
		
		int det = 0;
		
		if (matrix.size() == 1) return matrix.get(0).get(0);
		else if (matrix.size() == 2) {
			det = (matrix.get(0).get(0) * matrix.get(1).get(1) - matrix.get(0).get(1) * matrix.get(1).get(0));
			return det;
		}
		else {
			for (int p = 0; p < matrix.get(0).size(); p++) {
				List<List<Integer>> temp = new ArrayList<>();
				
				for (int i = 1; i < matrix.size(); i++) {
					ArrayList<Integer> row = new ArrayList<Integer>();
					
					for (int j = 0; j < matrix.get(i).size(); j++) {
						if (j != p) row.add(matrix.get(i).get(j));
					}

					if (row.size() > 0) temp.add(row);
				}

				det = det + matrix.get(0).get(p) * (int) Math.pow(-1, p) * calcDet(temp);
			}
			return det;
		}
	}    
}
