package top.woohoo.set;

import top.woohoo.list.LinkedList;

public class LinkedListSet<T> implements Set<T> {

    private final LinkedList<T> linkedList;

    public LinkedListSet() {
        this.linkedList = new LinkedList<T>();
    }


    @Override
    public void add(T value) {
        if (!linkedList.contains(value)) {
            linkedList.add(value);
        }
    }

    @Override
    public void remove(T value) {
        linkedList.removeByValue(value);
    }

    @Override
    public boolean contains(T value) {
        return linkedList.contains(value);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
