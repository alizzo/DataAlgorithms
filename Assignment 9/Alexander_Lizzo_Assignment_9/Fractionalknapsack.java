/**   
 Alexander Lizzo 
 4/27/22    
 CMPT 435L  - Algorithms and Analysis 

    **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Fractionalknapsack {
	
	
	
	public static void sortitems(ArrayList<item> svd)
	{
		
		// Sort items by value to size ratio in descending order
		Collections.sort(svd, new Comparator<item>(){
		     public int compare(item o1, item o2){
		         if(o1.density == o2.density)
		             return 0;
		         return o1.density > o2.density ? -1 : 1;
		     }
		});
		
		
	}
	
	
	public static double greedyfractionalknapsack(ArrayList<item> svd, int S){
		// Complete code here to maximize the value of items in the knapsack
		// Input: items in list svd are sorted by density already
		// Output: the value of the knapsack

		// S is the capcity of the knapsack

		//this is loop counter
       int i = 0;
       // variable to track a count of the size of the knapsack 
       int currentSizeOfKnapSack = 0;

       //this is the current value of the knapsack
       double currentValueOfKnapSack = 0;

       // loop through the array until knapsack is full
        while(i < svd.size()){
        	//add the value of the knapsack
        	currentSizeOfKnapSack += svd.get(i).getSize();
        	
        	// dont overfill the knapsack
        	if(currentSizeOfKnapSack <= S){
        		//add the value of item to the knapsack
	        	currentValueOfKnapSack  += svd.get(i).getValue();
	        	i++;		
        	}
        	// if the knapsack is almost full, but might have some room for a fraction of the next item
        	else{
        		//determine if the napsack was divisable by the size of the knapsack... if not
        		if(currentSizeOfKnapSack % S != 0){
        			//add the fractional piece of the i_th item to the sack, then break 
        		 	currentValueOfKnapSack = currentValueOfKnapSack + ((currentSizeOfKnapSack - S) * svd.get(i).getDensity());
        		 	break;
        		 }else{
        		 	//if knapsack is divisable by S then it was as full as it's going to get.
        		 	break;
        		 }
        	
        	}
        }  




		
		return currentValueOfKnapSack ;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int max_qty,n;  
         
        Scanner reader = new Scanner(System.in);
         
        System.out.println("Enter no of items");  
        n=reader.nextInt(); 
        ArrayList<item> items=new ArrayList();
 
        
        for(int i=0;i<n;i++)  
        {    
        	System.out.println("Enter the size of item "+ (i+1)); 
        	int s =reader.nextInt();    
        	System.out.println("Enter the value of item "+ (i+1));
            double v =reader.nextDouble();
            item newitem = new item(v,s,(i+1));
            items.add(newitem);
        }
        
 
        System.out.println("Enter maximum volume of knapsack :");  
        max_qty=reader.nextInt();  
 
        greedyfractionalknapsack(items, max_qty);


		/*
		int max_qty,n;  
	      
        ArrayList<item> items=new ArrayList();
		
		// item( double givenvalue, int givensize, int givenid)

		// item 1, value 6, size 1
        items.add(new item(6,1,1));     // density = 6/1 =6
		
		// item 2, value 10, size 2
		items.add(new item(10,2,2));   // density = 10/2 = 5
		
		// item 3, value 12, size 3
		items.add(new item(12,3,3));   // density = 12/3 = 4
		
		// the size of your knapsack (capacity)   // max capacity should be 24
        max_qty=5;  

        */

		
		// sort items by value to size ratio
		sortitems(items);

 
        System.out.println("The maximum value we can place into the knapsack is "+ greedyfractionalknapsack(items, max_qty));

	}
	
	
}
