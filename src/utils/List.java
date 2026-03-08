package utils;

import java.util.NoSuchElementException;

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

    default Iterator<E> iterator() {
        return new Iterator<>() {
            int index = 0;
            boolean isRemovable = false;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the list.");
                }
                E data = get(index++);
                isRemovable = true;
                return data;
            }

            @Override
            public void remove() {
                if (!isRemovable) {
                    throw new IllegalStateException("Cannot remove elements from a non-removable list.");
                }
                List.this.remove(index - 1);
                isRemovable = false;
                index--;
            }
        };
    }



}
