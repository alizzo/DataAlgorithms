/**   
 Alexander Lizzo 
 2/19/22    
 CMPT 435L  - Algorithms and Analysis 

    **/
import java.util.*;

public class Problem1_without_classes{
    
 /*   static class MinMaxCache{
    double max;    
    double min;
   // double diff;       
    }

*/




    public static double maxstep(double[] A, int s, int e, double min, double max, int p, int q)
    {
        // Complete the method to find the maximum step between elements in A[]
        // feel free to change the return type, parameters
        // full credits will be awarded to divide and conquer and O(n)
        //Given an array of n ≥ 2 integers, say A[] = {A[0], . . . , A[n-1]}, 
        //we want to find the largest step d, which is defined to be the max of A[j]− A[i] over all j > i. 
        double left;
        double right;

        /*
        //three objects:
        //object to hold store final values
        MinMaxCache minMax = new MinMaxCache();
        //object to hold values in the left most array dissection
        MinMaxCache left = new MinMaxCache();
        //object to hold values in the right most array dissection
        MinMaxCache right = new MinMaxCache();
*/
       


        
        if(s+1 == e ){       // two elements
            p = s; 
            q = e;
            if(A[s] < A[e]){
                min = A[s];
                max = A[e];

            } else{
                min = A[e];
                max = A[s];
            }
            return max - min;

        } else if (s+2 == e ){       //three elements
            if (A[s] <= A[e] && A[s] <= A[s+1]){
                min = A[s];
            }
            else if (A[e] <=A[s] && A[e] <= A[s+1]){
                min = A[e];
            }
            else{
                min = A[s+1];
            }

            if (A[s] >= A[e] && A[s] >= A[s+1]){
                max = A[s];
            }
            else if (A[e] >=A[s] && A[e] >= A[s+1]){
                max = A[e];
            }
            else{
                max = A[s+1];
            }
            return max - min;
        }else{    // greater than 3 elements - recursive case
            int mid = (s + e) / 2;

            //recursion
            // pair 1: both A[p], A[q] in L ==> A[Lp], A[Lq]
            left = maxstep(A, s, mid, min, max, p, q);


                double pair1 = A[p] - A[q];

            // pair 2: both A[p], A[q] in R ==> A[Rp], A[Rq]
            right =  maxstep(A, mid+1, e, min, max, p, q);
                double pair2 = A[p] - A[q];

            // pair 3: A[p] in L, A[q] in R ==> A[minL], A[maxR]
             //   double pair3 = right.max - left.min;

                
            if(right > left){
                return right;

            }else if(left > right){
               return left;

            }

            return 0;

            /*
            //find min, max
            min = min (minL, minR)
            max = max(maxL, maxR)
            // find the pair with the maximum difference from 3 pairs
            p, q ==> findmaxof(pair1, pair2, pair3)          //Math.max()
            end if */

            
        }
        //return 0;

 
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
        // MinMaxCache result1 = new MinMaxCache();
       double result1 = maxstep(testarray1, 0, testarray1.length-1, 0,0,0,0);
        System.out.println("max step is: "+(result1));


       // Add test statements 
                // Test your method
       // MinMaxCache result2 = new MinMaxCache();
        double result2 = maxstep(testarray2, 0, testarray2.length-1, 0,0,0,0);
        System.out.println("max step is: "+(result2));

        // Add test statements 
        // Test your method
       // MinMaxCache result3 = new MinMaxCache();
        double result3 = maxstep(testarray3, 0, testarray3.length-1, 0,0,0,0);
        System.out.println("max step is: "+(result3));
        
        
        
    }
}


