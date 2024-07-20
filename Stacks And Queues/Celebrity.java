public class Celebrity {
    int celebrity(int M[][], int n){
        int m = M.length;
        
        int candidate=0;
    	for(int i=0; i<m; i++){
    	    if(M[candidate][i] == 1) candidate = i;
    	}
    	
    	for(int i=0; i<m; i++){
    	    if(i!=candidate && (M[candidate][i] == 1 || M[i][candidate] == 0)){
    	        return -1;
    	    }
    	}
    	return candidate;
    }    
}
