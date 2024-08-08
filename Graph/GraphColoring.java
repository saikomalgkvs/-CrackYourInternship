public class GraphColoring {
    int[] color;
    public static void main(String[] args) {
        boolean[][] graph = {
            //        0      1      2      3
            /*0*/   {false, true,  true,  true},
            /*1*/   {true,  false, true,  false},
            /*2*/   {true,  true,  false, true},
            /*3*/   {true,  false, true,  false}
        };

        int n = graph.length; // number of nodes in graph
        int chromaticNumber = 3; // minimum colors required to color graph.
        GraphColoring obj = new GraphColoring();

        if(obj.graphColoring(graph, chromaticNumber, n)){
            System.out.println("Assigned colors are:");
            for(int i=0; i<n; i++){
                System.out.println("Node " + i + ": " + obj.color[i]);
            }
        }
        else System.out.print(chromaticNumber + " colors are not sufficient to color the given graph.");
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        color = new int[n];
        
        return canColor(graph, color, m, 0, n);
        
    }
    private boolean canColor(boolean[][] graph, int[] color, int m, int i, int n){
        if(n == i) return true;
        
        for(int c=1; c<=m; c++){
            if(isSafe(graph, i, c, color, n)){
                color[i] = c;
                if(canColor(graph, color, m, i+1, n)) return true;
                color[i] = 0;
            }
        }
        return false;
    }
    private boolean isSafe(boolean[][] graph, int i, int c, int[] color, int n){
        
        for(int v = 0; v < n; v++){
            if(graph[i][v] && c == color[v]) return false;
        }
        return true;
    }
}
