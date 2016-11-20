package term;


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Elevator E1 = new Elevator();
		Elevator E2 = new Elevator();
		Elevator E3 = new Elevator();
		
		E1.start();
		E2.start();
		E3.start();
		
		Person per = new Person();
		optimal op = new optimal();
		
		per.setDestFloor(3);
		per.setCurrFloor(1);
		
		op.setDest(per.getDestFloor());
		op.setCurr(per.getCurrFloor());

	}

}
