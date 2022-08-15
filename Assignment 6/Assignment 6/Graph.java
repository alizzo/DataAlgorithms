

import java.util.*;
import java.io.*;

public class Graph {

	private int[][] edges; // adjacency matrix
	private int n;
	//private int edge;

	public Graph(int n) {
		// n: size of nodes
		this.n = n;
		edges = new int[n][n];


		for(int row = 0; row < n; row++){
			Arrays.fill(edges[row], 0);
		}

	}
		
	

	public int size() {
		// size of nodes
		return edges.length;
	}


	public void addEdge(int source, int target, int w) {
		// w for weight
		// complete the method to add an edge from "source" node to "target" node, with weight "w"
		// for unweighted graphs, simply let w = 1 for all edges
		// for example, addEdge(0, 1, 5): add an edge from node 0 to node 1, with a weight of 5

        edges[source][target] = 1;
        //edges[target][source] = 1;

        if (w>1){
        	edges[source][target] = w;
        }	
	}

	public boolean isEdge(int source, int target) {
		// complete the method to return true if there exists an edge from node source to node target
		if ((edges[source][target] == 1) ){  
			return true;
		}else{
			return false;
		}	
	}

	public void removeEdge(int source, int target) {
		// complete the method to remove the edge from node source to node target'
		edges[source][target] = 0;
       
	}

	public int getWeight(int source, int target) {
		return edges[source][target];
	}

public int[] neighbors(int vertex) {
		// complete the method to return the neighboring nodes of a given node "vertex"
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);

