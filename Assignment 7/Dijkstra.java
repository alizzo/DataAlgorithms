//package Dijkstra;

/**   
 Alexander Lizzo 
 4/5/22    
 CMPT 435L  - Algorithms and Analysis 

    **/

import java.util.*;
import java.io.*;

public class Dijkstra {

	
	
	
	// Dijkstra's algorithm to find shortest path from source vertex s to all other nodes in a weighted graph G
		
	public static int[] dijkstra(WeightedGraph G, int s) {
		//d[], pred[] 
		int[] dist = new int[G.size()]; // dist[v]: the estimated shortest distance between the source vertex s and v

		int[] pred = new int[G.size()]; // pred[v]: the preceding node of v on the shortest path from s to v

		boolean[] ST = new boolean[G.size()]; 
		// ST[]: shortest path tree rooted at the source vertex s
		// ST[v] is true if v has been added to the shorest path tree rooted at s, false otherwise
		// The tree is empty initially, therefore all false initially


		//for all v in V-{s}
			//d[v] = infinity, pred[v] = -1
		//end for
		for (int i = 0; i < dist.length; i++) {
			//d[v]: estimated shortest distance from s to v
			dist[i] = Integer.MAX_VALUE; // set to infinity initially

			ST[i] = false; // explicity write false for all elements of ST

			//pred[v]: the preceding node of v on the shortest path from s to v 
			pred[i] = -1;
		}
		
		//d[s] = 0, pred[s] = s 
		dist[s] = 0; // the shortest distance between source vertex s and s itself must be 0
		pred[s] = s;


		/*		
		Complete the method here to find the shorest path from s to every other vertex in the graph
		Return the array pred[]
		Hint: Follow the pseudocode of Dijkstra's algorithm in the slides
		*/
		//https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/


			for (int count = 0; count < G.size(); count++) {

				//u <- d[u] is minimum, u in Q
				int u = minVertex(dist, ST);

				//ST <- ST U {u}, Q<- Q - {u}
				ST[u]  = true;


				//for all v that are memebers of Adj[u]
				for(int vertices = 0; vertices  < G.size(); vertices ++){
					//if d[v] > d[u] + w(u,v)
					  if (!ST[vertices] && G.isEdge(u,vertices) && dist[u] != Integer.MAX_VALUE && dist[u] + G.getWeight(u,vertices) < dist[vertices]){
					  	//Then d[v] <- d[u] + w(u,v), pred[v] = u
	                    dist[vertices] = dist[u] + G.getWeight(u,vertices);
	                    pred[vertices] = u;
	                }
				}			
		}

		return pred; // Return the preceding node array
	}

	private static int minVertex(int[] dist, boolean[] ST) {
		// find a vertex v that has NOT been added to the shortest path tree ST, and has the minimum estimated distance d[v]
		int min = Integer.MAX_VALUE;
		int v = -1; // graph not connected, or all vertices have been added to the shortest path tree
		
		for (int i = 0; i < dist.length; i++) {
			// examine nodes one by one
			if (!ST[i] && dist[i] < min) { 
				// vertex i has NOT been added to the shorest path tree yet, and has a smaller estimated distance to s
				min = dist[i];
				v = i;   //min index
			}
		}
		
		return v; 
	}

	public static void printPath(WeightedGraph G, int[] pred, int s, int e) {
		// print the shortest path from s to e
		ArrayList<Object> path = new ArrayList<>();
		//java.util.ArrayList path = new java.util.ArrayList();
		int x = e;
		while (x != s) {
			// read nodes on the path from s to e one by one backwards, starting from the destination vertex e
			path.add(0, G.getLabel(x));
			// add the node to the front of the path/list
			x = pred[x];
			// read its preceding node on the path
		}
		path.add(0, G.getLabel(s));
		// add the source vertex s to the front of the list/path
		System.out.println(path);
	}

}
