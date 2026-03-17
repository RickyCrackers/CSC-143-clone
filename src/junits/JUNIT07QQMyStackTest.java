package junits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import utils.MyStack;
import utils.MyQueue;

import java.util.EmptyStackException;

/**
 * @author A. Ford
 * This is a JUnit Test for the utils.MyStack Class
 * This class uses the Jupiter JUnit Test Library
 * current version is Jupiter 5.8.1
 */
public class JUNIT07QQMyStackTest {

    MyStack<String> stack;

    @BeforeEach
    void testMyStack() {
        stack = new MyStack<>();
    }

    @Test
    void testPushE() {
        makeStackElements(stack);
    }


    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
        makeStackElements(stack);
        assertFalse(stack.isEmpty());
    }


    @Test
    void testPeekE() {
        makeStackElements(stack);

        assertEquals("Violet", stack.peek());
        assertEquals("Violet", stack.pop());
        assertEquals("Indigo", stack.peek());
        assertEquals("Indigo", stack.pop());
        assertEquals("Blue"  , stack.peek());
        assertEquals("Blue"  , stack.pop());

        assertEquals("Green" , stack.pop());
        assertEquals("Yellow", stack.pop());
        assertEquals("Orange", stack.pop());
        assertEquals("Red"   , stack.pop());

        assertThrows(EmptyStackException.class, stack::pop);
        System.out.println();
    }


    @Test
    void testPopE() {
        makeStackElements(stack);
        removeStackElements(stack);
    }


    @Test
    void testSize() {
        assertEquals(0, stack.size());
        makeStackElements(stack);
        assertEquals(7, stack.size());
    }


    @Test
    void testToString() {
        makeStackElements(stack);
        System.out.println();
        System.out.println();
        System.out.println("==== T  E  S  T      L  I  F  O ===");
        System.out.println();

        //THIS IS DONE USING FIX (SEE LATER, IF NOT IMPLEMENTED IN THIS LAB)
        String value = "[Red, Orange, Yellow, Green, Blue, Indigo, Violet]";
        assertEquals(value , stack.toString());

        System.out.println(stack);
        assertEquals("Violet", stack.pop());
        assertEquals("[Red, Orange, Yellow, Green, Blue, Indigo]" , stack.toString());

        System.out.println(stack);
        assertEquals("Indigo", stack.pop());
        assertEquals("[Red, Orange, Yellow, Green, Blue]" , stack.toString());

        System.out.println(stack);
        assertEquals("Blue"  , stack.pop());
        assertEquals("[Red, Orange, Yellow, Green]" , stack.toString());

        System.out.println(stack);
        assertEquals("Green" , stack.pop());
        assertEquals("[Red, Orange, Yellow]" , stack.toString());

        System.out.println(stack);
        assertEquals("Yellow", stack.pop());
        assertEquals("[Red, Orange]" , stack.toString());

        System.out.println(stack);
        assertEquals("Orange", stack.pop());
        assertEquals("[Red]" , stack.toString());

        System.out.println(stack);
        assertEquals("Red"   , stack.pop());
        assertEquals("[]" , stack.toString());

        System.out.println(stack);
        System.out.println();
    }


    static void makeStackElements(MyStack<String> stack) {
        System.out.println();
        System.out.println();
        System.out.println("==== T  E  S  T      P   U   S  H   ===");
        System.out.println();
        System.out.println(stack);
        assertEquals("Red"   , stack.push("Red"));
        System.out.println(stack);
        assertEquals("Orange", stack.push("Orange"));
        System.out.println(stack);
        assertEquals("Yellow", stack.push("Yellow"));
        System.out.println(stack);
        assertEquals("Green" , stack.push("Green"));
        System.out.println(stack);
        assertEquals("Blue"  , stack.push("Blue"));
        System.out.println(stack);
        assertEquals("Indigo", stack.push("Indigo"));
        System.out.println(stack);
        assertEquals("Violet", stack.push("Violet"));
        System.out.println(stack);
    }


    static void removeStackElements(MyStack<String> stack) {
        System.out.println();
        System.out.println();
        System.out.println("==== T  E  S  T      P   O   P   ===");
        System.out.println();
        assertEquals(7, stack.size());
        System.out.println(stack);
        assertEquals("Violet", stack.pop());
        System.out.println(stack);
        assertEquals("Indigo", stack.pop());
        System.out.println(stack);
        assertEquals("Blue"  , stack.pop());
        System.out.println(stack);
        assertEquals("Green" , stack.pop());
        System.out.println(stack);
        assertEquals("Yellow", stack.pop());
        System.out.println(stack);
        assertEquals("Orange", stack.pop());
        System.out.println(stack);
        assertEquals("Red"   , stack.pop());
        System.out.println(stack);
        assertEquals(0, stack.size());

        //Throws Exception if Empty.
        assertThrows(EmptyStackException.class, stack::pop);
        System.out.println();
    }

    /**
     * Returns true if the elements in the stack occur in ascending order
     * from top (smallest) to bottom (largest). An empty or single-element
     * stack is considered sorted. Restores the stack to its original state.
     *
     * @param stack the stack of integers to check
     * @return true if the stack is sorted ascending top-to-bottom
     */
    public static boolean isSorted(MyStack<Integer> stack) {

        MyQueue<Integer> queue = new MyQueue<>();

        // Step 1: drain stack into queue (queue holds top→bottom order)
        for (int i = stack.size(); i > 0; i--) {
            queue.add(stack.pop());
        }

        boolean sorted = true;
        Integer prev   = null;

        // Step 2: check ascending and push back into stack (now reversed)
        for (int i = queue.size(); i > 0; i--) {
            Integer current = queue.remove();
            if (prev != null && current < prev) {
                sorted = false;
            }
            prev = current;
            stack.push(current);
        }

        // Step 3: stack is flipped — reverse again through queue to restore
        for (int i = stack.size(); i > 0; i--) {
            queue.add(stack.pop());
        }

        for (int i = queue.size(); i > 0; i--) {
            stack.push(queue.remove());
        }

        return sorted;
    }


    /**
     * Removes and returns the minimum value from the stack.
     * All occurrences of the minimum are removed.
     * Uses a MyQueue object as auxiliary storage.
     *
     * @param stack the stack of integers to remove the minimum from
     * @return the minimum value removed
     */
    public static int removeMin(MyStack<Integer> stack) {

        MyQueue<Integer> queue = new MyQueue<>();

        // Step 1: find the minimum by draining stack into queue
        int min = stack.peek();
        for (int i = stack.size(); i > 0; i--) {
            int val = stack.pop();
            if (val < min) {
                min = val;
            }
            queue.add(val);
        }

        // Step 2: drain queue back into stack, skipping all occurrences of min
        for (int i = queue.size(); i > 0; i--) {
            int val = queue.remove();
            if (val != min) {
                stack.push(val);
            }
        }

        // Step 3: stack is reversed — fix by routing through queue again
        for (int i = stack.size(); i > 0; i--) {
            queue.add(stack.pop());
        }

        for (int i = queue.size(); i > 0; i--) {
            stack.push(queue.remove());
        }

        return min;
    }

    @Test
    void testIsSorted() {
        System.out.println();
        System.out.println("==== T  E  S  T      I  S  S  O  R  T  E  D ===");

        MyStack<Integer> stack = new MyStack<>();

        // Empty stack is sorted
        assertTrue(isSorted(stack));

        // Single element is sorted
        stack.push(5);
        assertTrue(isSorted(stack));
        assertEquals(1, stack.size());
        assertEquals(5, (int) stack.peek());        // still on top after restore

        // Sorted: top=2, bottom=28
        stack = new MyStack<>();
        stack.push(28);
        stack.push(20);
        stack.push(13);
        stack.push(9);
        stack.push(9);
        stack.push(5);
        stack.push(2);
        System.out.println("sorted stack:   " + stack);
        assertTrue(isSorted(stack));
        assertEquals(7, stack.size());
        assertEquals(2, (int) stack.peek());        // top still 2
        assertEquals("[28, 20, 13, 9, 9, 5, 2]", stack.toString()); // fully restored

        // Not sorted
        stack = new MyStack<>();
        stack.push(5);
        stack.push(3);
        stack.push(10);
        System.out.println("unsorted stack: " + stack);
        assertFalse(isSorted(stack));
        assertEquals(3, stack.size());
        assertEquals(10, (int) stack.peek());       // top still 10
        assertEquals("[5, 3, 10]", stack.toString());

        System.out.println("SUCCESS: @END");
    }


    @Test
    void testRemoveMin() {
        System.out.println();
        System.out.println("==== T  E  S  T      R  E  M  O  V  E  M  I  N ===");

        // Example from spec: [24, 15, 38, 4, 11, 6, 18, 12] → removes 4
        MyStack<Integer> stack = new MyStack<>();
        stack.push(24);
        stack.push(15);
        stack.push(38);
        stack.push(4);
        stack.push(11);
        stack.push(6);
        stack.push(18);
        stack.push(12);

        System.out.println("before: " + stack);
        int removed = removeMin(stack);
        System.out.println("after:  " + stack);

        assertEquals(4, removed);
        assertEquals(7, stack.size());
        assertEquals("[24, 15, 38, 11, 6, 18, 12]", stack.toString());

        // Multiple occurrences: [2, 8, 3, 11, 2, 3, 2, 7, 12, 4] → removes all 2s
        stack = new MyStack<>();
        stack.push(2);
        stack.push(8);
        stack.push(3);
        stack.push(11);
        stack.push(2);
        stack.push(3);
        stack.push(2);
        stack.push(7);
        stack.push(12);
        stack.push(4);

        System.out.println("before: " + stack);
        removed = removeMin(stack);
        System.out.println("after:  " + stack);

        assertEquals(2, removed);
        assertEquals(7, stack.size());
        assertEquals("[8, 3, 11, 3, 7, 12, 4]", stack.toString());

        System.out.println("SUCCESS: @END");
    }

}
