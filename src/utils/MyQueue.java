package utils;

import java.util.NoSuchElementException;

/**
 * A generic First-In-First-Out (FIFO) queue data structure implemented using linked nodes.
 *
 * @param <E> the type of elements held in this queue
 * @author Gia Huy (Ricky) Tran
 */
public class MyQueue<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    /**
     * A generic nested node class for the queue data structure.
     *
     * @param <E> the type of data held in the node
     */
    public static class Node<E> {
        @SuppressWarnings("FieldMayBeFinal")
        private E data;
        private Node<E> next;

        /**
         * Constructs a new node with the specified data and no next node.
         *
         * @param data the data to store in this node
         */
        public Node(E data) {
            this(data, null);
        }

        /**
         * Constructs a new node with the specified data and next node reference.
         *
         * @param data the data to store in this node
         * @param next the reference to the next node in the queue
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Constructs an empty queue.
     */
    public MyQueue() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Appends a node to the back of the queue.
     *
     * @param item the item to be appended
     */
    private void append(E item) {
        if (first == null) {
            first = new Node<>(item);
            last = first;
        } else {
            last.next = new Node<>(item);
            last = last.next;
        }
    }

    /**
     * Removes the node at the front of the queue and returns the deleted element.
     *
     * @return the element removed from the front of the queue
     */
    private E detach() {
        E data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    /**
     * Removes the element from the front of the queue and returns it.
     *
     * @return the element removed from the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        size--;
        return detach();
    }

    /**
     * Appends the given element to the back of the queue.
     *
     * @param item the item to add to the queue
     * @return true upon successful addition
     */
    public boolean add(E item) {
        append(item);
        size++;
        return true;
    }

    /**
     * Returns the front element from the queue without removing it.
     *
     * @return the front element, or null if the queue is empty
     */
    public E peek() {
        if (first == null) {
            return null;
        }
        return first.data;
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    public int size() {
        return size;
    }

    /**
     * Tests if this queue is empty.
     *
     * @return true if this queue has no elements; false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representation of this queue from front to back.
     *
     * @return a string representation of this queue
     */
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            sb.append(current.data);
            if (i < size - 1) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
