package junits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import construction.Point;
import utils.ArrayList;

/**
 * @author A. Ford
 * This is a JUnit Test for the utils.ArrayList Class
 * This class uses the Jupiter JUnit Test Library
 * current version is Jupiter 5.8.1
 */
public class JUNIT03QQArrayListTest {

    ArrayList<String>    stringList;
    ArrayList<Point>     pointList;

    @BeforeEach
    void testArrayList() {
        stringList = new ArrayList<>();
        pointList = new ArrayList<>();
        JUNIT02QQListTest.unitTestAddStringElement(stringList);
        JUNIT02QQListTest.unitTestAddPointElement(pointList);
        assertEquals(stringList.size(), pointList.size());
    }


    @Test
    void testArrayListInt() {
        ArrayList<Point> list = new ArrayList<>(8);
        assertEquals(0, list.size());
        JUNIT02QQListTest.unitTestAddPointExpansion(list);
    }


    @Test
    void testArrayListListE() {
        ArrayList<Integer> list01 = new ArrayList<>();
        JUNIT02QQListTest.makeIntegerList(list01);

        ArrayList<Integer> list02 = new ArrayList<>(list01);
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

        ArrayList<Point> list01 = new ArrayList<>();
        assertEquals(0, list01.size());

        JUNIT02QQListTest.makePointElemStartList(list01);
        assertEquals(7, list01.size());

        int start = list01.size();

        ArrayList<Point>  list02 = new ArrayList<>();
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
    void testCheckCapacity() {
        ArrayList<Integer> list = new ArrayList<>();

        assertTrue(list.add(0));                //0
        assertTrue(list.add(1));                //1
        assertTrue(list.add(2));                //2
        assertTrue(list.add(3));                //3
        assertTrue(list.add(4));                //4
        assertTrue(list.add(5));                //5
        assertTrue(list.add(6));                //6
        assertTrue(list.add(7));                //7
        assertTrue(list.add(8));                //8
        assertTrue(list.add(9));                //9

        System.out.println("=======\t AT CAPACITY --> REACHED LIST DEFAULT LIMIT");
        System.out.println("=======\t Should expand beyond this point or will CRASH");

        assertTrue(list.add(10));               //10
        assertTrue(list.add(11));               //11
        assertTrue(list.add(12));               //12
        assertTrue(list.add(13));               //13
        assertTrue(list.add(14));               //14
        assertTrue(list.add(15));               //15
        assertTrue(list.add(16));               //16
        assertTrue(list.add(17));               //17
        assertTrue(list.add(18));               //18
        assertTrue(list.add(19));               //19

        // EXPANSION TEST
        int size        = list.size();
        int minCapacity = 90;
        int value;

        //NOTE: THIS SETS THE UNDERLYING ARRAY CAPACITY NOT THE LIST SIZE
        list.checkCapacity(minCapacity);

        assertEquals(20, list.size());

        for (int count = list.size(); count < minCapacity; count++) {
            value = size + count;
            assertTrue(list.add(value));
        }

        assertEquals(minCapacity, list.size());
    }


    @Test
    void testEqualsListE() {
        ArrayList<Point> list1 = new ArrayList<>();
        ArrayList<Point> list2 = new ArrayList<>();
        ArrayList<Point> list3 = new ArrayList<>();

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

        ArrayList<String> list = new ArrayList<>();

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
        ArrayList<Point> list1 = new ArrayList<>();
        ArrayList<Point> list2 = new ArrayList<>();

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
        ArrayList<String> list = new ArrayList<>();
        JUNIT02QQListTest.unitTestListOutputToReadableString(list);
    }


}

