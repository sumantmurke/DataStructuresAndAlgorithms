package DataStructureOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

 public class Dijkstra {

	/*
	 * Dijkstras algorithm :
	 * Total cost map : This will store minimum cost required to get to the node from source node.
	 * Previous Node map: This is to store info of node that was used to get to the node. For e.g if you want to reached point B from point C then map would be like B -> C.
	 * Visited node set : This is used to define nodes that we have visited.
	 * minPq : This is used for track the distance of that node from the start node.
	 * 
	 * 						2
	 * 					2	-----	4
	 *				3/ 
	 * 			1		|1 			|
	 * 				5\
	 * 					3	-----	5
	 */

		
	 class Pair{
		 int node;
		 int distance;
			
		 Pair(int node, int distance){
			 this.node = node;
			 this.distance = distance;
		 }			
	 }

	public HashMap<Integer, Integer> dijkstra_algorithm(HashMap<Integer,ArrayList<Pair>> graph) {
		
		
		
		HashMap<Integer, Integer> totalCost = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> previousNode = new HashMap<Integer, Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		PriorityQueue<Pair> minPq = new PriorityQueue<Pair>((a,b) -> {
			return a.distance - b.distance;
		});
		
		
		
		// our starting point will be 1.
		
		// we will setup our totalCost map 
		for(int node : graph.keySet() ) {
			
			totalCost.put(node, Integer.MAX_VALUE);
			
		}
		
				
		// As 1 is our starting point we will add min distance from 1 to 1 is 0.
		totalCost.put(1, 0);
		
		// add our entry to queue
		minPq.add(new Pair(1,0));
		
		// 1 will start from 1
		previousNode.put(1, 1);
		
		// Actual dijkstra work that will traverse the graph;		
		while(!minPq.isEmpty()) {
			
			Pair nodeFromQ = minPq.poll();
			
			visited.add(nodeFromQ.node);
			
			for(Pair neighbourNodes : graph.get(nodeFromQ.node)) {
				
				if(!visited.contains(neighbourNodes.node)) {
					
					
					int currenPathToNode = totalCost.get(neighbourNodes.node);
					
					int newDistance = getLatestDistance( nodeFromQ.node, neighbourNodes.node, graph, totalCost);
					
							
					if(currenPathToNode > newDistance) {
						
						neighbourNodes.distance = newDistance;
						
						minPq.add(neighbourNodes);
						totalCost.put(neighbourNodes.node, neighbourNodes.distance);
						previousNode.put(neighbourNodes.node, nodeFromQ.node);
						
					}
		
				}
				
				
				
			}
			
			
		}
		

		// return the map
		return totalCost; 
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
	
	public HashMap<Integer,ArrayList<Pair>> buildGraph() {
		HashMap<Integer,ArrayList<Pair>> adjList = new HashMap<Integer,ArrayList<Pair>>();
		
		for(int i = 1 ; i < 6 ; i++) {
			adjList.put(i, new ArrayList<Pair>());
		}
		
		// 1
		//Pair p12 = new Pair(2,3);
		//Pair p13 = new Pair(3,5);
		ArrayList<Pair> one = adjList.get(1);
		List<Pair> oneList = Arrays.asList( new Pair(2,3), new Pair(3,5));
		one.addAll(oneList);
		
		// 2
		//Pair p21 = new Pair(1,3);
		//Pair p23 = new Pair(3,1);
		//Pair p24 = new Pair(4,2);
		ArrayList<Pair> two = adjList.get(2);
		List<Pair> twoList = Arrays.asList( new Pair(1,3), new Pair(3,1),new Pair(4,2));
		two.addAll(twoList);
		
		// 3
		//Pair p31 = new Pair(1,5);
		//Pair p32 = new Pair(2,1);
		//Pair p34 = new Pair(4,3);
		//Pair p35 = new Pair(5,6);
		ArrayList<Pair> three = adjList.get(3);
		List<Pair> threeList = Arrays.asList( new Pair(1,5), new Pair(2,1),new Pair(4,3),new Pair(5,6));
		three.addAll(threeList);
		
		// 4
		//Pair p42 = new Pair(2,2);
		//Pair p43 = new Pair(3,3);
		//Pair p45 = new Pair(5,4);
		ArrayList<Pair> four = adjList.get(4);
		List<Pair> fourList = Arrays.asList( new Pair(2,2), new Pair(3,3),new Pair(5,4));
		four.addAll(fourList);
		
		//5
		//Pair p54 = new Pair(4,4);
		//Pair p53 = new Pair(3,6);
		ArrayList<Pair> five = adjList.get(5);
		List<Pair> fiveList = Arrays.asList( new Pair(4,4), new Pair(3,6));
		five.addAll(fiveList);
		
		
		return adjList;
	}
	
	
	
	
	public static void main(String[] args) {
		
		Dijkstra d = new Dijkstra();
		//d.buildGraph();
		HashMap<Integer, Integer>map =  d.dijkstra_algorithm(d.buildGraph());
		
		for(int key : map.keySet()) {
			
			System.out.println(key +": "+map.get(key) );;
		}
		
	}
}
 
 
