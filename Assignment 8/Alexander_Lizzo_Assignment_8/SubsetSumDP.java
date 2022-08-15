/**   
 Alexander Lizzo 
 4/11/22    
 CMPT 435L  - Algorithms and Analysis 

    **/

public class SubsetSumDP {
	
	public static boolean subsetSum(int[] A, int x) {
		
		boolean[][] Sum = new boolean[A.length + 1][x + 1];
		// Complete the function from here
		// Feel free to change the return type and parameters
		// Implement the dynamic programming Subset Sum Algorithm
		// Return true if there exists a subset in A with sum = x
		// Hint: Follow the pseudocode of subsetSum in the slides

		//initally set every row in column 0 to true
		// First column is zero because we can always make the total (x) with an empty set. 
		for(int k = 0; k <= A.length ; k++){
			Sum[k][0] = true; 
		}

		//set the first row to false for each column (except at [0][0] (see above))
		//reason: 0/null will never add to the total x, except if x = 0(which is handles (see above)) .
		for(int l = 1; l <= x ; l++){
			Sum[0][l] = false; 
		}

		
		//search the matrix for values that are factors of x and if they are add to Sum[][] as true
		for(int i = 1; i <= A.length ; i++){
			for(int j = 1; j <= x ; j++){
				if(j-A[i-1]<0){
					//based on the previous value: if j-A[i-1]<0 || Sum[i-1][j] => Sum[i-1][j] => true?
					Sum[i][j] = false || Sum[i-1][j];
				}else{
					Sum[i][j] = Sum[i-1][j-A[i-1]] || Sum[i-1][j];   //based on previous values.
				}
			}
		}
		

		
		return Sum[A.length][x];
	}

	public static void main(String[] args) {
		
		int[] A = {1,3,5,2,8};
		int x = 9;
		System.out.println("There exists a subset in A[] with sum = " + x + " : " + subsetSum(A, x) );
		// Expected output: true

		System.out.println();
		System.out.println("second case: ");
		int[] A1_sauce = {1,3,5,2,8};
		int y = 100;
		System.out.println("There exists a subset in A[] with sum = " + y + " : " + subsetSum(A1_sauce, y) );
		// Expected output: false

		System.out.println();
		System.out.println("third case: ");
		int[] A2 = {7,5,3,5};
		int z = 10;
		System.out.println("There exists a subset in A[] with sum = " + z + " : " + subsetSum(A2, z) );
		// Expected output: true

		System.out.println();
		System.out.println("fourth case: ");
		int[] A3 = {3,5,7};
		int a = 11;
		System.out.println("There exists a subset in A[] with sum = " + a + " : " + subsetSum(A3, a) );
		// Expected output: false




	}

}
