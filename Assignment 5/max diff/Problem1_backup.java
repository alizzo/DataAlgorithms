/**   
 Alexander Lizzo 
 2/19/22    
 CMPT 435L  - Algorithms and Analysis 

    **/

public class Problem1{

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


        //object to hold values which are stored in Result class
        Result left = maxstep(A, s, mid);
        Result right =  maxstep(A, mid+1, e);

        int leftindexMin = indexofMinimumValue(A,s,mid);     // determines the index value of max & min
        int rightindexMax = indexofMaximumValue(A,mid,e);




        double difference = A[rightindexMax] - A[leftindexMin];   //difference between min and max index position
/*
//this is the only thing working here
    if(difference> (right.diff-left.diff)){
            return new Result(difference,leftindexMin ,rightindexMax);    */

    if(difference> (right.diff-left.diff)){
            return new Result(difference,leftindexMin ,rightindexMax);
        }else if(difference< (right.diff-left.diff)){
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
        

        //double[] testarray1 = {1, 2, 3, 4, 5, 6, 7, 8};
        double[] testarray1 = {2, 3, 10, 6, 4, 8, 1, 3}; // n-1=7
        // maxstep: 8
        
        double[] testarray2 = {7, 9, 1, 6, 3, 2}; // n-1=5
        // maxstep: 5
        
        double[] testarray3 = {7, 9, 10, 3, 1, 6, 2}; // n-1=6
        // maxstep: 5

        // Add test statements 
                // Test your method
        Problem1 pair = new Problem1();
        Result result = pair.maxstep(testarray1, 0, testarray1.length-1);
        System.out.println("diff: "+ result.diff + ": min "+ result.min +" max "+ result.max +" min and max are on left side: expected result 8");


        // Add test statements 
                // Test your method
        Problem1 pair2 = new Problem1();
        Result result2 = pair2.maxstep(testarray2, 0, testarray2.length-1);
        System.out.println("diff: "+ result2.diff + ": min "+ result2.min +" max "+ result2.max +" min and max are split: expected result 5 ");

        // Add test statements 
        // Test your method
        Problem1 pair3 = new Problem1();
        Result result3 = pair3.maxstep(testarray3, 0, testarray3.length-1);
        System.out.println("diff: "+ result3.diff + ": min "+ result3.min +" max "+ result3.max +" min and max are on the right side: expected result 5 ");

        
        
        
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
