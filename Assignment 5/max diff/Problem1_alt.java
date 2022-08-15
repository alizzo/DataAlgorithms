/**   
 Alexander Lizzo 
 2/19/22    
 CMPT 435L  - Algorithms and Analysis 

    **/

public class Problem1 {

	public Result maxstep(double[] A, int s, int e)
	{
		// Complete the method to find the maximum step between elements in A[]
		// feel free to change the return type, parameters
		// full credits will be awarded to divide and conquer and O(n)
		//Given an array of n ≥ 2 integers, say A[] = {A[0], . . . , A[n-1]}, 
		//we want to find the largest step d, which is defined to be the max of A[j]− A[i] over all j > i. 
		if(s == e) {
			return new Result(0,0,0);
		}



		int mid = (s + e) / 2;


		//object to hold values in the left most array dissection
		Result left = maxstep(A, s, mid);
		Result right =  maxstep(A, mid+1, e);

		int leftindexMin = indexofMinimumValue(A,s,mid);
		int rightindexMin = indexofMaximumValue(A,mid+1,e);

    	double difference = A[rightindexMin] - A[leftindexMin];

		if(difference>left.diff && difference>right.diff){
		 	return new Result(difference,leftindexMin,rightindexMin);
		 }else if(left.diff>difference && right.diff>difference){
		 	return left;
		 }else{
		 	return right;
		 }
	}
	
public int indexofMinimumValue(double [] A, int s, int mid){
	 int min = s;
	 for (int k = s+1; k <=mid ; k++) {
	 	if(A[k]<A[min]){
			 min = k;
			}
	 }
	 return min;
}
public int indexofMaximumValue(double [] A, int mid, int e){
	int max = mid;
 	for (int k = mid+1; k <=e ; k++) {
 		if(A[k]>A[max]){
 		max = k;
 		}
 	}
 	return max;
 }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test your maxstep() method here
		
		double[] testarray1 = {2, 3, 10, 6, 4, 8, 1, 3};
		// maxstep: 8
		
		double[] testarray2 = {7, 9, 1, 6, 3, 2};
		// maxstep: 5
		

		// Add test statements 
				// Test your method
		Problem1 pair = new Problem1();
		Result result = pair.maxstep(testarray1, 0, testarray1.length-1);
		System.out.println("diff: "+ result.diff + " min "+ result.min +" max: "+ result.max);


		// Add test statements 
				// Test your method
		Problem1 pair2 = new Problem1();
		Result result2 = pair2.maxstep(testarray2, 0, testarray2.length-1);
		System.out.println("diff: "+ result2.diff + " min "+ result2.min +" max: "+ result2.max);

		
		
		
	}
}

class Result{
	int min;    
	int max;      
	double diff;

	public Result(double diff, int min, int max){
 		this.diff = diff;
  		this.min = min;
 		this.max = max;
 }
}
