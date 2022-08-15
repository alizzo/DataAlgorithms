/**   
 Alexander Lizzo 
 4/30/22    
 CMPT 435L  - Algorithms and Analysis 

    **/

import java.util.*;
public class GreedyMerge {
	
	
	public static int merge(int lists[])
	{
		// Complete code here to minimize the cost of merging lists in lists[]
		// Input: Assume lists in lists[] are sorted already
		// lists[i] represents the size of list i
		// The cost of merging list i and list j is: lists[i] + lists[j]
		// The resulting list size = lists[i] + lists[j]
		// Output: the minimum cost of merging all lists in lists[]

		//initialize two arrays lists (easier than working in an int array)
		// uses more memory, but the convenience is worth it
		ArrayList<Integer> arr = new ArrayList<Integer>();  
		ArrayList<Integer> mergedCost = new ArrayList<Integer>();

		//copy the int array to the array list
		for(int l =0; l<lists.length; l++){
			arr.add(lists[l]);
		}
	
		//size is a representation of the size of a file stored as an element in an array
		int size = 0;

		//i wanted to do this in a priority queue, but had more control with the array list.

		// so long as the are more than 2 elements...
		while(arr.size() >= 2){

			// basically, sum the lowest two element listed in ascending order
			size = arr.get(0) + arr.get(1);
			//then remove the elements from the array list
			arr.remove(0);
			arr.remove(0);
			//add back the sum combined file size (s1+s2)
			arr.add(size);

			//then sort the arrary list 
			Collections.sort(arr);
			//... then do it all over again...

			//add the costs of each merger to a seperate array
			mergedCost.add(size);

		}

		//the combined total cost of the merged cost array is the total optimal cost 
		int totalCost = 0;
		for(int k=0; k < mergedCost.size();k++){
			//sum all the values in the array 
			totalCost += mergedCost.get(k);
		} 

		//return total cost
		return totalCost;

	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] testlists = {3, 5, 9, 11, 16, 18, 20};
		
        System.out.println("The minimum cost to merge testlists[] is "+ merge(testlists));
        // Expected output: 216

}
	

}
