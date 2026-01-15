package junits;

import construction.Rectangle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*******************************************************************************
 * This Test shows results of comparing Rectangle and Rectangle objects
 * using algorithms from TModule.
 *******************************************************************************/

public class JUNIT01QQRectangleTest {


    public List<Rectangle> makeList(){
        System.out.println();
        System.out.println();
        List<Rectangle> list = new ArrayList<>();
        list.add(new Rectangle(6, 5));
        list.add(new Rectangle(8, 6));
        list.add(new Rectangle(3, 7));
        list.add(new Rectangle(7, 9));
        list.add(new Rectangle(2, 5));
        list.add(new Rectangle(5, 4));
        list.add(new Rectangle(8, 3));
        list.add(new Rectangle(1, 8));
        list.add(new Rectangle(7, 2));
        list.add(new Rectangle(4, 8));
        return list;
    }

    
    /**********************************************************************
     * Test method for {@link construction.Rectangle#compareTo(Rectangle)} .
     **********************************************************************/
    @Test
    void testCompareToRectangle() {

        List<Rectangle> list = makeList();

        System.out.println("============= B E F O R E    S O R T I N G ===========");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }
        System.out.println();

        System.out.println("========== N A T U R A L   O R D E R I N G ===========");
        sort(list);

        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i));
        }

        testNaturalOrderList(list);
    }

    /************************************************************************************
     * Test method for {@link construction.Rectangle#compareAreas(Rectangle, Rectangle)}.
     * Test to compare the rectangles using Area Comparator ordering rules
     ************************************************************************************/
    @Test
    void testCompareRectangleAreas() {

        List<Rectangle> list = makeList();

        System.out.println("============= B E F O R E     A R E A     S O R T I N G ===========");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }

        System.out.println();
        System.out.println("============= O R D E R   B Y   A R E A  =============");
        list.sort(Rectangle::compareAreas);

        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i) + ": " + list.get(i).area());
        }

        testOrderedAreaList(list);
    }

    /****************************************************************************************
     * Test method for {@link construction.Rectangle#comparePerimeters(Rectangle, Rectangle)}.
     * Test to compare the rectangles using Perimeter Comparator ordering rules
     ****************************************************************************************/
    @Test
    void testCompareRectanglePerimeters() {

        List<Rectangle> list = makeList();

        System.out.println("============= B E F O R E   P E R I M E T E R    S O R T I N G ===========");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }


        System.out.println();
        System.out.println("============= O R D E R   B Y   P E R I M E T E R  =============");
        list.sort(Rectangle::comparePerimeters);


        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i) + ": " + list.get(i).perimeter());
        }

        testOrderedPerimeterList(list);
    }


    void testNaturalOrderList(List<Rectangle> list) {
        assertEquals(new Rectangle(1, 8), list.get(0));
        assertEquals(new Rectangle(2, 5), list.get(1));
        assertEquals(new Rectangle(3, 7), list.get(2));
        assertEquals(new Rectangle(4, 8), list.get(3));
        assertEquals(new Rectangle(5, 4), list.get(4));
        assertEquals(new Rectangle(6, 5), list.get(5));
        assertEquals(new Rectangle(7, 2), list.get(6));
        assertEquals(new Rectangle(7, 9), list.get(7));
        assertEquals(new Rectangle(8, 3), list.get(8));
        assertEquals(new Rectangle(8, 6), list.get(9));
    }


    void testOrderedAreaList(List<Rectangle> list) {
        assertEquals(new Rectangle(1, 8), list.get(0));
        assertEquals(new Rectangle(2, 5), list.get(1));
        assertEquals(new Rectangle(7, 2), list.get(2));
        assertEquals(new Rectangle(5, 4), list.get(3));
        assertEquals(new Rectangle(3, 7), list.get(4));
        assertEquals(new Rectangle(8, 3), list.get(5));
        assertEquals(new Rectangle(6, 5), list.get(6));
        assertEquals(new Rectangle(4, 8), list.get(7));
        assertEquals(new Rectangle(8, 6), list.get(8));
        assertEquals(new Rectangle(7, 9), list.get(9));
    }

    void testOrderedPerimeterList(List<Rectangle> list) {
        assertEquals(new Rectangle(2, 5), list.get(0));
        assertEquals(new Rectangle(1, 8), list.get(1));
        assertEquals(new Rectangle(5, 4), list.get(2));
        assertEquals(new Rectangle(7, 2), list.get(3));
        assertEquals(new Rectangle(3, 7), list.get(4));
        assertEquals(new Rectangle(6, 5), list.get(5));
        assertEquals(new Rectangle(8, 3), list.get(6));
        assertEquals(new Rectangle(4, 8), list.get(7));
        assertEquals(new Rectangle(8, 6), list.get(8));
        assertEquals(new Rectangle(7, 9), list.get(9));
    }


}
