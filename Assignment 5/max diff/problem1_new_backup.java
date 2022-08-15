/**   
 Alexander Lizzo 
 2/19/22    
 CMPT 435L  - Algorithms and Analysis 

    **/
import java.util.*;

public class Problem1{
    
    static class MinMaxCache{
    double max;    
    double min;
    double diff;       
    }






    public static MinMaxCache maxstep(double[] A, int s, int e)
    {
        // Complete the method to find the maximum step between elements in A[]
        // feel free to change the return type, parameters
        // full credits will be awarded to divide and conquer and O(n)
        //Given an array of n ≥ 2 integers, say A[] = {A[0], . . . , A[n-1]}, 
        //we want to find the largest step d, which is defined to be the max of A[j]− A[i] over all j > i. 
        
        //three objects:
        //object to hold store final values
        MinMaxCache minMax = new MinMaxCache();
        //object to hold values in the left most array dissection
        MinMaxCache left = new MinMaxCache();
        //object to hold values in the right most array dissection
        MinMaxCache right = new MinMaxCache();

       


        
        if(s+1 == e ){       // two elements
            if(A[s] < A[e]){
                minMax.min = A[s];
                minMax.max = A[e];
                minMax.diff = minMax.max - minMax.min;
          

            } else{
                minMax.min = A[e];
                minMax.max = A[s];
            } 


            return minMax;


        } else if (s+2 == e ){       //three elements
            if (A[s] <= A[e] && A[s] <= A[s+1]){              // {7, 9, 1,     6, 3, 2}; // n-1=5
                minMax.min = A[s];
            }
            else if (A[e] <=A[s] && A[e] <= A[s+1]){
                minMax.min = A[e];
            }
            else{
                minMax.min = A[s+1];
            }

            if (A[s] >= A[e] && A[s] >= A[s+1]){
                minMax.max = A[s];
            }
            else if (A[e] >=A[s] && A[e] >= A[s+1]){
                minMax.max = A[e];
            }
            else{
                minMax.max = A[s+1];
            }

            if(s < e || s+1 < e){
            minMax.diff = minMax.max - minMax.min;
            }

            return minMax;
        }else{    // greater than 3 elements - recursive case
            int mid = (s + e) / 2;

            //recursion
            // pair 1: both A[p], A[q] in L ==> A[Lp], A[Lq]
            left = maxstep(A, s, mid);

                double pair1 = left.max - left.min;
                //double pair1 = left.diff;

            // pair 2: both A[p], A[q] in R ==> A[Rp], A[Rq]
            right =  maxstep(A, mid+1, e );
                //double pair2 = right.max - right.min;
                double pair2 = right.diff;

            // pair 3: A[p] in L, A[q] in R ==> A[minL], A[maxR]
                double pair3 = right.max - left.min;


            if(pair1 > pair2 && pair1 > pair3){
                minMax.max = left.max;
                minMax.min = left.min;

            }else if(pair2 > pair1 && pair2 > pair3){
                minMax.max = right.max;
                minMax.min = right.min;

            }else if(pair3 >= pair1 && pair3 >= pair2) {
                minMax.max = right.max;
                minMax.min = left.min;
            }

            return minMax;

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
         MinMaxCache result1 = new MinMaxCache();
        result1 = maxstep(testarray1, 0, testarray1.length-1);
        System.out.println("max step is: "+(result1.max - result1.min)+" ....min is: " + result1.min + " ...max is: "+result1.max );


       // Add test statements 
                // Test your method
        MinMaxCache result2 = new MinMaxCache();
        result2 = maxstep(testarray2, 0, testarray2.length-1);
        System.out.println("max step is: "+(result2.max - result2.min)+" ....min is: " + result2.min + " ...max is: "+result2.max );

        // Add test statements 
        // Test your method
        MinMaxCache result3 = new MinMaxCache();
        result3 = maxstep(testarray3, 0, testarray3.length-1);
        System.out.println("max step is: "+(result3.max - result3.min)+" ....min is: " + result3.min  + " ...max is: "+result3.max );
        
        
        
    }
}


