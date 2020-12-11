package DataStructure;

import java.util.HashMap;
import java.util.HashSet;

public class Dijikstra {
	
	// Dijikstras algorithm :
	/*
	 * Total cost map : This will store minimum cost required to get to the node from source node.
	 * Previous Node map: This is to store info of node that was used to get to the node. For e.g if you want to reached point B from point C then map would be like B -> C.
	 * Visited node set : This is used to define nodes that we have visited.
	 * minPq : This is used for track the distance of that node from the start node.
	 * 
	 */
	
	class pair{
		int node;
		int distance;
		
		pair(int node, int distance){
			this.node = node;
			this.distance = distance;
		}
		
	}

	public void dijisktra_algorithm() {
		
		HashMap<Integer, Integer> totalCost = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> previousNode = new HashMap<Integer, Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		
	}
}
