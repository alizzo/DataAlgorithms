/**   
 Alexander Lizzo 
 4/13/22    
 CMPT 435L  - Algorithms and Analysis 

    **/

public class ContiguousSumDP {
	
	public static int MaximumSumContSubsequence(int[] A) {
		
		//stores the maxium subset sum for i to n in local max array
		int[] Local_maximum =  new int[A.length];
		//temp stores the start and end location of max sum
		int[] temp =  new int[A.length];

		//initally max sum is first element in local_max
		Local_maximum[0] = A[0];
		//stores start and end position of largest sum
		temp[0] = 0;
 
		// Complete the function from here
		// Feel free to change the return type and parameters
		// Implement the dynamic programming Maximum Sum Contiguous Subsequence Algorithm
		// Return the maximum sum of contiguous subsequence in A[]
		// Hint: Follow the algorithm in Online Quiz 9
		
		
		//initally max value is first element in local_max
		int max = Local_maximum[0];

		//intitalize start and end positions to first position (zeroth position)
		int start = 0;
		int end = 0;

		//iterate through elements. compare if previous value plus current value is greater than current value
		for(int i=1 ; i < A.length; i++) {
			if(Local_maximum[i-1] > 0){
				//Local_maximum[i] = max(A[i], A[i]+Local_maximum(i-1))
				Local_maximum[i] = Local_maximum[i-1] + A[i];
				temp[i] = temp[i-1];
			}else{
				Local_maximum[i] = A[i];
				temp[i] = i;
			}

			//update max value based on condtions above
			if( Local_maximum[i] > max){
				start = temp[i];
				end = i;
				max = Local_maximum[i];

		} 
	}
	
	return max;

	}

	public static void main(String[] args) {
		
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		
		System.out.println("The maximum sum of contiguous subsequence in A[] = " +  MaximumSumContSubsequence(A) );
		//Given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.


		int [] A1 = {5, 15, -30, 10, -5, 40, 10};
		System.out.println("The maximum sum of contiguous subsequence in A[] = " +  MaximumSumContSubsequence(A1) );
		//Given the array {5, 15, −30, 10, −5, 40, 10}, the contiguous subarray {10, −5, 40, 10} has the largest sum = 55.


		 
		int [] A2 =  { 2, -5, 7, 6, -1, -4, 11, -23};
		System.out.println("The maximum sum of contiguous subsequence in A[] = " +  MaximumSumContSubsequence(A2) );
		//Given the array  { 2, -5, 7, 6, -1, -4, 11, -23}, the contiguous subarray {7, 6, -1, -4, 11} has the largest sum = 19.



	}

 }

