package term;

public class Person extends Thread{
	
	private int destFloor;
	private int currFloor;
	private int wTime;
	private int selectEle;
	private int direction;
	
	public Person()
	{
		destFloor = 0;
		currFloor = 0;
		wTime = 0;
		selectEle = 0;
		direction = 0;
	}

	public int getDestFloor() {
		return destFloor;
	}

	public void setDestFloor(int destFloor) {
		this.destFloor = destFloor;
	}

	public int getCurrFloor() {
		floor.addPerson(currFloor);
		return currFloor;
	}

	public void setCurrFloor(int currFloor) {
		this.currFloor = currFloor;
	}

	public int getwTime() {
		return wTime;
	}

	public void setwTime(int wTime) {
		this.wTime = wTime;
	}

	public int getSelectEle() {
		return selectEle;
	}

	public void setSelectEle(int selectEle) {
		this.selectEle = selectEle;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
