import java.util.*;
public class Assignment5_Problem3 {

//https://www.geeksforgeeks.org/3-way-quicksort-dutch-national-flag/	
	public static void threeway(int[] A, int s, int e)
	{
		//complete the code from here
		//given an array A[], write a function that re-arrange elements in A[] that pivot and //elements=pivot are placed in the comparisonValuedle, elements < pivot are on the left handside
		// elements > pivot are on the right handside.
		//in-place, O(n) expected
		

		int pivot = A[s];
		int i = s + 1;
		int j = e;
		int p = s+1;
		int q = e;
		while (i<=j)
		{
			while (i < e & A[i] < pivot){ 
				i = i + 1;
			}
			while(j > s & A[j] >= pivot) {
				j = j - 1;

			}
			if (i >= j){ 
				break;
			}
			swap(A, i, j);	
		}
			swap(A, s, j);
	//		System.out.println(j);

		
		threeway_modified(A, s, pivot, e);
}

	public static void threeway_modified(int[] A, int s, int pivot, int e)
	{
		

		//int pivot = A[s];
		int i = s;
		int j = e;
		while (i<=j)
		{
			while (i < e && A[i] < pivot){ 
				swap(A,i,s);
				i = i + 1;
				s = s+1;
			}


			while(i < e && A[i] == pivot) {
				i++;
			}

			while(j > s && A[j] > pivot) {
				swap(A,i,e);
				j = j - 1;
			}



			if (i >= j) 
				break;
			swap(A, i, j);	


		
			swap(A, s, j);
			System.out.println(j);
      
	}
}




	public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method
		//int[] testarray={6,2,9,3,8,1,7,4};
		int[] testarray={1, 2, 2, 2, 6, 1, 7, 0, -5, 2, 8, 1, 3, 1, 1};
		// Test your method
		threeway(testarray, 0, testarray.length-1);
		System.out.println(Arrays.toString(testarray));
		// Your method should output {0, -5, 1, 1, 1, 1, 1, 2, 6, 7, 2, 2, 2, 8, 3}
		// with all elements = pivot next to pivot elements<pivot on the left, >pivot on the right
		
		
		
	}
}