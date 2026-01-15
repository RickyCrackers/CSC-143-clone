//package junits;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import construction.Point;
//import utils.ArrayList;
//import utils.Iterator;
//import utils.LinkedList;
//import utils.SinglyLinkedList;
//import utils.List;
//
//import java.util.NoSuchElementException;
//import java.util.Objects;
//
///**
// * @author A. Ford
// * This is a JUnit Test for the utils.ArrayList.ArrayIterator and
// * utils.LinkedList.LinkedIterator Classes
// * This class uses the Jupiter JUnit Test Library
// * current version is Jupiter 5.8.1
// */
//public class JUNIT06QQListIteratorTest {
//
//    @Test
//    void testArrayIterator() {
//        List<Point> pointList = new ArrayList<>();
//        List<String> stringList = new ArrayList<>();
//
//        unitTestPointIterator(pointList);
//        unitTestStringIterator(stringList);
//
//    }
//
//    @Test
//    void testSinglyLinkedIterator() {
//        List<Point> pointList = new SinglyLinkedList<>();
//        List<String> stringList = new SinglyLinkedList<>();
//
//        unitTestPointIterator(pointList);
//        unitTestStringIterator(stringList);
//
//    }
//
//
//    @Test
//    void testLinkedIterator() {
//        List<Point> pointList = new LinkedList<>();
//        List<String> stringList = new LinkedList<>();
//
//        unitTestPointIterator(pointList);
//        unitTestStringIterator(stringList);
//
//    }
//
//
//    static void unitTestPointIterator(List<Point> list) {
//        System.out.println("------  T  E  S  T     P  O  I  N  T     I  T  E  R  A  T  O  R  ------");
//
//        makePointElements(list);
//
//        Iterator<Point> itr = list.iterator();                  //Start at front of list
//
//        assertEquals(new Point(0, 1) ,  itr.next());
//        assertEquals(new Point(0, 2) ,  itr.next());
//        assertEquals(new Point(0, 3) ,  itr.next());
//        assertEquals(new Point(0, 4) ,  itr.next());
//        assertEquals(new Point(0, 5) ,  itr.next());
//        assertEquals(new Point(0, 6) ,  itr.next());
//        assertEquals(new Point(0, 7) ,  itr.next());
//        assertEquals(new Point(0, 8) ,  itr.next());
//        assertEquals(8 ,  list.size());
//
//        Point point1 = new Point(0, 3);
//        Point point2 = new Point(0, 6);
//
//        assertEquals(point1, list.get(2));
//        assertEquals(point2, list.get(5));
//
//        Iterator<Point> itr2 = list.iterator();                 //Start at front of list again
//        System.out.println();
//        System.out.println();
//
//        while(itr2.hasNext()) {
//            Point point = itr2.next();
//            System.out.println(list);
//            if (Objects.equals(point, point1) || Objects.equals(point, point2)) {
//                itr2.remove();
//            }
//        }
//
//        Iterator<Point> itr3 = list.iterator();                 //Start at front of list again
//        assertEquals(new Point(0, 1) ,  itr3.next());
//        assertEquals(new Point(0, 2) ,  itr3.next());
//        assertEquals(new Point(0, 4) ,  itr3.next());
//        assertEquals(new Point(0, 5) ,  itr3.next());
//        assertEquals(new Point(0, 7) ,  itr3.next());
//        assertEquals(new Point(0, 8) ,  itr3.next());
//        assertEquals(6 ,  list.size());
//        System.out.println();
//        System.out.println();
//    }
//
//
//    static void unitTestStringIterator(List<String> list) {
//        System.out.println("------  T  E  S  T     S  T  R  I  N  G     I  T  E  R  A  T  O  R  ------");
//
//        makeStringElements(list);
//
//        Iterator<String> itr = list.iterator();
//        int i = 0;
//        String currentValue;
//        boolean hasNextValue;
//
//        while(itr.hasNext() && i < list.size()) {
//            hasNextValue = itr.hasNext();
//            currentValue = itr.next();
//
//            System.out.printf("hasNext: %s \t\tnext: %s%n", hasNextValue, currentValue);
//
//            assertTrue(hasNextValue);
//            assertEquals(list.get(i), currentValue);
//
//            i++;
//        }
//
//        // At end of the list : No more elements
//        assertFalse(itr.hasNext());
//
//        // No more elements to retrieve will throw Exception
//        assertThrows(NoSuchElementException.class, itr::next);
//        System.out.println();
//        System.out.println();
//    }
//
//
//    static void makePointElements(List<Point> list) {
//        list.add(0, new Point(0, 1));
//        list.add(1, new Point(0, 2));
//        list.add(2, new Point(0, 3));
//        list.add(3, new Point(0, 4));
//        list.add(4, new Point(0, 5));
//        list.add(5, new Point(0, 6));
//        list.add(6, new Point(0, 7));
//        list.add(7, new Point(0, 8));
//
//        System.out.println();
//        System.out.println(list);
//    }
//
//
//    static void makeStringElements(List<String> list) {
//        list.add(0, "Un");
//        list.add(1, "Deux");
//        list.add(2, "Trois");
//        list.add(3, "Quatre");
//        list.add(4, "Cinq");
//        list.add(5, "Six");
//        list.add(6, "Sept");
//        list.add(7, "Huit");
//        list.add(8, "Neuf");
//        list.add(9, "Dix");
//
//        System.out.println();
//        System.out.println(list);
//    }
//
//}
