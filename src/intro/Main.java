package intro;

import java.util.LinkedList;
public class Main {
   public static void main(String[] args) {
//      DLL list = new DLL();

      /*
      // insertFirst method testing
      list.insertFirst(3);
      list.insertFirst(2);
      list.insertFirst(1);
      list.display();
*/
      // insertLast method testing
      // combined display() not working properly

      CLL list = new CLL();
      list.insert(1);
      list.insert(2);
      list.insert(3);
      list.delete(1);
      list.display();























     // LL list = new LL();
      // insert at first method
/*      list.insertFirst(1);
      list.insertFirst(2);
      list.insertFirst(4);
      list.insertFirst(5);
      list.display();*/

      // insert at last method
      /*list.insertLast(5);
      list.insertLast(6);
      list.insertLast(7);
      list.insertLast(8);
      list.display();*/

      // insert at specified index
/*
      list.insertLast(1);
      list.insertLast(2);
      list.insertLast(4);
      list.insertLast(5);
      list.insertAt(3, 2);
      list.display();
*/



   }
}

/* public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0, 0);
        System.out.println("The original linked list is: " + list);
        int i = 0;
        while (i < 4) {
            int x = list.get(i);
            System.out.println(x);
            i++;
        }

    }*/
