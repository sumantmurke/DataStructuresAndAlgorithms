

import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_Matrix {

	
	public void BFS_Matrix(int[][] matrix) {
		
		Queue<String> q = new LinkedList<String>();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		
		q.offer(0+","+0);
		
		System.out.println("Breadth first search starting");
		
		while(!q.isEmpty()) {
			
			String[] temp =  q.poll().split(",");
			
			int row = Integer.parseInt(temp[0]);
			int col = Integer.parseInt(temp[1]);
			
			if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || visited[row][col] == true) {
				continue;
			}
			
			visited[row][col] = true;
			System.out.println(matrix[row][col]);
			
			q.add((row+1) +","+col);
			q.add((row-1) +","+col);
			q.add(row +","+ (col+1));
			q.add(row +","+ (col-1));
			
			
		}
		
	}
	
	public void DFS_Matrix(int[][] matrix) {
		
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		
		System.out.println("Depth first search starting");
		DFS_MatrixHelper(matrix, 0,0,visited);
		
	}
	
	
	public void DFS_MatrixHelper(int[][] matrix, int row, int col, boolean[][] visited) {
		
		if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || visited[row][col] == true) {
			return;
		}
		
		visited[row][col] = true;
		System.out.println(matrix[row][col]);
		
		DFS_MatrixHelper(matrix, row+1, col, visited);
		DFS_MatrixHelper(matrix, row-1, col, visited);
		DFS_MatrixHelper(matrix, row, col+1, visited);
		DFS_MatrixHelper(matrix, row, col-1, visited);
		
	}
	
	public static void main(String[] args) {
		int [][] grid = new int[][] {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
		};
		
    	BFS_DFS_Matrix d = new BFS_DFS_Matrix();
    	d.BFS_Matrix(grid);
    	d.DFS_Matrix(grid);
	}
	
}
