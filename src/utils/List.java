package utils;

/**
 * Create a List interface that will be used to describe the behavior
 * of lists in both an Array List and Linked List data structure.
 * You are being assessed on its creation.
 * @param <E>
 */

public interface List<E> {

    boolean add(E item);
    void add(int index, E item);
    boolean addAll(List<E> list);
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
