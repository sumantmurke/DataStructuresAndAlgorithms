

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Bellman_Ford {
	
	class Pair{
		 int node;
		 int distance;
			
		 Pair(int node, int distance){
			 this.node = node;
			 this.distance = distance;
		 }			
	 }
	
	class Edges{
		 int vertex1;
		 int vertex2;
			
		 Edges(int vertex1, int vertex2){
			 this.vertex1 = vertex1;
			 this.vertex2 = vertex2;
		 }			
	 }
	
	public HashMap<Integer, Integer> bellman_Ford_algorithm(HashMap<Integer,ArrayList<Pair>> graph, int src) {
		
		HashSet<Edges> set = new HashSet<Edges>();
		List<Edges> listOfEdges = new ArrayList<Edges>();
		HashMap<Integer, Integer> totalCost = new HashMap<Integer,Integer>();
		
		// this just to create list of all edges
		listOfEdges.add(new Edges(1,2));
		listOfEdges.add(new Edges(1,3));
		listOfEdges.add(new Edges(2,3));
		listOfEdges.add(new Edges(2,4));
		listOfEdges.add(new Edges(3,4));
		listOfEdges.add(new Edges(3,5));
		listOfEdges.add(new Edges(4,5));
		
		
		// setting up total cost to max
		for(int key : graph.keySet()) {
			
			totalCost.put(key, Integer.MAX_VALUE);
			
		}
		
		totalCost.put(src, 0);
		
		
		// usually we will be relaxing this for n-1 times which max number of edges
		int n = graph.keySet().size();
		int index = 1;
		while(index < n) {
			
			for(int i = 0 ; i < listOfEdges.size(); i++) {
				
				Edges e = listOfEdges.get(i);
				int currentCost = totalCost.get(e.vertex2);
				int newCost = getLatestDistance(e.vertex1,e.vertex2,graph,totalCost);
				
				if(currentCost > newCost) {
					totalCost.put(e.vertex2, newCost);
					
				}
			}
			
			index++;
		    
		}
		
		
		return totalCost;
		
	}
	
	public HashMap<Integer,ArrayList<Pair>> buildGraph() {
		HashMap<Integer,ArrayList<Pair>> adjList = new HashMap<Integer,ArrayList<Pair>>();
		
		for(int i = 1 ; i < 6 ; i++) {
			adjList.put(i, new ArrayList<Pair>());
		}
		
		ArrayList<Pair> one = adjList.get(1);
		List<Pair> oneList = Arrays.asList( new Pair(2,3), new Pair(3,5));
		one.addAll(oneList);
		
		ArrayList<Pair> two = adjList.get(2);
		List<Pair> twoList = Arrays.asList( new Pair(3,1),new Pair(4,2));
		two.addAll(twoList);
		
		ArrayList<Pair> three = adjList.get(3);
		List<Pair> threeList = Arrays.asList(new Pair(4,3),new Pair(5,6));
		three.addAll(threeList);
		
		ArrayList<Pair> four = adjList.get(4);
		List<Pair> fourList = Arrays.asList(new Pair(5,4));
		four.addAll(fourList);
		
		ArrayList<Pair> five = adjList.get(5);
		List<Pair> fiveList = Arrays.asList( );
		five.addAll(fiveList);

		return adjList;
	}
	
	
	public int getLatestDistance(int source, int destination, HashMap<Integer,ArrayList<Pair>>  graph, HashMap<Integer, Integer> totalCost) {
		
		ArrayList<Pair> list = graph.get(source);
		
		int distance = 0;
		
		for(Pair nodes : list) {
			
			if(nodes.node == destination) {
				distance = nodes.distance;
			}
		}
		
		return totalCost.get(source)+distance;
	}

	
	public static void main(String[] args) {
		Bellman_Ford  bf = new Bellman_Ford();
		HashMap<Integer, Integer>map =  bf.bellman_Ford_algorithm(bf.buildGraph(),1);
		
		for(int key : map.keySet()) {
			System.out.println(key +": "+map.get(key) );;
		}
	}
}
