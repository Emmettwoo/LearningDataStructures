package top.woohoo.stack;

import top.woohoo.list.SinglyLinkedList;

public class LinkedListStack<T> implements Stack<T> {
    private final SinglyLinkedList<T> linkedList;

    public LinkedListStack() {
        linkedList = new SinglyLinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(T value) {
        linkedList.add(0, value);
    }

    @Override
    public T pop() {
        return linkedList.remove(0);
    }

    @Override
    public T peek() {
        return linkedList.get(0);
    }


    @Override
    public String toString() {
        if (linkedList.isEmpty()) {
            return "Stack is empty";
        } else {
            int stackSize = linkedList.getSize();
            StringBuilder dataString = new StringBuilder();
            for (int index = 0; index < stackSize; index++) {
                dataString.append(linkedList.get(index));
                if (index != stackSize-1) {
                    dataString.append(", ");
                }
            }
            return "Stack data: top -> [ " + dataString + " ]";
        }
    }
}
