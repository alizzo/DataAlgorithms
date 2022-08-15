/**   
 Alexander Lizzo 
 4/27/22    
 CMPT 435L  - Algorithms and Analysis 

    **/

public class item {
	public int id;
	public double value;
	public int size;
	public double density;
	
	
	public item( double givenvalue, int givensize, int givenid)
	{
		this.id = givenid;
		
		this.size = givensize;
		
		this.value = givenvalue;
		
		this.density = value/size;
	}

	public double getValue() {
		return value;
	}

	public double getSize() {
		return size;
	}

	public double getDensity() {
		return density;
	}
	

}