package utils;

/**
 * Create a List interface that will be used to describe the behavior
 * of lists in both an Array List and Linked List data structure.
 * You are being assessed on its creation.
 * @param <E>
 */

public interface List<E> {
    //TODO: List the operations for the Generic List Interface.

    //TODO: Fill in the following
    //      (a) abstract methods
    //      (b) default methods

    boolean add(E item);
    void add(int index, E item);
    boolean addAll(List<E> other);
    void clear();
    E get(int index);
    int indexOf(E item);
    E remove(int index);
    boolean remove(E item);
    boolean removeAll(List<E> list);
    E set(int index, E item);
    int size();


    default boolean isEmpty() {
        return size() == 0;
    }

    default boolean contains(E item) {
        return indexOf(item) != -1;
    }



}
