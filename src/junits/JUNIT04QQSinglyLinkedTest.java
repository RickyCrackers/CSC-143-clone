package junits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import construction.Point;
import utils.SinglyLinkedList;


/**
 * @author A. Ford
 * This is a JUnit Test for the utils.SinglyLinkedList Class
 * This class uses the Jupiter JUnit Test Library
 * current version is Jupiter 5.8.1
 */
public class JUNIT04QQSinglyLinkedTest {

    SinglyLinkedList<String>    stringList;
    SinglyLinkedList<Point>     pointList;

    @BeforeEach
    void testSinglyLinkedList() {
        stringList = new SinglyLinkedList<>();
        pointList = new SinglyLinkedList<>();
        JUNIT02QQListTest.unitTestAddStringElement(stringList);
        JUNIT02QQListTest.unitTestAddPointElement(pointList);
        assertEquals(stringList.size(), pointList.size());
    }


    @Test
    void testSinglyLinkedListListE() {
        SinglyLinkedList<Integer> list01 = new SinglyLinkedList<>();
        JUNIT02QQListTest.makeIntegerList(list01);

        SinglyLinkedList<Integer> list02 = new SinglyLinkedList<>(list01);
        JUNIT02QQListTest.unitTestAddListElements(list01, list02);
    }


    @Test
    void testAddE() {
        JUNIT02QQListTest.unitTestAddElemExpand(stringList, pointList);
    }


    @Test
    void testAddIntE() {
        JUNIT02QQListTest.unitTestAddInsertElement(stringList, pointList);
    }


    @Test
    void testAddAllListE(){

        SinglyLinkedList<Point> list01 = new SinglyLinkedList<>();
        assertEquals(0, list01.size());

        JUNIT02QQListTest.makePointElemStartList(list01);
        assertEquals(7, list01.size());

        int start = list01.size();

        SinglyLinkedList<Point>  list02 = new SinglyLinkedList<>();
        assertEquals(0, list02.size());

        JUNIT02QQListTest.makePointElemCopyList(list02);
        assertEquals(5, list02.size());

        assertTrue(list01.addAll(list02));
        assertEquals(12, list01.size());

        JUNIT02QQListTest.unitTestAddAllList(list01, start);

    }


    @Test
    void testClear() {
        JUNIT02QQListTest.unitTestClearList(stringList, pointList);
    }


    @Test
    void testContains() {
        JUNIT02QQListTest.unitTestContainsElement(stringList, pointList);
    }


    @Test
    void testEqualsListE() {
        SinglyLinkedList<Point> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<Point> list2 = new SinglyLinkedList<>();
        SinglyLinkedList<Point> list3 = new SinglyLinkedList<>();

        JUNIT02QQListTest.makeEqualPointList(list1);
        JUNIT02QQListTest.makeEqualPointList(list2);
        JUNIT02QQListTest.makeNotEqualPointList(list3);
        JUNIT02QQListTest.unitTestEqualListElements(list1, list2, list3);

    }





    @Test
    void testGet() {
        JUNIT02QQListTest.unitTestGetElementAtIndex(stringList, pointList);
    }


    @Test
    void testIndexOf() {
        JUNIT02QQListTest.unitTestGetIndexOfElement(stringList, pointList);
    }


    @Test
    void testIsEmpty() {

        assertFalse(stringList.isEmpty());
        assertFalse(pointList.isEmpty());

        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        assertTrue(list.isEmpty());

        JUNIT02QQListTest.unitTestIsEmptyList(list);

    }


    @Test
    void testRemoveE() {
        JUNIT02QQListTest.unitTestRemoveElement(stringList, pointList);
    }


    @Test
    void testRemoveInt() {
        JUNIT02QQListTest.unitTestRemoveElementAtIndex(stringList, pointList);
    }


    @Test
    void testRemoveAll() {
        SinglyLinkedList<Point> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<Point> list2 = new SinglyLinkedList<>();

        assertEquals(0, list1.size());

        JUNIT02QQListTest.unitTestRemoveAllListElements(list1, list2);
    }


    @Test
    void testSet() {
        JUNIT02QQListTest.unitTestSetElement(stringList, pointList);
    }


    @Test
    void testMinCapacity() {
        assertEquals(8, stringList.size());
        assertEquals(8, pointList.size());
    }


    @Test
    void testToString() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        JUNIT02QQListTest.unitTestListOutputToReadableString(list);
    }


}

