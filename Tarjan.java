

import java.util.*;

public class Tarjan {
	
	 /*
	 * 
	 * in this example we are considering 6 nodes from 0 -5;
	 * 
	 */
	static int n = 6;
	static HashMap<Integer, ArrayList<Integer>> adjList;
	static int time = 0;
	
	public static List<List<Integer>> criticalPath(HashMap<Integer, ArrayList<Integer>> graph) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		int[] low = new int[n];
		int[] timeAtVisited = new int[n];
		
		// time is used for maintain at what time did we visit the node and also for visited 
		
		Arrays.fill(timeAtVisited, -1);
		
		for (int i=0;i<n;i++) {
            if (timeAtVisited[i] == -1) {
            	dfs(0, low, timeAtVisited, graph, result, 0);
            }
        }
		
		
		
		
		
		return result;
	}
	
	public static void dfs(int currentNode, int[] low, int[] timeAtVisited, HashMap<Integer, ArrayList<Integer>> graph, List<List<Integer>> result, int pre) {
		 
		timeAtVisited[currentNode] = time;
		low[currentNode] = time;
		time++;
		
		ArrayList<Integer> list = graph.get(currentNode);
		
		for(int newNode : list) {
			
			if (newNode == pre) {
				continue; // if parent vertex, ignore
			}
			
			if(timeAtVisited[newNode] == -1) {
				
				
				
				dfs(newNode, low, timeAtVisited, graph, result, currentNode);
				
				low[currentNode] = Math.min(low[newNode], low[currentNode]);
				
				if(low[newNode] > timeAtVisited[currentNode]) {
					result.add(new ArrayList<Integer>(List.of(currentNode,newNode)));
				}
				
				
			}else {
				low[currentNode] = Math.min(timeAtVisited[currentNode], low[newNode]);
			}
			
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		adjList= new HashMap<Integer, ArrayList<Integer>>();
		
		adjList.put(0, new ArrayList<Integer>(
		        List.of(1,2)));
		adjList.put(1, new ArrayList<Integer>(
		        List.of(0,2)));
		adjList.put(2, new ArrayList<Integer>(
		        List.of(1,0,3)));
		adjList.put(3, new ArrayList<Integer>(
		        List.of(4,5,2)));
		adjList.put(4, new ArrayList<Integer>(
		        List.of(3,5)));
		adjList.put(5, new ArrayList<Integer>(
		        List.of(4,3)));
		
		
		List<List<Integer>>  result = Tarjan.criticalPath(adjList);
		
		for(List<Integer> li : result) {
			System.out.println(li.get(0) +" -> "+ li.get(1));
			
		}
		
		
	}

}
