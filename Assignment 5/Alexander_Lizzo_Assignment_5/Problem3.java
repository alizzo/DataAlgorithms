import java.util.*;
public class Problem3 {

//https://www.geeksforgeeks.org/3-way-quicksort-dutch-national-flag/	
	public static void threeway(int[] a)
	{
		//complete the code from here
		//given an array A[], write a function that re-arrange elements in A[] that pivot and //elements=pivot are placed in the comparisonValuedle, elements < pivot are on the left handside
		// elements > pivot are on the right handside.
		//in-place, O(n) expected
		
	
		 int s = 0;               // beginning value of the array
        int comparisonValue = 0;     // s+1 -> element after the pivot value used for comparisons
        int e = a.length - 1;        // last element in the array
        int pivot = a[s]; // this is the pivot element
      
        while (comparisonValue <= e){           //while the s+1 element is less than the last element in the array, iterate.
            if(a[comparisonValue] < pivot){      //  A[l..i] elements less than pivot.
                swap(a, comparisonValue, s);      // if the pointer element less than pivot -> swap pointer element with the first element in array
                s++;
                comparisonValue++;
            }
            else if(a[comparisonValue] == pivot)   // A[i+1..j-1] elements equal to pivot.
                comparisonValue++;					// increment to the next value in the array
            else if(a[comparisonValue] > pivot){  // A[j..r] elements greater than pivot.
                swap(a, comparisonValue, e);     // if the pointer element is greater than pivot -> swap the pointer element with the last element 
                e--;
            }
        }
      
	
	
	}

/*	// following code does not handle duplicates. it need an equal statement condition.
	int s = 0;
		int e = A.length -1;
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
			System.out.println(j);
	*/



	public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method
		int[] testarray={1, 2, 2, 2, 6, 1, 7, 0, -5, 2, 8, 1, 3, 1, 1};
		// Test your method
		threeway(testarray);
		System.out.println(Arrays.toString(testarray));
		// Your method should output {0, -5, 1, 1, 1, 1, 1, 2, 6, 7, 2, 2, 2, 8, 3}
		// with all elements = pivot next to pivot elements<pivot on the left, >pivot on the right
		
		
		
	}
}