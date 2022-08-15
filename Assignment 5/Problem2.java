

import java.util.*;
/*
public class paritionedIntArray {     
      private int[] parition1Array; //array2
      private int[] parition2Array; //array1

      public paritionedIntArray(int[] parition1Array, int[] parition2Array)
      {
         this.parition1Array = parition1Array;
         this.parition2Array = parition2Array;
      }

    public int[] getparition1Array() { return parition1Array; }
    public int[] getparition2Array() { return parition2Array; }
}  */

public class Problem2 
{
	
	
	
	//The original partition function
	public static int partition(int[] A, int s, int e)
	{
		int pivot = A[s];
		int i = s + 1;
		int j = e;

		while (i<=j)
		{
			while (i < e & A[i] < pivot) 
				i = i + 1;
		
			while(j > s & A[j] >= pivot) 
				j = j - 1;
		
			if (i >= j) 
				break;
		
			swap(A, i, j);			
			
		}

			swap(A, s, j);
			return j;

	}
	
	
	
	//The original quicksort function
	public static void quicksort(int[] A, int s, int e)
	{
		if ( s < e ) 
		{
			int p = partition(A, s, e);
			
			quicksort(A, s, p-1);
			quicksort(A, p+1, e);
			
		}
	}  
	
	
	public static void swap(int[] A, int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		
	}
	
	
	

	static int[] partition_2pivots(int[] A, int s, int e)

		//Randomly select 2 pivots and partition the array
		//Return the position of 2 pivots after partition
		//Complete the function
		//Feel free to change the return type and parameters
		
{
		Random randomElement1 = new Random();
		Random randomElement2 = new Random();

        int pivot1 = randomElement1.nextInt(e-s)+s;
        int pivot2 = randomElement2.nextInt(e-s)+s;

        if(pivot1 > pivot2){
	        int temp = pivot1;
			pivot1 = pivot2;
			pivot2 = temp;
        }  
	//	https://www.geeksforgeeks.org/quicksort-using-random-pivoting/
         
    int i = s;
    int j = e;
    int k = s;

    int temp2 = A[pivot1]; 
    A[pivot1]= A[s];
    A[s] = temp2;


    int temp3 = A[pivot2]; 
    A[pivot2]= A[e];
    A[e] = temp3;


    int p = A[s];
    int q = A[e];
    //	 int randomPivot1 = A[pivot1];
	// int randomPivot2 = A[pivot2];
         
    while (i <= j)
    {
         
        // If elements are less than the left pivot
        if (A[i] < p)
        {
            swap(A, i, k);
            k++;
        }
         
        // If elements are greater than or equal
        // to the right pivot
        else if (A[i] >= q)
        {
            while (A[j] > q && i < j)
                j--;
                 
            swap(A, i, j);
            j--;
             
            if (A[i] < p)
            {
                swap(A, i, k);
                k++;
            }
        }
        i++;
    }
  //  k--;
  //  j++;
     
    // Bring pivots to their appropriate positions.
    swap(A, s, k);
    swap(A, e, j);
 
    // Returning the indices of the pivots
    // because we cannot return two elements
    // from a function, we do that using an array.
    return new int[] { k, j };
}

	public static void quicksort_2pivots(int[] A, int s, int e)
	{
		//quicksort that uses the modified partition_2pivots()
		//Complete the function
		//Feel free to change the return type and parameters

		if ( s < e ) 
		{
			int[] p;
			p = partition_2pivots(A, s, e);
			
			//https://www.geeksforgeeks.org/dual-pivot-quicksort/
			// p[] stores left pivot and right pivot.
        	// p[0] means left pivot and
        	// p[1] means right pivot

			quicksort_2pivots(A, s, p[0] - 1 );           // {2, 4, 1, 6, 3, 7, 8};
			quicksort_2pivots(A, p[0] + 1, p[1] - 1);
			quicksort_2pivots(A, p[1]+1, e);
			
		}
		
		
	} 
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		// Test 
		
		int[] testarray1 = {2, 4, 1, 6, 3, 7, 8};
		
		int[] testarray2 = {6, 3, 4, 5, 1};
		
		quicksort_2pivots(testarray1, 0, testarray1.length-1);
		quicksort_2pivots(testarray2, 0, testarray2.length-1);
		
		//Output sorted arrays
		for(int i = 0; i < testarray1.length; i++)
		{
			System.out.print(testarray1[i] + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i < testarray2.length; i++)
		{
			System.out.print(testarray2[i] + " ");
		}
		System.out.println();
		
	}//main
}//Problem2
