package utils;


public class SinglyLinkedList<E> implements List<E> {
    private Node<E> first;
    private int size;

    public SinglyLinkedList() {
        first = null;
        size = 0;
    }

    public SinglyLinkedList(List<E> list) {
        first = null;
        size = 0;
        for (int i = 0; i < list.size(); i++) {
            E item = list.get(i);
            this.add(item);

        }

    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index: " + index);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private void append(E item) {
        if (first == null) {
            first = new Node<>(item);
        } else {
            Node<E> current = first;
            for (;current.next != null; current = current.next) {}
            current.next = new Node<>(item);
        }
    }

    private Node<E> node(int index) {
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private E detach(int index) {
        if (index == 0) {
            E removedItem = first.data;
            first = first.next;
            return removedItem;
        } else {
            Node<E> nodeBefore = node(index - 1);
            Node<E> targetNode = nodeBefore.next;
            E removedItem = targetNode.data;
            nodeBefore.next = targetNode.next;
            return removedItem;

        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private E detachNode(Node<E> node) {
        E removedData = node.data;
        if (node == first) {
            first = first.next;
        } else {
            Node<E> current = first;
            for (; current != null && current.next != node; current = current.next) {}
            if (current != null) {
                current.next = node.next;

            }
        }
        node.next = null;
        node.data = null;
        return removedData;
    }

    private void insertBefore(int index, E item) {
        if (index == 0) {
            first = new Node<>(item, first);
        } else {
            Node<E> nodeBefore = node(index - 1);
            nodeBefore.next = new Node<>(item, nodeBefore.next);
        }
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) { // Notice there is no '=' sign here
            throw new IndexOutOfBoundsException("Invalid Index: " + index);
        }
        insertBefore(index, item);
        size++;

    }

    public boolean add(E item) {
        append(item);
        size++;
        return true;
    }

    public boolean addAll(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null && size == 0;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public E get(int index) {
        checkIndex(index);
        return node(index).data;
    }

    public E set(int index, E item) {
        checkIndex(index);
        Node<E> node = node(index);
        E oldItem = node.data;
        node.data = item;
        return oldItem;
    }

    public E remove(int index) {
        checkIndex(index);
        E removedItem = detach(index);
        size--;
        return removedItem;
    }

    public boolean remove(E item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    public boolean removeAll(List<E> list) {
        boolean change = false;
        for (int i = 0; i < list.size(); i++) {
            E target = list.get(i);
            for (; remove(target); ) {
                change = true;
            }
        }
        return change;
    }

    public int indexOf(E item) {
        int index = 0;

        for (Node<E> node = first; node != null; node = node.next, index++) {
            if (node.data.equals(item)) {
                return index;
            }
        }
        return -1;
    }

    public boolean contains(E item) {
        return indexOf(item) != -1;
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

        Node<E> current = first;

        for (int i = 0; i < size; i++) {
            if (!current.data.equals(other.get(i))) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder result = new StringBuilder("[" + first.data);
            for (Node<E> node = first.next; node != null; node = node.next) {
                result.append(", ").append(node.data);
            }
            return result.append("]").toString();
        }
    }
}