        for(int row = 0; vertex < edges.length; vertex++){
			for(int column = 0; column < edges[vertex].length; column++){	
				    if (edges[vertex][column] != 0 && !visited[vertex]) {
	               		visited[vertex] = true;
	                	return new int[]{vertex};
         			}
				}
			}
		return null;
	}


	public int count_edges()
	{
		// complete the method to return the total number of edges in the graph
		return 0;
		

	}
	
	
		public void dfs(int source) {
		// complete this method to traverse a graph using DFS
		// start DFS from a given node "source" in the graph
		// output nodes visited by DFS one by one 
		// follow the pseudocode of DFS() in the lecture slides 
		// feel free to use the standard library queue, stack class for implementing the DFS, BFS
		//boolean[] visited = new boolean[n];
		//System.out.print(source + " ");
		
		//create a boolean area set to zero
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);

		// Create Integer type stack
		Stack<Integer> stacks = new Stack<>();
	
		// push vertex v onto stack S
		stacks.push(source);

		// Mark Visited
		//visited[source] = true;

		while (!stacks.isEmpty())
		{
			//peek at the top u of S 
			int u = stacks.peek();
			
			// if u has an unvisited neighbor w
			if ((!visited[u])){
				
				System.out.print(u);
				// Mark Visited
				visited[u] = true;
		
				//https://stackoverflow.com/questions/49370444/java-adjacency-matrix-and-dfs
	        for(int i = 0; i < edges.length; i++){
				if (edges[u][i] != 0 && !visited[i]) {
		               	visited[i] = true;
		               	stacks.push(i);
		               	u=i;
		               	System.out.print(i);
		                	
	         		}
				}           

			} else{
					stacks.pop();
					//System.out.print(u);
					for(int i = 0; i < edges.length; i++){
						if (edges[u][i] != 0 && !visited[i]) {
		               		visited[i] = true;
			               	stacks.push(i);
			               	u=i;
			               	System.out.print(i);
			                	
		         		}
					}   

				}
			}//end while
	}
	
	public void bfs(int source) {
		// complete this method to traverse a graph using BFS
		// start BFS from a given node "source" in the graph
		// output nodes visited by BFS one by one 
		// follow the pseudocode of BFS() in the lecture slides
		// feel free to use the standard library queue, stack class for implementing the DFS, BFS
		//implementation based on:		
		//https://www.geeksforgeeks.org/implementation-of-bfs-using-adjacency-matrix/
		// Visited vector to so that
		// a vertex is not visited more than once
		// Initializing the vector to false as no
		// vertex is visited at the beginning
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);

		//create a queue Q
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);

		//mark v as visited and put v into Q
		visited[source] = true;

		//while Q is non-empty
		int node;
		while (!queue.isEmpty())
		{
			node = queue.peek();

			// Print the current node
			System.out.print(node);
			//remove the head u of Q
			queue.remove(queue.peek());

			// For every adjacent vertex to
			// the current vertex
			for(int i = 0; i < n; i++)
			{
				if (edges[node][i] != 0 && (!visited[i]))
				{
					
					// Push the adjacent node to
					// the queue
					queue.add(i);

					// Set
					visited[i] = true;
				}
			}
		}
 
	
	}
	
	
	public boolean isConnected(int source)
	{
		// complete this method to return ture if the graph is connected
		// run BFS or DFS to determine if there is an edge between nodes

		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);

		//create a queue Q
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);

		//mark v as visited and put v into Q
		visited[source] = true;

		//while Q is non-empty
		int node;
		while (!queue.isEmpty())
		{
			node = queue.peek();

			// Print the current node
			//System.out.print(node);
			//remove the head u of Q
			queue.remove(queue.peek());

			// For every adjacent vertex to
			// the current vertex
			for(int i = 0; i < n; i++)
			{
				if (edges[node][i] == 1 && (!visited[i]))
				{
					
					// Push the adjacent node to
					// the queue
					queue.add(i);

					// Set
					visited[i] = true;
				}
			}
		}

	    for(boolean j : visited) if(!j) return false;
	    return true;
			
	}
	
	
	
	public void print() {
		// print the graph
		for (int j = 0; j < edges.length; j++) {
			for (int i = 0; i < edges[j].length; i++) {
				if (edges[j][i] > 0)
					System.out.print("node " + j + " --> node " + i + ": weight " + edges[j][i] + " \n");
			}
			System.out.println();
		}
	}
	

	

	public static void main(String args[]) {
	// Complete the main method to test the graph class
	// An example to create a graph using the Graph class
	
		/*
		final Graph t = new Graph(6);
		t.addEdge(0, 1, 1);
		t.addEdge(0, 5, 1);
		t.addEdge(1, 2, 100);
		t.addEdge(1, 3, 1);
		t.addEdge(1, 5, 1);
		t.addEdge(2, 3, 1);
		t.addEdge(4, 3, 1);
		t.addEdge(4, 2, 1);
		t.addEdge(5, 4, 1);
		t.print();

	
		t.dfs(0);
		System.out.println();

		t.bfs(0);
		System.out.println();

		System.out.println("This graph is connected: "+t.isConnected(0));
		System.out.println();
	*/
	/*
		Expected Output:
		 
		node 0 --> node 1: weight 1 
		node 0 --> node 5: weight 1 
		
		node 1 --> node 2: weight 1 
		node 1 --> node 3: weight 1 
		node 1 --> node 5: weight 1 
		
		node 2 --> node 3: weight 1 
		
		
		node 4 --> node 2: weight 1 
		node 4 --> node 3: weight 1 
		
		node 5 --> node 4: weight 1 
		
		0 1 2 3 5 4 dfs starting from vertex 0
		0 1 5 2 3 4 bfs starting from vertex 0
		
		This graph is connected: true.

	  
	*/
	System.out.println();
		System.out.println("Test2 ---------------------------------------");

		final GraphTest t1 = new Graph(8);
		t1.addEdge(0, 3, 1);
		t1.addEdge(0, 6, 1);
		t1.addEdge(0, 7, 1);

		t1.addEdge(2, 5, 1);

		t1.addEdge(3, 4, 1);

		t1.addEdge(4, 1, 1);


		t1.addEdge(7, 2, 1);
		t1.addEdge(7, 5, 1);
	//	t1.print();



		System.out.println(t1.size());
		System.out.println();

		t1.dfs(0);
	    System.out.println();

		//t.bfs(0);
		System.out.println();

		//System.out.println("This graph is connected: "+t1.isConnected(0));
		System.out.println();
		
	}

}
