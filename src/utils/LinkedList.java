package utils;


public class LinkedList <E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }


    public LinkedList(List<E> list) {
        first = null;
        last = null;
        size = 0;
        for (int i = 0; i < list.size(); i++) {
            E item = list.get(i);
            this.add(item);
        }
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data) {
            this(null, data, null);
        }

        public Node(Node<E> prev, E data) {
            this(prev, data, null);
        }

        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    private void append(E item) {
        if (first == null) {
            first = new Node<>(item);
            last = first;
        }  else {
            Node<E> newNode = new Node<>(last, item, null);
            last.next = newNode;
            last = newNode;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private Node<E> node(int index) {
        Node<E> current;
        if (index < size / 2) {
            current = first;
            for (int i = 0; i < index; i++,  current = current.next) {}
        } else {
            current = last;
            for (int i = size - 1 ; i > index; i--,  current = current.prev) {}
        }
        return current;
    }

    private void insertBefore(int index, E item) {
        Node<E> currentNode = node(index);
        Node<E> prevNode = currentNode.prev;

        Node<E> newNode = new Node<>(prevNode, item, currentNode);

        currentNode.prev = newNode;


        if (prevNode == null) {
            first = newNode;
        } else {
            prevNode.next = newNode;
        }
    }

    private void detachNode(Node<E> node) {
        if (node == null) {
            return;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            first = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            last = node.prev;
        }

        node.data = null;
        node.next = null;
        node.prev = null;
    }

    private E detach(int index) {
        Node<E> targetNode = node(index);
        E oldNoteData =  targetNode.data;
        detachNode(targetNode);
        return oldNoteData;
    }

    private void detachNodeAfter(Node<E> node) {
        if (node != null && node.next  != null) {
            detachNode(node.next);
        }
    }

    private void detachNodeBefore(Node<E> node) {
        if (node != null && node.prev  != null) {
            detachNode(node.prev);
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return node(index).data;
    }

    public E set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node<E> targetNode = node(index);
        E oldNoteData = targetNode.data;
        targetNode.data = item;
        return oldNoteData;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if  (index == size) {
            append(item);
        } else {
            insertBefore(index, item);
        }
        size++;
    }

    public boolean add(E item) {
        append(item);
        size++;
        return true;
    }

    public boolean addAll(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
        return true;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        E oldNoteData = detach(index);
        size--;
        return oldNoteData;
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

    public void clear() {
        first = null;
        last = null;
        size = 0;
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

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
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
