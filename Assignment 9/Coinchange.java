import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.lang.Math;

public class Coinchange {

	public static int greedycoinchange(int givenvalue, int[] givencoins)
	{
		
		// Complete the code here to make change of givenvalue using coins in the array givencoins
		// Minimize the number of coins used
		// Input: Coin denominations in array givencoins are already sorted in descending order
		// Output: The number of coins used to make change of givenvalue		
		
		//Greedy Algorithms slide 14
		int a,b,c;
		a = b = c = 0;

/*
		while(givenvalue >= givencoins[0]){
			a++;
			givenvalue = givenvalue - givencoins[0];	
		}
		while(givenvalue >= givencoins[1]){
			b++;
			givenvalue = givenvalue - givencoins[1];	
		}
		while(givenvalue >= givencoins[2]){
			c++;
			givenvalue = givenvalue - givencoins[2];	
		}  */
		
		for(int i = 0; i <givencoins.length; i++)
		while(givenvalue >= givencoins[i]){
			a++;
			givenvalue = givenvalue - givencoins[i];	
		}



		return a;

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 0; // n cents
		
		Scanner reader = new Scanner(System.in);  
		
		System.out.print("Please enter the value you want to make change: ");
		
		n = reader.nextInt();
		
		int[] coins = {10, 5, 1};
		// Add various denominations to test the program
		System.out.println();
		System.out.println("used "+ greedycoinchange(n, coins)+" coins for "+ n + " cents");
		
		
		int[] coins1 = {11, 7, 1};
		// Add various denominations to test the program
		System.out.println();
		System.out.println("used "+ greedycoinchange(n, coins1)+" coins for "+ n + " cents");
		

		int[] coins2 = {11, 7, 3}; // non optimal solution, because there is no value that satisify 67. 
		// Add various denominations to test the program
		System.out.println();
		System.out.println("used "+ greedycoinchange(n, coins2)+" coins for "+ n + " cents");


		
	}

}
