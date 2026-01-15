//package junits;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import construction.Point;
//import utils.List;
//
//
//public class JUNIT02QQListTest {
//
//
//    static void unitTestAddPointElement(List<Point> list) {
//        assertEquals(0, list.size());
//        assertTrue(list.add(new Point(1, 0)));   //0
//        assertTrue(list.add(new Point(2, 0)));   //1
//        assertTrue(list.add(new Point(3, 0)));   //2
//        assertTrue(list.add(new Point(4, 0)));   //3
//        assertTrue(list.add(new Point(5, 0)));   //4
//
//        assertTrue(list.add(new Point(1, 1)));   //5
//        assertTrue(list.add(new Point(2, 1)));   //6
//        assertTrue(list.add(new Point(3, 1)));   //7
//    }
//
//
//    static void unitTestAddStringElement(List<String> list) {
//        boolean value1 = list.add("Un");            //0
//        boolean value2 = list.add("Deux");          //1
//        boolean value3 = list.add("Trois");         //2
//        boolean value4 = list.add("Quatre");        //3
//        boolean value5 = list.add("Cinq");          //4
//        boolean value6 = list.add("Six");           //5
//        boolean value7 = list.add("Sept");          //6
//        boolean value8 = list.add("Huit");          //7
//
//        assertTrue(value1);       //0
//        assertTrue(value2);       //1
//        assertTrue(value3);       //2
//        assertTrue(value4);       //3
//        assertTrue(value5);       //4
//        assertTrue(value6);       //5
//        assertTrue(value7);       //6
//        assertTrue(value8);       //7
//    }
//
//
//    static void unitTestAddPointExpansion(List<Point> list) {
//        unitTestAddPointElement(list);
//        assertTrue(list.add(new Point(4, 1)));   //8
//        assertTrue(list.add(new Point(5, 1)));   //9
//
//        System.out.println();
//        System.out.println();
//        System.out.println("\t\t P  O  I  N  T  \t  L  I  S  T  ");
//        System.out.println();
//        System.out.println("No. of elements: " + list.size());
//        System.out.println();
//        System.out.println(list);
//        System.out.println();
//        System.out.println();
//        System.out.println("======= E  X  P  A  N  D   S  \t  H  E  R  E  =======");
//        assertTrue(list.add(new Point(0, 3)));   //10
//        assertTrue(list.add(new Point(1, 3)));   //11
//        assertTrue(list.add(new Point(3, 3)));   //12
//        System.out.println();
//        System.out.println();
//        System.out.println(list);
//        System.out.println();
//        System.out.println();
//    }
//
//
//    static void unitTestAddElemExpand(List<String> stringList, List<Point> pointList) {
//        System.out.println("==  T  E  S  T  I  N  G      E  X  P  A  N  D     C  A  P  A  C  I  T  Y ==");
//        System.out.println();
//        System.out.println("Should expand beyond this point or will CRASH");
//        System.out.println(stringList);
//
//        assertTrue(stringList.add("Neuf"));               //8
//        assertTrue(stringList.add("Dix"));                //9
//        assertTrue(stringList.add("Onze"));               //10
//        assertTrue(stringList.add("Douze"));              //11
//        assertTrue(stringList.add("Treize"));             //12
//        assertTrue(stringList.add("Quatorze"));           //13
//        assertTrue(stringList.add("Quinze"));             //14
//        assertEquals(15, stringList.size());
//
//        assertTrue(pointList.add(new Point(4, 1)));   //8
//        assertTrue(pointList.add(new Point(5, 1)));   //9
//        assertEquals(10, pointList.size());
//
//        assertTrue(pointList.add(new Point(3, 2)));   //10
//        assertTrue(pointList.add(new Point(3, 4)));   //11
//        assertTrue(pointList.add(new Point(3, 6)));   //12
//        assertTrue(pointList.add(new Point(3, 8)));   //13
//        assertTrue(pointList.add(new Point(3, 0)));   //14
//        assertEquals(15, pointList.size());
//    }
//
//
//    static void unitTestAddInsertElement(List<String> stringList, List<Point> pointList) {
//        System.out.println("--------------- ADD IN FRONT ---------------");
//        stringList.add(0, "Twee");                           //0
//        stringList.add(0, "Twee");                           //0
//        pointList.add(0, new Point(8, 8));                   //0
//        pointList.add(0, new Point(8, 8));                   //0
//
//        // TEST - RESULTS
//        assertEquals("Twee" , stringList.get(0));
//        assertEquals("Twee" , stringList.get(1));
//
//        assertEquals(new Point(8, 8) , pointList.get(0));
//        assertEquals(new Point(8, 8) , pointList.get(1));
//
//        System.out.println();
//        System.out.println(stringList);
//        System.out.println();
//        System.out.println(pointList);
//        System.out.println();
//
//        System.out.println("--------------- ADD IN MIDDLE ---------------");
//        int mid = stringList.size() / 2;
//        System.out.println("In Middle: " + mid);
//
//        stringList.add(mid, "Twee");                                //5
//        stringList.add(mid, "Twee");                                //6
//        pointList.add(mid, new Point(8, 8));                        //5
//        pointList.add(mid, new Point(8, 8));                        //6
//
//        assertEquals("Twee" , stringList.get(mid));
//        assertEquals("Twee" , stringList.get(mid + 1));
//
//        assertEquals(new Point(8, 8) , pointList.get(mid + 1));
//        assertEquals(new Point(8, 8) , pointList.get(mid + 1));
//
//        System.out.println();
//        System.out.println(stringList);
//        System.out.println();
//        System.out.println(pointList);
//        System.out.println();
//
//        System.out.println("--------------- ADD AT END ---------------");
//        stringList.add(stringList.size(), "Twee");                  //9
//        stringList.add(stringList.size(), "Twee");                  //10
//        pointList.add(pointList.size(), new Point(8, 8));           //9
//        pointList.add(pointList.size(), new Point(8, 8));           //10
//
//        assertEquals(new Point(8, 8) , pointList.get(pointList.size() - 1));
//
//        assertEquals("Twee" , stringList.get(stringList.size() - 1));
//
//        System.out.println();
//        System.out.println(stringList);
//        System.out.println("size: " + stringList.size());
//        System.out.println();
//        System.out.println(pointList);
//        System.out.println("size: " + pointList.size());
//
//        int sizeA = -stringList.size() + 1;
//        int sizeB = stringList.size() + 1;
//
//        //TEST INDEX OUT OF BOUNDS
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.add(sizeA, "Trois"));
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.add(sizeB, "Trois"));
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.add(-1, "Trois"));
//        System.out.println();
//
//    }
//
//
//    static void unitTestAddListElements(List<Integer> list03, List<Integer> list04) {
//        assertEquals(10, list03.size());
//        assertEquals(10, list04.size());
//
//        System.out.println();
//        System.out.println();
//        System.out.println(list03);
//        System.out.println(list04);
//        System.out.println();
//        System.out.println();
//    }
//
//
//    static void unitTestAddAllList(List<Point> list, int start) {
//        assertEquals(new Point(0, 1), list.get(start));
//        assertEquals(new Point(0, 2), list.get(start + 1));
//        assertEquals(new Point(0, 3), list.get(start + 2));
//        assertEquals(new Point(0, 4), list.get(start + 3));
//        assertEquals(new Point(0, 5), list.get(start + 4));
//    }
//
//
//    static void unitTestClearList(List<String> stringList, List<Point> pointList) {
//
//        assertEquals(8, stringList.size());
//        stringList.clear();
//        assertEquals(0, stringList.size());
//
//        System.out.println("size AFTER: " + stringList.size());
//        System.out.println();
//
//        assertEquals(8, pointList.size());
//        pointList.clear();
//        assertEquals(0, pointList.size());
//
//        System.out.println("size AFTER: " + pointList.size());
//        System.out.println();
//
//        //TEST IF EMPTY
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(0));
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(stringList.size()));
//        System.out.println();
//        assertThrows(IndexOutOfBoundsException.class, () -> pointList.get(0));
//        assertThrows(IndexOutOfBoundsException.class, () -> pointList.get(pointList.size()));
//        System.out.println();
//    }
//
//
//    static void unitTestContainsElement(List<String> stringList, List<Point> pointList) {
//        printIndex(pointList.size());
//        System.out.println(pointList);
//        System.out.println();
//
//        System.out.println("has Un? "   + stringList.contains("Un"));
//        System.out.println("has Cinq? " + stringList.contains("Cinq"));
//        System.out.println("has Onze? " + stringList.contains("Onze"));
//        System.out.println("has Douze?" + stringList.contains("Douze"));
//
//        assertTrue(stringList.contains("Un"));
//        assertTrue(stringList.contains("Cinq"));
//        assertFalse(stringList.contains("Onze"));
//        assertFalse(stringList.contains("Douze"));
//        System.out.println();
//        System.out.println();
//
//        //SEARCH AND FIND
//        assertTrue(pointList.contains(new Point(1, 1)));
//        assertTrue(pointList.contains(new Point(2, 1)));
//        assertTrue(pointList.contains(new Point(3, 1)));
//        assertFalse(pointList.contains(new Point(1, 2)));
//
//        // PRINT SEARCH
//        System.out.println("contains (1, 1)? " + pointList.contains(new Point(1, 1)));
//        System.out.println("contains (2, 1)? " + pointList.contains(new Point(2, 1)));
//        System.out.println("contains (1, 0)? " + pointList.contains(new Point(1, 0)));
//        System.out.println("contains (2, 0)? " + pointList.contains(new Point(2, 0)));
//        System.out.println("contains (9, 3)? " + pointList.contains(new Point(9, 3)));
//        System.out.println();
//    }
//
//
//    static void unitTestEqualListElements(List<Point> list1, List<Point> list2, List<Point> list3) {
//        assertEquals(list1     , list2);
//        assertNotEquals(list1  , list3);
//        assertNotEquals(list2  , list3);
//
//        assertEquals(list1.size()     , list2.size());
//        assertNotEquals(list2.size()  , list3.size());
//
//        assertEquals(list1.get(0), list2.get(0));
//        assertEquals(list1.get(1), list2.get(1));
//        assertEquals(list1.get(2), list2.get(2));
//        assertEquals(list1.get(3), list2.get(3));
//        assertEquals(list1.get(4), list2.get(4));
//        assertEquals(list1.get(5), list2.get(5));
//        assertEquals(list1.get(6), list2.get(6));
//        assertEquals(list1.get(7), list2.get(7));
//
//        assertNotEquals(list2.get(0), list3.get(0));
//        assertNotEquals(list2.get(1), list3.get(1));
//        assertNotEquals(list2.get(2), list3.get(2));
//        assertNotEquals(list2.get(3), list3.get(3));
//        assertNotEquals(list2.get(4), list3.get(4));
//        assertNotEquals(list2.get(5), list3.get(5));
//    }
//
//
//    static void unitTestGetElementAtIndex(List<String> stringList, List<Point> pointList) {
//        assertEquals("Un"       , stringList.get(0));
//        assertEquals("Deux"     , stringList.get(1));
//        assertEquals("Trois"    , stringList.get(2));
//        assertEquals("Quatre"   , stringList.get(3));
//        assertEquals("Cinq"     , stringList.get(4));
//        assertEquals("Six"      , stringList.get(5));
//        assertEquals("Sept"     , stringList.get(6));
//        assertEquals("Huit"     , stringList.get(7));
//
//        assertEquals(new Point(1, 0), pointList.get(0));
//        assertEquals(new Point(2, 0), pointList.get(1));
//        assertEquals(new Point(3, 0), pointList.get(2));
//        assertEquals(new Point(4, 0), pointList.get(3));
//        assertEquals(new Point(5, 0), pointList.get(4));
//        assertEquals(new Point(1, 1), pointList.get(5));
//        assertEquals(new Point(2, 1), pointList.get(6));
//        assertEquals(new Point(3, 1), pointList.get(7));
//
//        //Test if accessing index out of bounds.
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(stringList.size()));
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(-stringList.size() + 1));
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(pointList.size() + 1));
//        System.out.println();
//    }
//
//
//    static void unitTestGetIndexOfElement(List<String> stringList, List<Point> pointList) {
//        assertEquals(-1, stringList.indexOf("Onze"));
//        assertEquals(-1, stringList.indexOf("Douze"));
//
//        printIndex(stringList.size());
//        System.out.println(stringList);
//        System.out.println();
//
//        System.out.println("location of Un:   "  + stringList.indexOf("Un"));
//        System.out.println("location of Cinq: "  + stringList.indexOf("Quatre"));
//        System.out.println("location of Dix:  "  + stringList.indexOf("Sept"));
//        System.out.println();
//
//
//        printIndex(pointList.size());
//        System.out.println(pointList);
//        System.out.println();
//        System.out.println();
//
//        assertEquals(0, pointList.indexOf(new Point(1, 0)));
//        assertEquals(3, pointList.indexOf(new Point(4, 0)));
//        assertEquals(6, pointList.indexOf(new Point(2, 1)));
//        assertEquals(-1, pointList.indexOf(new Point(3, 5)));
//        assertEquals(-1, pointList.indexOf(new Point(5, 3)));
//
//        System.out.println("contains (1, 1)? " + pointList.indexOf(new Point(1, 1)));
//        System.out.println("contains (2, 1)? " + pointList.indexOf(new Point(2, 1)));
//        System.out.println("contains (1, 0)? " + pointList.indexOf(new Point(1, 0)));
//        System.out.println("contains (2, 0)? " + pointList.indexOf(new Point(2, 0)));
//        System.out.println("contains (9, 3)? " + pointList.indexOf(new Point(9, 3)));
//        System.out.println();
//
//    }
//
//
//    static void unitTestIsEmptyList(List<String> list) {
//        System.out.println();
//        System.out.println("-------------- T  E  S  T  I  N  G    IS EMPTY() --------------");
//        list.add(0,"Un");
//        assertEquals(1, list.size());
//        list.add(1,"Deux");
//        assertEquals(2, list.size());
//        list.add(2,"Cinq");
//        assertEquals(3, list.size());
//        list.add(3,"Quatre");
//        assertEquals(4, list.size());
//        list.add(4,"Sept");
//        assertEquals(5, list.size());
//        list.add(5,"Six");
//        assertEquals(6, list.size());
//
//        System.out.println();
//        System.out.println("------------ C  L  E  A  R  ------------");
//        list.clear();
//
//        System.out.println(list);
//        System.out.println();
//
//        assertTrue(list.isEmpty());
//        assertEquals(0, list.size());
//
//    }
//
//
//    static void unitTestRemoveElement(List<String> stringList, List<Point> pointList) {
//        System.out.println("--------------  T  E  S  T  I  N  G    REMOVE FROM MIDDLE ----------------");
//        System.out.println();
//        System.out.println(stringList);
//        assertTrue(stringList.remove(("Quatre")));
//        System.out.println(stringList);
//        System.out.println();
//        System.out.println();
//        System.out.println(pointList);
//        assertTrue(pointList.remove(new Point(4, 0)));
//        System.out.println(pointList);
//        System.out.println();
//        System.out.println();
//
//        System.out.println("----------------  T  E  S  T  I  N  G   REMOVE FROM FRONT ----------------");
//        System.out.println(stringList);
//        assertTrue(stringList.remove("Deux"));
//        System.out.println(stringList);
//        System.out.println();
//        System.out.println();
//
//        System.out.println(pointList);
//        assertTrue(pointList.remove(new Point(1, 0)));
//        System.out.println(pointList);
//        assertTrue( pointList.remove(new Point(1, 1)));
//        System.out.println(pointList);
//        System.out.println();
//        System.out.println();
//
//        System.out.println("----------------  T  E  S  T  I  N  G    REMOVE FROM BACK ----------------");
//        assertTrue(stringList.remove("Huit"));
//        System.out.println(stringList);
//        assertTrue(stringList.remove("Sept"));
//        System.out.println(stringList);
//        System.out.println();
//        System.out.println();
//
//        System.out.println(pointList);
//        assertTrue(pointList.remove(new Point(3, 1)));
//        System.out.println(pointList);
//        assertTrue(pointList.remove(new Point(2, 1)));
//        System.out.println(pointList);
//        System.out.println();
//        System.out.println();
//
//        assertEquals(4, stringList.size());
//        assertEquals(3, pointList.size());
//    }
//
//
//    static void unitTestRemoveElementAtIndex(List<String> stringList, List<Point> pointList) {
//        System.out.println("--------------  T  E  S  T  I  N  G    REMOVE FROM MIDDLE ----------------");
//        System.out.println();
//        System.out.println(stringList);
//        assertEquals("Quatre", stringList.remove((stringList.size() - 1) / 2));
//        System.out.println(stringList);
//        System.out.println();
//        System.out.println();
//        System.out.println(pointList);
//        assertEquals(new Point(4, 0), pointList.remove((pointList.size() - 1) / 2));
//        System.out.println(pointList);
//        System.out.println();
//        System.out.println();
//
//        System.out.println("----------------  T  E  S  T  I  N  G   REMOVE FROM FRONT ----------------");
//        assertEquals("Un"   , stringList.remove(0));
//        System.out.println(stringList);
//        assertEquals("Deux" , stringList.remove(0));
//        System.out.println(stringList);
//        System.out.println();
//        System.out.println();
//
//        System.out.println(pointList);
//        assertEquals(new Point(1, 0), pointList.remove(0));
//        System.out.println(pointList);
//        assertEquals(new Point(2, 0), pointList.remove(0));
//        System.out.println(pointList);
//        System.out.println();
//        System.out.println();
//
//        System.out.println("----------------  T  E  S  T  I  N  G    REMOVE FROM BACK ----------------");
//        assertEquals("Huit", stringList.remove(stringList.size() - 1));
//        System.out.println(stringList);
//        assertEquals("Sept", stringList.remove(stringList.size() - 1));
//        System.out.println(stringList);
//        System.out.println();
//        System.out.println();
//
//        System.out.println(pointList);
//        System.out.println(pointList);
//        assertEquals(new Point(3, 1), pointList.remove(pointList.size() - 1));
//        System.out.println(pointList);
//        assertEquals(new Point(2, 1), pointList.remove(pointList.size() - 1));
//        System.out.println(pointList);
//        System.out.println();
//        System.out.println();
//
//        //Test FOR INDEX OUT OF BOUNDS
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.remove(stringList.size()));
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.remove(-stringList.size() + 1));
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.remove(stringList.size() + 2));
//        assertThrows(IndexOutOfBoundsException.class, () -> pointList.remove(pointList.size()));
//        assertThrows(IndexOutOfBoundsException.class, () -> pointList.remove(-1));
//    }
//
//
//    static void unitTestRemoveAllListElements(List<Point> list1, List<Point> list2) {
//        list1.add(new Point(0, 1));            //0
//        list1.add(new Point(0, 2));            //1
//        list1.add(new Point(0, 3));            //2
//        list1.add(new Point(0, 4));            //3
//        list1.add(new Point(0, 5));            //4
//        list1.add(new Point(0, 6));            //5
//        list1.add(new Point(0, 7));            //6
//        list1.add(new Point(0, 8));            //7
//        list1.add(new Point(0, 9));            //8
//
//        list2.add(new Point(0, 1));            //0
//        list2.add(new Point(0, 3));            //1
//        list2.add(new Point(0, 5));            //2
//        list2.add(new Point(0, 7));            //3
//        list2.add(new Point(0, 9));            //4
//
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println();
//
//        assertTrue(list1.removeAll(list2));
//
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println();
//
//        assertEquals(new Point(0, 2) , list1.get(0));  //0
//        assertEquals(new Point(0, 4) , list1.get(1));  //1
//        assertEquals(new Point(0, 6) , list1.get(2));  //2
//        assertEquals(new Point(0, 8) , list1.get(3));  //3
//
//        assertEquals(4, list1.size());
//
//    }
//
//
//    static void unitTestSetElement(List<String> stringList, List<Point> pointList) {
//        // SET AT FRONT
//        System.out.println("--------------  T  E  S  T     S  E  T    F  R  O  N  T ----------------");
//        assertEquals("Un"     , stringList.set(0, "Twee"));
//        assertEquals(new Point(1, 0), pointList.set(0, new Point(8, 8)));
//        System.out.println();
//        System.out.println(stringList);
//        System.out.println();
//        System.out.println(pointList);
//        System.out.println();
//        System.out.println();
//
//        // SET MIDDLE
//        System.out.println("--------------  T  E  S  T     S  E  T    M  I  D  D  L  E ----------------");
//        assertEquals("Quatre" , stringList.set((stringList.size() - 1) / 2, "Twee"));
//        assertEquals(new Point(4, 0), pointList.set((pointList.size() - 1) / 2, new Point(8, 8)));
//        System.out.println();
//        System.out.println(stringList);
//        System.out.println();
//        System.out.println(pointList);
//        System.out.println();
//        System.out.println();
//
//        //SET AT BACK
//        System.out.println("--------------  T  E  S  T     S  E  T    B  A  C  K ----------------");
//        assertEquals("Huit", stringList.set(stringList.size() - 1, "Twee"));
//        assertEquals(new Point(3, 1), pointList.set(pointList.size() - 1, new Point(8, 8)));
//        System.out.println();
//        System.out.println(stringList);
//        System.out.println();
//        System.out.println(pointList);
//        System.out.println();
//
//        //TEST FOR INDEX OUT OF BOUNDS.
//        int sizeA = -(stringList.size() + 1);
//        int sizeB = stringList.size();
//        int sizeC = stringList.size() + 2;
//        int sizeD = pointList.size();
//        Point p1  = new Point(1, 2);
//
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.set(sizeA, "Trois"));
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.set(sizeB, "Trois"));
//        assertThrows(IndexOutOfBoundsException.class, () -> stringList.set(sizeC + 2, "Trois"));
//        assertThrows(IndexOutOfBoundsException.class, () -> pointList.set(sizeD, p1));
//        assertThrows(IndexOutOfBoundsException.class, () -> pointList.set(-1, p1));
//        System.out.println();
//        System.out.println();
//
//    }
//
//
//    static void unitTestListOutputToReadableString(List<String> list) {
//        String[] expected = new String[12];
//        expected[0]     = "[]";
//        expected[1]     = "[Un]";
//        expected[2]     = "[Un, Deux]";
//        expected[3]     = "[Un, Deux, Trois]";
//        expected[4]     = "[Un, Deux, Trois, Quatre]";
//        expected[5]     = "[Un, Deux, Trois, Quatre, Cinq]";
//        expected[6]     = "[Un, Deux, Trois, Quatre, Cinq, Six]";
//        expected[7]     = "[Un, Deux, Trois, Quatre, Cinq, Six, Sept]";
//        expected[8]     = "[Un, Deux, Trois, Quatre, Cinq, Six, Sept, Huit]";
//
//        System.out.println("**********\t T  E  S  T  I  N  G      S  I  Z  E \t**********");
//        assertEquals(expected[0], list.toString());
//        System.out.println(list);
//
//        assertTrue(list.add("Un"));
//        assertEquals(expected[1], list.toString());
//        System.out.println(list);
//
//        assertTrue(list.add("Deux"));
//        assertEquals(expected[2], list.toString());
//        System.out.println(list);
//
//        assertTrue(list.add("Trois"));
//        assertEquals(expected[3], list.toString());
//        System.out.println(list);
//
//        assertTrue(list.add("Quatre"));
//        assertEquals(expected[4], list.toString());
//        System.out.println(list);
//
//        assertTrue(list.add("Cinq"));
//        assertEquals(expected[5], list.toString());
//        System.out.println(list);
//
//        assertTrue(list.add("Six"));
//        assertEquals(expected[6], list.toString());
//        System.out.println(list);
//
//        assertTrue(list.add("Sept"));
//        assertEquals(expected[7], list.toString());
//        System.out.println(list);
//
//        assertTrue(list.add("Huit"));
//        assertEquals(expected[8], list.toString());
//        System.out.println(list);
//
//        System.out.println();
//    }
//
//
//    static void makeEqualPointList(List<Point> list) {
//        list.add(new Point(2, 0));                //0
//        list.add(new Point(2, 1));                //1
//        list.add(new Point(2, 2));                //2
//        list.add(new Point(2, 3));                //3
//        list.add(new Point(2, 4));                //4
//        list.add(new Point(2, 5));                //5
//        list.add(new Point(2, 6));                //6
//        list.add(new Point(2, 7));                //7
//
//        System.out.println();
//        System.out.println(list);
//    }
//
//
//    static void makeNotEqualPointList(List<Point> list) {
//        list.add(new Point(3, 0));                //0
//        list.add(new Point(3, 1));                //1
//        list.add(new Point(3, 2));                //2
//        list.add(new Point(3, 3));                //3
//        list.add(new Point(3, 4));                //4
//        list.add(new Point(3, 5));                //5
//
//        System.out.println();
//        System.out.println(list);
//    }
//
//
//    static void makeIntegerList(List<Integer> list) {
//        assertEquals(0, list.size());
//        assertTrue(list.add(2));                  // 0
//        assertTrue(list.add(4));                  // 1
//        assertTrue(list.add(8));                  // 2
//        assertTrue(list.add(16));                 // 3
//        assertTrue(list.add(32));                 // 4
//        assertTrue(list.add(64));                 // 5
//        assertTrue(list.add(128));                // 6
//        assertTrue(list.add(256));                // 7
//        assertTrue(list.add(512));                // 8
//        assertTrue(list.add(1024));               // 9
//
//        System.out.println();
//        System.out.println(list);
//    }
//
//
//    static void makePointElemStartList(List<Point> list) {
//        list.add(new Point(1, 0));                //0
//        list.add(new Point(2, 0));                //1
//        list.add(new Point(3, 0));                //2
//        list.add(new Point(4, 0));                //3
//        list.add(new Point(5, 0));                //4
//        list.add(new Point(6, 0));                //5
//        list.add(new Point(7, 0));                //6
//        System.out.println();
//        System.out.println(list);
//    }
//
//
//    static void makePointElemCopyList(List<Point> list) {
//        list.add(new Point(0, 1));                //0
//        list.add(new Point(0, 2));                //1
//        list.add(new Point(0, 3));                //2
//        list.add(new Point(0, 4));                //3
//        list.add(new Point(0, 5));                //4
//        System.out.println();
//        System.out.println(list);
//    }
//
//    // NON-TEST : PRINTS INDEX WITH SPACING
//    static void printIndex(int size){
//        System.out.print("     0" );
//        for (int i = 1; i < size; i++)
//            System.out.print("       " + i);
//        System.out.println();
//    }
//
//
//}
