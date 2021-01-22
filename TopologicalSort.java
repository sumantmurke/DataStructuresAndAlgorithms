

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
	
	/*
	 * This is classic example of topological sort where you want to return if a course can be taken if there are
	 * set of prerequisite.
	 */
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        
        if(prerequisites.length == 0){
             return true;
        }
        /*
        for(int i = 0 ; i< prerequisites.length ; i++){
            
             counts.put(prerequisites[i][0], 0);
             counts.put(prerequisites[i][1], 0);
            
        }
        */
        for(int i = 0 ; i < numCourses ; i++){
            counts.put(i,0);
            map.put(i,new ArrayList<Integer>());
        }
        
        
        for(int i = 0 ; i< prerequisites.length ; i++){
            
            ArrayList<Integer> list = map.get(prerequisites[i][1]);
            list.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], list);
            counts.put(prerequisites[i][0], counts.get(prerequisites[i][0])+1);
    
        }
        
        
        Queue<Integer> q = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        for(int count : counts.keySet()){
            
            if(counts.get(count) == 0){
                
                q.add(count);
            }
            
        }
        
        int counter = 0;
        

        while(!q.isEmpty()){
            
            int vertex = q.poll();
            counter++;
            if(counter == numCourses){
                return true;
            }
            
            if(!map.containsKey(vertex)) return false;
            for(int edge : map.get(vertex)){
                counts.put(edge, counts.get(edge)-1);
                if(counts.get(edge) == 0 ){
                    //counts.put(edge, 0);
                    q.add(edge);
                }
            }
            
        } 
        
        
        return false;
    }
	 
	 public static void main(String[] args) {
		
		 TopologicalSort c = new TopologicalSort();
		 int[][] a = {{1,0}};
		 System.out.println(c.canFinish(2, a));
		 
	}

}
