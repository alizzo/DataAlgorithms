public class Problem1_stockMax{
    public static double maxProfit(double[] prices) {
        //Kadane's algorithm
        if(prices.length == 0) {
            return 0;
        }
        
        double max = 0;
        double min = prices[0];
        
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            } else {
                min = prices[i];
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

        // Add test statements 
                // Test your method

        double result = maxProfit(testarray1);
        System.out.println("diff: "+ result);


                // Test your method
        double result2 = maxProfit(testarray2);
        System.out.println("diff: "+ result2);

               double result3 = maxProfit(testarray3);
        System.out.println("diff: "+ result3); 

        


        
        
        
    }
}