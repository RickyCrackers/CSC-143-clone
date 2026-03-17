package junits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import utils.MyStack;

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

}
