package ele;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.Comparator;

import javax.swing.*;

public class Elevator extends Thread {

   static int DOORS_TIME = 10; // Milliseconds
   static int TRAVELING_TIME = 15; // Milliseconds
   private int id;
   Boolean[] UpDest;
   Boolean[] DownDest;
   int ele_direction = 0;
   private TreeSet<Integer> floor_up = new TreeSet<Integer>();
   private TreeSet<Integer> down_temp = new TreeSet<Integer>();
   private ArrayList<Integer> floor_list = new ArrayList<Integer>();

   NavigableSet<Integer> floor_down;
   private int direction = 0; // -1:down 0: stop 1:up
   private int currF = 1;
   private final int cntF = 10;
   private final int capacity = 10;// 수용인원 10명으로 가정.
   private int[] location = { 840, 730, 640, 550, 460, 370, 280, 180, 100, 0 };
   boolean isMoving = false;

   JLabel bg;
   JLabel ele;
   ImageIcon elevator;

   ElevatorMove move;
   List<Person> persons;

   public Elevator(int id, JLabel bg) {
      elevator = new ImageIcon("img/elevator0.png");
      this.bg = bg;
      this.ele = new JLabel(elevator);
      ele.setLayout(null);
      ele.setSize(70, 100);
      ele.setOpaque(false);
      ele.setLocation(40 + 170 * id, 840);
      bg.add(ele);

      UpDest = new Boolean[10];
      DownDest = new Boolean[10];
      move = new ElevatorMove(ele, this);

      for (int i = 0; i < cntF; i++) {
         UpDest[i] = false;
         DownDest[i] = false;
      }

      this.id = id;
      direction = 1;
      currF = 1;
      persons = new ArrayList<>();
   }

   public void add_floor(int curr, int dest, int direction) {

      if (currF < curr) {// 엘레베이터가 올라감
         floor_up.add(curr);
         if (direction == 1) {
            floor_up.add(dest);

            floor_list.removeAll(floor_list);
            floor_list.addAll(floor_up);

         } else {
            down_temp.add(dest);
            floor_down = down_temp.descendingSet();

            floor_list.removeAll(floor_list);
            floor_list.addAll(floor_up);
            floor_list.addAll(floor_down);

         }

      }

      else if (currF > curr) {// 엘레베이터가 내려감
         down_temp.add(curr);
         if (direction == 1) {
            floor_up.add(dest);

            floor_list.removeAll(floor_list);
            floor_list.addAll(down_temp);
            floor_list.addAll(floor_up);

         } else {
            down_temp.add(dest);
            floor_down = down_temp.descendingSet();

            floor_list.removeAll(floor_list);
            floor_list.addAll(floor_down);

         }

      }

      else {// 엘레베이터 안움직임
         if (direction == 1) {
            floor_up.add(curr);
            floor_up.add(dest);

            floor_list.removeAll(floor_list);
            floor_list.addAll(floor_up);

         } else {
            down_temp.add(curr);
            down_temp.add(dest);
            
            floor_down = down_temp.descendingSet();

            floor_list.removeAll(floor_list);
            floor_list.addAll(floor_down);

         }

      }

      System.out.println("elevator " + id + ": ");
      for (int i = 0; i < floor_list.size(); i++) {
         System.out.print(floor_list.get(i)+" ");
      }

      System.out.print("\n");

   }

   @Override
   public void run() {
      // TODO Auto-generated method stub
      int t = 0;
      int destiny = 0;
      while (true) {
         
         if(floor_list.size()>0)
            destiny=floor_list.get(0);

         if (floor_list.size() == 0)
            isMoving = false;
         else {
            t = Math.abs((location[destiny - 1]) - (location[currF - 1]));
            if (t == 0) {// 멈춰있엉
               ele_direction = 0;
               try {
                  sleep(1700);
               } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
            }

            else if (destiny > currF) {// 올라감

               ele_direction = 1;

               for (int x = 0; x <= t; x = x + 10) {
                  try {
                     sleep(20);
                     ele.setLocation(40 + 170 * id, location[currF - 1] - x);
                     if(floor_list.get(0)<destiny){//중간에 새로 들어옴
                        destiny=floor_list.get(0);
                        t = Math.abs((location[destiny - 1]) - (location[currF - 1]));
                     }
                  } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }
               }
               try {
                  sleep(1700);
                  currF = floor_list.get(0);
               } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
            }

            else {// 내려감
               for (int x = 0; x <= t; x = x + 10) {
                  ele_direction = -1;

                  try {
                     sleep(20);
                     ele.setLocation(40 + 170 * id, location[currF - 1] + x);
                     
                     if(floor_list.get(0)>destiny){//중간에 새로 들어옴
                        destiny=floor_list.get(0);
                        t = Math.abs((location[destiny - 1]) - (location[currF - 1]));
                     }
                  } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }
               }

               try {
                  sleep(1700);
               } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
            }
            floor_list.remove(0);

         }
      }
   }

   public long getId() {
      return id;
   }

   public int getCapacity() {
      return capacity;
   }

   public List getPerson() {
      return persons;
   }

   public void setUpDest(int upDestFloor) {
      UpDest[upDestFloor] = true;
   }

   public void setDownDest(int downDestFloor) {
      DownDest[downDestFloor] = true;
   }

   public int getDirection() {
      return direction;
   }

   public void setDirection(int direction) {
      this.direction = direction;
   }

   public int getCurrF() {
      return currF;
   }

   public void setCurrF(int currF) {
      this.currF = currF;
   }

   public int getPersons() {
      return persons.size();
   }

   public int upDestCount(int personCurr) {
      int cnt = 0;

      for (int i = currF; i < personCurr; i++) {
         if (UpDest[i].equals(true))
            cnt += DOORS_TIME;

         cnt += TRAVELING_TIME;
      }
      return cnt;
   }

   public int downDestCount(int personCurr) {
      int cnt = 0;

      for (int i = currF; i > personCurr; i--) {
         if (DownDest[i].equals(true))
            cnt += DOORS_TIME;

         cnt += TRAVELING_TIME;
      }
      return cnt;
   }

   public void addPerson(Person p) {
      persons.add(p);
   }

}
