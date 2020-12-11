package DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFS_BFS_Graph {
	
	static HashMap<Character, ArrayList<Character>> adjList;
	
	public void DFS() {
		
		// Usually we should have inDegree of list with all 0s the idea is to add those in stack and start with them
		// in our case we will build one manually. 
		
		Stack<Character> stack = new Stack<Character>();
		
		stack.push('H');
		stack.push('G');
		stack.push('A');
		
		HashSet<Character> visitedSet = new HashSet<Character>();
		
		while(!stack.isEmpty()) {
			
			char c = stack.pop();
			
			if(!visitedSet.contains(c)) {
				
				visitedSet.add(c);
				System.out.print(c + " ");
			}
			
			ArrayList<Character> list = adjList.get(c);
			
			for(Character letter : list) {
				
				if(!visitedSet.contains(letter)) {
					stack.push(letter);
				}
				
			}
			
		}
		
	}
	
	
	public void BFS() {
		
		Queue<Character> q = new LinkedList<Character>();
		
		q.add('A');
		q.add('G');
		q.add('H');
		
		HashSet<Character> visitedSet = new HashSet<Character>();
		
		while(!q.isEmpty()) {
			
			char c = q.poll();
			
			if(!visitedSet.contains(c)) {
				
				visitedSet.add(c);
				System.out.print(c + " ");
			}
			
			ArrayList<Character> list = adjList.get(c);
			
			for(Character letter : list) {
				
				if(!visitedSet.contains(letter)) {
					q.add(letter);
				}
				
			}
			
		}
		
	}
	
	public void DFS_BFS_Graph() {
		
	}
	
	public static void main(String[] args) {
		
		DFS_BFS_Graph g = new DFS_BFS_Graph();
				
		adjList = new HashMap<Character, ArrayList<Character>>();
		
		adjList.put('A', new ArrayList<Character>(
		        List.of('B','C')));
		
		adjList.put('B', new ArrayList<Character>(
		        List.of('D','E')));
		
		adjList.put('C', new ArrayList<Character>(
		        List.of('F')));
		
		adjList.put('D', new ArrayList<Character>(
		        List.of('E')));
		
		adjList.put('E', new ArrayList<Character>(
		        List.of('F')));
		
		adjList.put('F', new ArrayList<Character>());
		
		adjList.put('G', new ArrayList<Character>(
		        List.of('F')));
		
		adjList.put('H', new ArrayList<Character>(
		        List.of('E')));
		
		
		g.DFS();
		
		System.out.println(" ");
		
		g.BFS();
	}

}
