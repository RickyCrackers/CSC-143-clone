package utils;

/**
 * This data structure will mimic some of the behaviors/features of the
 * Java Standard Library (Java API) version of an array list (dynamic array) data structure.
 * You are being assessed on your ability to understand the functionality of Array Lists and Lists
 * and to implement them with coding features that the Java Language provides.
 * @param <E> element of a list
 * @author Gia Huy (Ricky) Tran
 */

public  class ArrayList<E> extends AbstractList<E> {

    /**
     * is a constant that holds a default capacity of ten (10) for the underlying array.
     */
    public static final int DEFAULT_CAPACITY = 10;

    /**
     * is a reference variable for the internal array called "data".
     */
    private E[] data;

    /**
     * stores the number of occupied locations in internal array.
     */
    private int size;

    /**
     * The default constructor calls the second constructor, generating an internal array
     * with the specified DEFAULT CAPACITY.
     */
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * The second constructor generates an internal array with the specified initial capacity.
     * If the capacity is less than zero, this constructor should throw an IllegalArgumentException.
     *
     * @param capacity the initial capacity of the array list
     * @throws IllegalArgumentException if the specified capacity is negative
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid Capacity: " + capacity);
        }
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * The third constructor generates an internal array with the elements of another list.
     * The size of the list is the same as the list passed as a parameter.
     *
     * @param list the list whose elements are to be placed into this list
     */
    public ArrayList(List<E> list) {
        this(list.size());
        addAll(list);
    }

    /**
     * checks if there is enough space in the underlying array to hold the next added item,
     * if it doesn't it resizes the underlying array by comparing: double the current capacity + 1
     * of the underlying array to the required minCapacity then using the larger value to ensure
     * the storage of all current elements + 1.
     *
     * @param minCapacity the desired minimum capacity
     */
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

    /**
     * Checks capacity to ensure the array can hold the specified minimum capacity.
     *
     * @param minCapacity the desired minimum capacity
     */
    public void checkCapacity(int minCapacity) {
        ensureCapacity(minCapacity);
    }

    /**
     * helper method that shifts elements of internal array right from index location.
     * Does not update the size of the list.
     *
     * @param index the location to shift elements right from
     */
    private void shiftRight(int index) {
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
    }

    /**
     * helper method that shifts elements of internal array left from index location.
     * Does not update the size of the list.
     *
     * @param index the location to shift elements left from
     */
    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
    }

    /**
     * appends the item specified to the end of the list and updates the number of elements one at a time.
     * This method returns true, if the data was added successfully.
     *
     * @param item the element to be appended to this list
     * @return true if the data was added successfully
     */
    public boolean add(E item) {
        ensureCapacity(size + 1);
        data[size] = item;
        size++;
        return true;
    }

    /**
     * Moves (shifts) elements at index and after to the right and then inserts the item specified at the given index in the list.
     * This method then updates the number of elements in list one at a time.
     *
     * @param index index at which the specified element is to be inserted
     * @param item element to be inserted
     */
    public void add(int index, E item) {
        checkAddIndex(index);
        ensureCapacity(size + 1);
        shiftRight(index);
        data[index] = item;
        size++;
    }

    /**
     * clears list of all elements from the list for garbage collection, returns size back to zero.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * returns true, if the other list passed as an object (obj) is identical in size and contents (order of elements) to the current list.
     *
     * @param obj the object to be compared for equality with this list
     * @return true if the specified object is equal to this list
     */
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

    /**
     * returns the item at the specified position in the list.
     * This method first checks if the index requested is valid.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * searches for a specific item within the list and returns the first occurrence (i.e., index location) in the array if found,
     * otherwise returns the value -1 to indicate that the item was NOT FOUND.
     *
     * @param item element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * removes the item at the given index in the list.
     * Moves (shifts) elements down one index (to the left) in list, and returns item removed.
     * This method first checks if the index requested is valid and reduces the number of elements by one.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     */
    public E remove(int index) {
        checkIndex(index);
        E removedItem = data[index];
        shiftLeft(index);
        size--;
        data[size] = null;
        return removedItem;
    }

    /**
     * removes the first occurrence of the item specified from the list, if present.
     * Moves (shifts) subsequent elements to the left and returns true, if the item is removed.
     * Reduces the number of elements by one.
     *
     * @param item element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(E item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;

    }

    /**
     * replaces the item at the specified position with the one specified.
     * This method validates the index before replacing the item.
     *
     * @param index index of the element to replace
     * @param item element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public E set(int index, E item) {
        checkIndex(index);
        E oldItem = data[index];
        data[index] = item;
        return oldItem;
    }

    /**
     * returns the number of elements in the list.
     * This is the size of the occupied locations of the array.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * displays the full contents of the list.
     * Using the String Builder class to string the contents of the list together.
     *
     * @return a string representation of the list
     */
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
}
