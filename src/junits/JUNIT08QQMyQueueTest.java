package junits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import utils.MyQueue;

import java.util.NoSuchElementException;

/**
 * @author A. Ford
 * This is a JUnit Test for the utils.MyQueue Class
 * This class uses the Jupiter JUnit Test Library
 * current version is Jupiter 5.8.1
 */
public class JUNIT08QQMyQueueTest {
    MyQueue<String> queue;

    @BeforeEach
    void testMyQueue() {
        queue = new MyQueue<>();
    }

    @Test
    void testAdd() {
        makeQueueElements(queue);
    }


    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
        makeQueueElements(queue);
        assertFalse(queue.isEmpty());
    }


    @Test
    void testPeekE() {
        makeQueueElements(queue);

        System.out.println(queue);
        assertEquals("Red"      , queue.peek());
        assertEquals("Red"      , queue.remove());
        assertEquals("Orange"   , queue.peek());
        assertEquals("Orange"   , queue.remove());
        assertEquals("Yellow"   , queue.peek());
        assertEquals("Yellow"   , queue.remove());
        System.out.println(queue);

        assertEquals("Green"    , queue.remove());
        assertEquals("Blue"     , queue.remove());
        assertEquals("Indigo"   , queue.remove());
        assertEquals("Violet"   , queue.remove());

        //Test for an Empty Queue
        assertNull(queue.peek());
        System.out.println();
    }


    @Test
    void testRemoveE() {
        makeQueueElements(queue);
        removeQueueElements(queue);
    }


    @Test
    void testSize() {
        assertEquals(0, queue.size());
        makeQueueElements(queue);
        assertEquals(7, queue.size());
    }


    @Test
    void testToString() {
        makeQueueElements(queue);

        System.out.println();
        System.out.println();
        System.out.println("==== T  E  S  T      F  I  F  O ===");
        System.out.println();

        String value = "[Red, Orange, Yellow, Green, Blue, Indigo, Violet]";
        assertEquals(value , queue.toString());

        System.out.println(queue);
        assertEquals("Red", queue.remove());
        assertEquals("[Orange, Yellow, Green, Blue, Indigo, Violet]" , queue.toString());

        System.out.println(queue);
        assertEquals("Orange", queue.remove());
        assertEquals("[Yellow, Green, Blue, Indigo, Violet]" , queue.toString());

        System.out.println(queue);
        assertEquals("Yellow"  , queue.remove());
        assertEquals("[Green, Blue, Indigo, Violet]" , queue.toString());

        System.out.println(queue);
        assertEquals("Green" , queue.remove());
        assertEquals("[Blue, Indigo, Violet]" , queue.toString());

        System.out.println(queue);
        assertEquals("Blue", queue.remove());
        assertEquals("[Indigo, Violet]" , queue.toString());

        System.out.println(queue);
        assertEquals("Indigo"   , queue.remove());
        assertEquals("[Violet]" , queue.toString());

        System.out.println(queue);
        assertEquals("Violet" , queue.remove());
        assertEquals("[]"     , queue.toString());

        System.out.println(queue);
        System.out.println();
    }


    static void makeQueueElements(MyQueue<String> queue) {
        System.out.println();
        System.out.println();
        System.out.println("==== T  E  S  T      A   D   D   ===");
        System.out.println();
        System.out.println(queue);
        assertTrue(queue.add("Red"));
        System.out.println(queue);
        assertTrue(queue.add("Orange"));
        System.out.println(queue);
        assertTrue(queue.add("Yellow"));
        System.out.println(queue);
        assertTrue(queue.add("Green"));
        System.out.println(queue);
        assertTrue(queue.add("Blue"));
        System.out.println(queue);
        assertTrue(queue.add("Indigo"));
        System.out.println(queue);
        assertTrue(queue.add("Violet"));
        System.out.println(queue);
    }


    static void removeQueueElements(MyQueue<String> queue) {
        System.out.println();
        System.out.println();
        System.out.println("==== T  E  S  T      R   E   M   O   V   E   ===");
        System.out.println();
        assertEquals(7, queue.size());
        System.out.println(queue);
        assertEquals("Red"    , queue.remove());
        System.out.println(queue);
        assertEquals("Orange" , queue.remove());
        System.out.println(queue);
        assertEquals("Yellow" , queue.remove());
        System.out.println(queue);
        assertEquals("Green"  , queue.remove());
        System.out.println(queue);
        assertEquals("Blue"   , queue.remove());
        System.out.println(queue);
        assertEquals("Indigo" , queue.remove());
        System.out.println(queue);
        assertEquals("Violet" , queue.remove());
        System.out.println(queue);

        assertEquals(0, queue.size());
        //Throws Exception if Empty.
        assertThrows(NoSuchElementException.class, queue::remove);
        System.out.println();
    }

}
