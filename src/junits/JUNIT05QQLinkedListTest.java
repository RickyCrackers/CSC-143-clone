//package junits;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import construction.Point;
//import utils.LinkedList;
//
//
///**
// * @author A. Ford
// * This is a JUnit Test for the utils.LinkedList Class
// * This class uses the Jupiter JUnit Test Library
// * current version is Jupiter 5.8.1
// */
//public class JUNIT05QQLinkedListTest {
//
//    LinkedList<String>   stringList;
//    LinkedList<Point>    pointList;
//
//    @BeforeEach
//    void testLinkedList() {
//        stringList = new LinkedList<>();
//        pointList = new LinkedList<>();
//        JUNIT02QQListTest.unitTestAddStringElement(stringList);
//        JUNIT02QQListTest.unitTestAddPointElement(pointList);
//        assertEquals(stringList.size(), pointList.size());
//    }
//
//
//    @Test
//    void testLinkedListListE() {
//        LinkedList<Integer>list01 = new LinkedList<>();
//        JUNIT02QQListTest.makeIntegerList(list01);
//
//        LinkedList<Integer>list02 = new LinkedList<>(list01);
//        JUNIT02QQListTest.unitTestAddListElements(list01, list02);
//    }
//
//
//    @Test
//    void testAddE() {
//        JUNIT02QQListTest.unitTestAddElemExpand(stringList, pointList);
//    }
//
//
//    @Test
//    void testAddIntE() {
//        JUNIT02QQListTest.unitTestAddInsertElement(stringList, pointList);
//    }
//
//
//    @Test
//    void testAddAllListE(){
//
//        LinkedList<Point>list01 = new LinkedList<>();
//        assertEquals(0, list01.size());
//
//        JUNIT02QQListTest.makePointElemStartList(list01);
//        assertEquals(7, list01.size());
//
//        int start = list01.size();
//
//        LinkedList<Point> list02 = new LinkedList<>();
//        assertEquals(0, list02.size());
//
//        JUNIT02QQListTest.makePointElemCopyList(list02);
//        assertEquals(5, list02.size());
//
//        assertTrue(list01.addAll(list02));
//        assertEquals(12, list01.size());
//
//        JUNIT02QQListTest.unitTestAddAllList(list01, start);
//
//    }
//
//
//    @Test
//    void testClear() {
//        JUNIT02QQListTest.unitTestClearList(stringList, pointList);
//    }
//
//
//    @Test
//    void testContains() {
//        JUNIT02QQListTest.unitTestContainsElement(stringList, pointList);
//    }
//
//
//    @Test
//    void testEqualsListE() {
//        LinkedList<Point>list1 = new LinkedList<>();
//        LinkedList<Point>list2 = new LinkedList<>();
//        LinkedList<Point>list3 = new LinkedList<>();
//
//        JUNIT02QQListTest.makeEqualPointList(list1);
//        JUNIT02QQListTest.makeEqualPointList(list2);
//        JUNIT02QQListTest.makeNotEqualPointList(list3);
//        JUNIT02QQListTest.unitTestEqualListElements(list1, list2, list3);
//
//    }
//
//
//    @Test
//    void testGet() {
//        JUNIT02QQListTest.unitTestGetElementAtIndex(stringList, pointList);
//    }
//
//
//    @Test
//    void testIndexOf() {
//        JUNIT02QQListTest.unitTestGetIndexOfElement(stringList, pointList);
//    }
//
//
//    @Test
//    void testIsEmpty() {
//
//        assertFalse(stringList.isEmpty());
//        assertFalse(pointList.isEmpty());
//
//        LinkedList<String>list = new LinkedList<>();
//
//        assertTrue(list.isEmpty());
//
//        JUNIT02QQListTest.unitTestIsEmptyList(list);
//
//    }
//
//
//    @Test
//    void testRemoveE() {
//        JUNIT02QQListTest.unitTestRemoveElement(stringList, pointList);
//    }
//
//
//    @Test
//    void testRemoveInt() {
//        JUNIT02QQListTest.unitTestRemoveElementAtIndex(stringList, pointList);
//    }
//
//
//    @Test
//    void testRemoveAll() {
//        LinkedList<Point>list1 = new LinkedList<>();
//        LinkedList<Point>list2 = new LinkedList<>();
//
//        assertEquals(0, list1.size());
//
//        JUNIT02QQListTest.unitTestRemoveAllListElements(list1, list2);
//    }
//
//
//    @Test
//    void testSet() {
//        JUNIT02QQListTest.unitTestSetElement(stringList, pointList);
//    }
//
//
//    @Test
//    void minCapacity() {
//        assertEquals(8, stringList.size());
//        assertEquals(8, pointList.size());
//    }
//
//
//    @Test
//    void testToString() {
//        LinkedList<String>list = new LinkedList<>();
//        JUNIT02QQListTest.unitTestListOutputToReadableString(list);
//    }
//
//
//}
//
