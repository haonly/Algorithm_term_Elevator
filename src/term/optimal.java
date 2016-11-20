package term;


public class optimal 
{

	private int optimal;
	private int person_dest;
	private int person_curr;
	private int capacity=10;
	
	
	public optimal()
	{
		optimal = 0;
		person_dest = 0;
		person_curr = 0;
	}
	
	public int getOptimal() {
		return optimal;
	}

	public void setOptimal(int optimal) {
		this.optimal = optimal;
	}

	public int getDest() {
		return person_dest;
	}

	public void setDest(int dest) {
		this.person_dest = dest;
	}

	public int getCurr() {
		return person_curr;
	}

	public void setCurr(int curr) {
		this.person_curr = curr;
	}
	
	
	public void calculation(Elevator e1, Elevator e2, Elevator e3){
		
		//확인 순서 : 가능한 층수 엘레베이터 -> capacity -> 시간계산
		
		if(person_dest==1||person_dest==3||person_dest==8){
			boolean check1,check2,check3;
			int time1=1000,time2=1000,time3=1000;
			
			check1=check_capacity(e1);
			check2=check_capacity(e2);		
			check3=check_capacity(e3);		
			
			if(check1)
				;//계산.e1
			if(check2)
				;//계산.e2
			if(check3)
				;//계산.e3
			
			if(time1<time2&&time1<time3)
				;//e1
			else if(time2<time1&&time2<time3)
				;//e1	
			else if(time3<time2&&time3<time1)
				;//e1					
			else
				;//e1		
			
		}
		
		else if((1<person_dest&&person_dest<3)||(8<person_dest&&person_dest<=10)){
			boolean check1,check2;
			int time1=1000,time2=1000;
			
			check1=check_capacity(e1);
			check2=check_capacity(e3);		
			
			if(check1)
				;//계산.e1
			if(check2)
				;//계산.e3
			
			if(time1<time2)
				;//e1
				
			else
				;//e3			
				
		}
		
		else{
			//e2,e3
			boolean check1,check2;
			int time1=1000,time2=1000;
			
			check1=check_capacity(e2);
			check2=check_capacity(e3);		
			
			if(check1)
				;//계산.e2
			if(check2)
				;//계산.e3
			
			if(time1<time2)
				;//e2
				
			else
				;//e3			
		}
		
		//움직이는 엘베이터의 작동 중지 시간 + 오는 시간

	}
	
	public boolean check_capacity(Elevator e){
		
		if(e.getCnt_person()>=capacity)
			return false;
		
		else
			return true;
	}
	
}



