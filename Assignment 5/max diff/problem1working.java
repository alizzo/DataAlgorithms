/**   
 Alexander Lizzo 
 2/19/22    
 CMPT 435L  - Algorithms and Analysis 

    **/

public class problem1working {

	public static double maxstep(double[] A, int s, int e)
	{
		// Complete the method to find the maximum step between elements in A[]
		// feel free to change the return type, parameters
		// full credits will be awarded to divide and conquer and O(n)
		//Given an array of n ≥ 2 integers, say A[] = {A[0], . . . , A[n-1]}, 
		//we want to find the largest step d, which is defined to be the max of A[j]− A[i] over all j > i. 
		 //conditional statment to handle one element in array
        if (s == e){
            return A[s];
        }
 
        int mid = (s + e) / 2; //mid point of array
 
        /* When you divide the array into two halves L and R, the best sub-sequence might be
		(1) located entirely in L
		(2) located entirely in R
		(3) span both L and R */
        //https://www.tutorialspoint.com/java/lang/math_max_int.htm
        return Math.max(                              
        	Math.max(   maxstep(A, s, mid), 
        				    maxstep(A, mid + 1, e)),
            					  sumOfLeftRight(A, s, mid, e));
 
	}
	

/*
       int maxProfit = 0;
     
        // The loop starts from 1
        // as its comparing with the previous
        for (int i = 1; i < size; i++)
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        return maxProfit;
    }

*/


	public static double sumOfLeftRight(double A[], int s, int mid, int e){
		
		double maxdiffL =0;
		for(int i = mid; i>=s+1 ; i--){     //A[j]− A[i] over all j > i. 
			

			if(A[i] > A[i-1]){      //{2, 3, 10, 6}
			maxdiffL += A[i] - A[i-1];
			}		
		}

		double maxdiffR = 0;
		for(int i = mid+1; i<=e ; i++){
			if(A[i]> A[i-1]){
				maxdiffR += A[i] - A[i-1];
			}
		}

		return Math.max(maxdiffR- maxdiffL, Math.max(maxdiffL, maxdiffR));

	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test your maxstep() method here
		

		//double[] testarray1 = {1, 2, 3, 4, 5, 6, 7, 8};
		double[] testarray1 = {2, 3, 10, 6, 4, 8, 1, 3}; // n-1=7
		// maxstep: 8
		
		double[] testarray2 = {7, 9, 1, 6, 3, 2}; // n-1=5
		// maxstep: 5
		
		double[] testarray3 = {7, 9, 10, 3, 1, 6, 2}; // n-1=6
		// maxstep: 5

		// Add test statements 
				// Test your method
		//Problem1 pair = new Problem1();
		double result = maxstep(testarray1, 0, testarray1.length-1);
		System.out.println("diff: "+ result  +" min and max are on left side: expected result 8");

		double result2 = maxstep(testarray2, 0, testarray2.length-1);
		System.out.println("diff: "+ result2  +" min and max are on left side: expected result 5");

		double result3 = maxstep(testarray3, 0, testarray3.length-1);
		System.out.println("diff: "+ result3 +" min and max are on left side: expected result 5");

		
		
	}
}
/*
class Result{
	int min;    
	int max;      
	double diff;

	public Result(double diff, int min, int max){
 		this.diff = diff;
  		this.min = min;
 		this.max = max;
 }
}  */
