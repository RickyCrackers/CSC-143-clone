package utils;

/**
 * This data structure will mimic some of the behaviors/features of the
 * Java Standard Library (Java API) version of an array list (dynamic array) data structure.
 * You are being assessed on your ability to understand the functionality of Array Lists and Lists
 * and to implement them with coding features that the Java Language provides.
 * @param <E> element of a list
 */

public  class ArrayList<E> extends AbstractList<E> {
    //TODO: Fill in the following
    //      (a) constants
    //      (b) data fields
    //      (c) constructors
    //      (d) methods
    //      (e) inner classes (if specified)

    public static final int DEFAULT_CAPACITY = 10;

    private E[] data;
    private int size;

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid Capacity: " + capacity);
        }
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayList(List<E> list) {
        this(list.size());
        addAll(list);
    }
    @SuppressWarnings("unchecked")
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(minCapacity, 2 * data.length + 1);
            E[] newData = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public void checkCapacity(int minCapacity) {
        ensureCapacity(minCapacity);
    }

    private void shiftRight(int index) {
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
    }

    public boolean add(E item) {
        ensureCapacity(size + 1);
        data[size] = item;
        size++;
        return true;
    }

    public void add(int index, E item) {
        checkAddIndex(index);
        ensureCapacity(size + 1);
        shiftRight(index);
        data[index] = item;
        size++;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public boolean contains(E item) {
        return super.contains(item);
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List<E> other = (List<E>) obj;

        if (this.size != other.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }

        }
        return true;

    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(int index) {
        checkIndex(index);
        E removedItem = data[index];
        shiftLeft(index);
        size--;
        data[size] = null;
        return removedItem;
    }

    @Override
    public boolean remove(E item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;

    }

    public E set(int index, E item) {
        checkIndex(index);
        E oldItem = data[index];
        data[index] = item;
        return oldItem;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    //TODO: See package "examples" > "lists" for an example to follow.
    //      (a) IntArrayList
    //      (b) IntArrayIterator

    //TODO: Tasks To Complete
    //      (1) Create and screenshots of Javadocs. See Menu -> Tools -> Generate Javadocs
    //      (2) Run JunitTest and take screen shot of results. See junits > JUNIT02QQArrayListTest
}
