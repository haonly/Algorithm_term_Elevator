package term;


import java.util.Vector;

public class floor {
   private int intFloor; //floor number
   private int countPersons;
   private boolean isElevator;
   protected Vector persons;


   public floor(int iFloor, boolean ox) {
      intFloor = iFloor;
      countPersons = 0;
      isElevator = ox;
      persons = new Vector();
   }

   public int getIntFloor() {
      return intFloor;
   }
   
   public int getCountPersons() {
      return countPersons;
   }
   
   public boolean getIsElevator() {
      return isElevator;
   }

   public void setIntFloor(int iFloor) {
      intFloor = iFloor;
   }
   
   public void setIsElevator(boolean ox) {
      isElevator = ox;
   }

   public void addPerson(Object objPerson) {
      if (objPerson instanceof Person)
         persons.add(objPerson);
      countPersons = persons.size();
   }
   
   public void removePerson() {
      persons.remove(0);
      countPersons = persons.size();
   }
   
   public Person getPriorityPerson() {
      return (Person)persons.firstElement();
   }
}