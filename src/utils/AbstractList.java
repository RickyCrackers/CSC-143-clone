package utils;

public abstract class AbstractList<E> implements List<E>{

    public boolean addAll(List<E> list){
        boolean change = false;
        for (int i = 0; i < list.size(); i++) {
            if (add(list.get(i))) {
                change = true;
            }
        }
        return change;
    }

    public boolean removeAll(List<E> list){
        boolean change = false;
        for (int i = 0; i < list.size(); i++) {
            if (remove(list.get(i))) {
                change = true;
            }
        }
        return change;
    }

    protected void checkIndex(int index){
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Invalid Index: " + index);
        }
    }

    protected void checkAddIndex(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Invalid Index: " + index);
        }
    }

}
