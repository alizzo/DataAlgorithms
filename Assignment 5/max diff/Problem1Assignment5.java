import java.util.LinkedHashSet;
public class Problem1 {	
	
	public static void intersection(int[] s1, int[] s2){
		// complete the intersection() method to output
		// elements that occur in both s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place

		int i = 0;
		int j = 0;
		


		while (i < s1.length && j < s2.length) {

		if (s1[i] == s2[j] ){

			if(i >= 1 && s1[i] == s1[i-1]){
				i++;
			}if(j >= 1 && s2[j] == s2[j-1]){
				j++;
			}else{
			System.out.print( s1[i] +" ");
			i++;
			j++;
			}
		}


		else if (s1[i] > s2[j]){ // A, B are sorted in ascending order
			j++;
			}

		else {
			i++;
			}
		}  
	}
	


/*
    public static void union(int s1[], int s2[]) {
    	// complete the union() method to output
		// the union s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        int i = 0; 
        int j = 0;
        while (i < s1.length && j < s2.length) {
            if (s1[i] < s2[j])
                result.add(s1[i++]);
            else
                result.add(s2[j++]);
        }
        while (i < s1.length)
            result.add(s1[i++]);
        while (j < s2.length)
            result.add(s2[j++]);
        result.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
*/





		public static void union(int[] s1, int[] s2){
		// complete the union() method to output
		// the union s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place
		int i = 0;
		int j = 0;

		while (i < s1.length && j < s2.length) {
			if(s1[i] == s2[j] ){              //condition 1: the values are even

				if(i >= 1 && s1[i] == s1[i-1]){
					i++;
				}if(j >= 1 && s2[j] == s2[j-1]){
					j++;
				}else{
					System.out.print( s1[i] +" ");  // used to print to method
				//	System.out.print(i+ " ");
				//	System.out.print(j+ " ");
					i++;
					j++;

				//	System.out.print( i +" ");
				}

			if(i> s1.length-1 ){          
				//	System.out.print(s2.length-1 );
					
				int e =  s2.length;
				for(int s  =  i;  s < e; s++){

					if (s2[s] > s2[s-1]     ){      
						System.out.print( s2[s] +" ");	
					}
				}
			}else if(j> s2.length-1){
				//System.out.print(s1.length-1 );
				int e =  s1.length;
				for(int s  =  i;  s < e; s++){
					if (s1[s] > s1[s-1]     ){      
						System.out.print( s1[s] +" ");			
					}
				}
			}
		}
		






		else if (s1[i] < s2[j] ){       //condition 2: s2 value is greater
				if(i >= 1 && s1[i] == s1[i-1]){
					i++;
				}else{
			System.out.print( s1[i] +" ");  // used to print to method
			//System.out.print(i+ " ");
					i++;
	
			if(i> s1.length-1){
					//System.out.print(s2.length-1 );
					
				int e =  s2.length;
				for(int s  =  i;  s < e; s++){

					if (s2[s] > s2[s-1]     ){      
						System.out.print( s2[s] +" ");	
					}
				}
			}else if(j> s2.length-1){
				//System.out.print(s1.length-1 );
				int e =  s1.length;
				for(int s  =  i;  s < e; s++){
					if (s1[s] > s1[s-1]     ){      
						System.out.print( s1[s] +" ");			
					}
				}
			}
			}  //end of else 
				 




		}else if (s1[i] > s2[j]  ){          //condition 3: s1 value is greater
			if(j >= 1 && s2[j] == s2[j-1]){
					j++;
			}else{
				System.out.print( s2[j] +" ");     // used to print to method
					j++;
			//	System.out.print(j + " ");
			//	System.out.print(i+ " ");

			if(i> s1.length-1 ){           
					//System.out.print(s2.length-1 );
					
				int e =  s2.length;
				for(int s  =  i;  s < e; s++){

					if (s2[s] > s2[s-1]     ){      
						System.out.print( s2[s] +" ");	
					}
				}
			}else if(j> s2.length-1){
				//System.out.print(s1.length-1 );
				int e =  s1.length;
				for(int s  =  i;  s < e; s++){
					if (s1[s] > s1[s-1]     ){      
						System.out.print( s1[s] +" ");			
					}
				}
			}
					}
		} 

		} //end of while
		}













	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test your intersection() method here
		
		
		int[] testarray1 = {0, 0, 0, 0,  1, 2, 3, 97, 98};
		int[] testarray2 = {0, 0, 1, 2, 3, 4, 4, 10, 98, 99, 100, 100, 200, 300, 300, 300, 300};
		System.out.println("intersection and union of first two arrays(second array is larger in length");
		System.out.println();
		System.out.print("intersection of testarray1 and testarray2: ");
		intersection(testarray1,testarray2);
		System.out.println();
		//should output 0, 1, 2, 3, 98
		System.out.print("union of testarray1 and testarray2: ");
		union(testarray1,testarray2);
		System.out.println();
		//should output 0, 1, 2, 3, 4, 10, 97, 98, 100, 200, 300  

		int[] testarray3 = {0, 1, 2, 3, 4, 4, 10, 98, 99, 100, 100, 200, 300, 300, 300, 300};
		int[] testarray4 = {0, 0, 0, 1, 2, 3, 97, 98};
		System.out.println("intersection and union of second two arrays(first array is larger in length)");
		System.out.println();
		System.out.print("intersection of testarray4 and testarray3: ");
		intersection(testarray4,testarray3);
		System.out.println();
		//should output 0, 1, 2, 3, 98
		System.out.print("union of testarray4 and testarray3: ");
		union(testarray3,testarray4);
		System.out.println();
		//should output 0, 1, 2, 3, 4, 10, 97, 98, 100 ,200, 300


		int[] testarray5 = {0, 0, 0, 0, 1, 2, 3, 4};
		int[] testarray6 = {0, 0, 0, 0, 1, 1, 5, 6, 7, 8, 9};
		System.out.println("intersection and union of third two arrays");
		System.out.println();
		System.out.print("intersection of testarray5 and testarray6: ");
		intersection(testarray5,testarray6);
		System.out.println();
		//should output 0
		System.out.print("union of testarray5 and testarray6: ");
		union(testarray5,testarray6);
		System.out.println();
		//should output 0 ,1,2,4,5,5,6,7,8,9

		int[] testarray7 = {0, 0, 0, 0, 1, 2, 3, 4};
		int[] testarray8 = {0, 0, 0, 0, 1, 1, 5, 6, 7, 8, 9};
		System.out.println("intersection and union of fourth two arrays");
		System.out.println();
		System.out.print("intersection of testarray5 and testarray6: ");
		intersection(testarray8,testarray7);
		System.out.println();
		//should output 0
		System.out.print("union of testarray5 and testarray6: ");
		union(testarray8,testarray7);
		System.out.println();
		//should output 0 ,1,2,4,5,5,6,7,8,9



		int[] testarray9 = {5, 5, 5, 5};
		int[] testarray10 = {0, 0, 0, 0, 1, 1, 5, 6, 7, 8, 9};
		System.out.println("intersection and union of fifth two arrays");
		System.out.println();
		System.out.print("intersection of testarray5 and testarray6: ");
		intersection(testarray9,testarray10);
		System.out.println();
		//should output 5
		System.out.print("union of testarray5 and testarray6: ");
		union(testarray9,testarray10);
		System.out.println();
		//should output 0 ,1,5,6,7,9
	}

}
