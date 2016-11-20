package term;

public class Elevator extends Thread{

	private int[] dest;
	private int curr;
	private int capacity;
	private int cnt_person;
	
	public Elevator()
	{
		for(int i=0;i<10;i++)
			dest[i]=0;
	}
	
	public void addFloor(int broadF, int destF)
	{
		dest[broadF]=1;
		dest[destF]=1;
	}
	
	public void setCurr(int c_p){
		cnt_person=c_p;
	}
	
	public int getCnt_person(){
		return cnt_person;
	}
	
}
