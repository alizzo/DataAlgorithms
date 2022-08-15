public class LongestIncreasingDP {
	
	public static int LongestIncreasingSubsequence(int[] A) {
		
		
		int[] Local_maximum =  new int[A.length];
		Local_maximum[0] = A[0];
 
		// Complete the function from here
		// Feel free to change the return type and parameters
		// Implement the dynamic programming Longest Increasing Subsequence Algorithm
		// Return the length of longest increasing subsequence in A[]
		// Hint: Follow the algorithm in Online Quiz 9

		int[] lis =  new int[A.length]; // inititalize an array to store the longest increasinig subsequence at each element in the array
		int max = 0;

		for(int i=0; i<A.length; i++){
				lis[i] = 1;
		}

		for(int i = 1; i < A.length; i++){
				for(int j = 0; j < i; j++){
					if(A[j] < A[i] && lis[j]+1 > lis[i])
						lis[i]  = lis[j]+1;
				}
		}

		for(int i =0; i < A.length; i++){
			if(max < lis[i]){
				max = lis[i];
			}

		}
	

		return max;
	}

	public static void main(String[] args) {
		
		int[] A = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		
		
		System.out.println("The longest increasing subsequence in A[] has a length of " +  LongestIncreasingSubsequence(A) );
		//Given the array [10, 22, 9, 33, 21, 50, 41, 60, 80], the longest increasing subsequence [10, 22, 33, 50, 60, 80] has a length of 6.
	}

}
