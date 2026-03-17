package utils;

import java.util.EmptyStackException;

/**
 * A generic Last-In-First-Out (LIFO) stack data structure implemented using linked nodes.
 *
 * @param <E> the type of elements held in this stack
 * @author Gia Huy (Ricky) Tran
 */
public class MyStack<E> {
    private Node<E> first;
    @SuppressWarnings("unused")
    private Node<E> last;
    private int size;

    /**
     * A generic nested node class for the stack data structure.
     *
     * @param <E> the type of data held in the node
     */
    public static class Node<E> {
        private final E data;
        private final Node<E> next;

        /**
         * Constructs a new node with the specified data and next node reference.
         *
         * @param data the data to store in this node
         * @param next the reference to the next node in the stack
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Constructs an empty stack.
     */
    public MyStack() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Removes the node at the top of the stack and returns the removed item.
     *
     * @return the element removed from the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    private E detach() {
        if (first == null) {
            throw new EmptyStackException();
        }
        E data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item the item to be pushed onto this stack
     * @return the item argument
     */
    public E push(E item) {
        if (first == null) {
            first = new Node<>(item, null);
            last = first;
        } else {
            first = new Node<>(item, first);
        }
        size++;
        return item;
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     *
     * @return the object at the top of this stack
     * @throws EmptyStackException if this stack is empty
     */
    public E pop() {
        size--;
        return detach();
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     *
     * @return the object at the top of this stack
     * @throws EmptyStackException if this stack is empty
     */
    public E peek() {
        if (first == null) {
            throw new EmptyStackException();
        }
        return first.data;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    public int size() {
        return size;
    }

    /**
     * Tests if this stack is empty.
     *
     * @return true if and only if this stack contains no items; false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representation of this stack from bottom to top.
     *
     * @return a string representation of this stack
     */
    public String toString() {
        ArrayList<E> list = new ArrayList<>();
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            list.add(current.data);
            current = current.next;
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
