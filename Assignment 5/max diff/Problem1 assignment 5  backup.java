public class Problem1 {	
	
	public static void intersection(int[] s1, int[] s2){
		// complete the intersection() method to output
		// elements that occur in both s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place

		int i =0;
		int j = 0;
		int k = 0;


		while (i < s1.length && j < s2.length) {

		if (s1[i] == s2[j]){
			
			System.out.print( s1[i] +" ");
			i++;
			j++;
			}
		else if (s1[i] > s2[j]){ // A, B are sorted in ascending order
			j++;
			}

		else {
			i++;
			}
		}  
	}
	
		public static void union(int[] s1, int[] s2)
	{
		// complete the union() method to output
		// the union s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place
		int i = 0;
		int j = 0;
		int k = 0;


		while (i < s1.length && j < s2.length) {
			if (s1[i] < s2[j] ){                     //&& s1[i] != s1[i-1] && s2[j] != s2[j-1]
				System.out.print( s1[i] +" ");
				i++;
			}else{
				System.out.print( s2[j] +" ");
				j++;
			}

		}  


		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test your intersection() method here
		int[] testarray1 = {0, 0, 0, 1, 2, 3, 97, 98};
		int[] testarray2 = {0, 1, 2, 3, 4, 4, 10, 98, 100, 100};

		
		System.out.print("intersection of testarray1 and testarray2: ");
		intersection(testarray1,testarray2);
		System.out.println();
		//should output 0, 1, 2, 3, 98
		System.out.print("union of testarray1 and testarray2: ");
		union(testarray1,testarray2);
		System.out.println();
		//should output 0, 1, 2, 3, 4, 10, 97, 98, 100
	}

}
