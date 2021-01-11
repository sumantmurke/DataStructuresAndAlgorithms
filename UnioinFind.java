

import java.util.Arrays;

public class UnioinFind {
	
	/*
	 * 
	 * This implementation is basic union find which prints the number of disjoint sets
	 */

	public static void union(int[] parent, int x, int y) {
		
		int parentX = find(parent, x);
		int parentY = find(parent, y);
		
		if(parentX != parentY) {
			parent[parentX] = parentY;
		}
		
	}
	
	public static int find(int[] parent,  int i) {
		
		if(parent[i] == -1) {
			return i;
		}
		
		return find(parent, parent[i]);
	}
	
	
	
	public static void main(String[] args) {
		int[][] graphMatrix = {{1,1,0},{1,1,0},{0,0,1}};
		
		 int[] parent = new int[graphMatrix.length];
	        
	     Arrays.fill(parent, -1);
		
		for(int i = 0 ; i < graphMatrix.length; i++){
            for(int j = 0 ; j < graphMatrix[0].length; j++){
                
                if(i!=j && graphMatrix[i][j] == 1){
                    union(parent,i,j);
                }
                
            }
        }
        
        int count = 0;
        
        for(int i = 0 ; i < parent.length; i++){
            if(parent[i] ==-1){
                count++;
            }
        }
        
        System.out.println(count);
	}
}
