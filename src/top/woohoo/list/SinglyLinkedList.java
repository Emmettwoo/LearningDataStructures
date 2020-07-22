package top.woohoo.list;

public class SinglyLinkedList<T> {
    private class Node {
        public T value;
        public Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
        public Node(T value) {
            this(value, null);
        }
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private final Node dummyHead;
    private int size;

    // constructors
    public SinglyLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    // 数据添加
    public void add(int index, T value) {
        if (this.isOverflow(index)) {
            throw new IllegalArgumentException("Index overflow, add failed.");
        } else {
            Node previousNode = this.seekByIndex(index - 1);
            previousNode.next = new Node(value, previousNode.next);
            size++;
        }
    }
    public void add(T value) {
        this.add(size, value);
    }

    // 数据获取
    public int getSize() {
        return size;
    }
    public T get(int index) {
        if (this.isOverflow(index)) {
            throw new IllegalArgumentException("Index overflow, get failed.");
        } else {
            return this.seekByIndex(index).value;
        }
    }

    // 数据修改
    public void set(int index, T value) {
        if (this.isOverflow(index)) {
            throw new IllegalArgumentException("Index overflow, set failed.");
        } else {
            this.seekByIndex(index).value = value;
        }
    }

    // 数据删除
    public T remove(int index) {
        if (this.isOverflow(index)) {
            throw new IllegalArgumentException("Index overflow, remove failed.");
        } else {
            Node previousNode = this.seekByIndex(index - 1);
            Node currentNode = previousNode.next;
            previousNode.next = currentNode.next;

            currentNode.next = null;
            size--;
            return currentNode.value;
        }
    }

    // 数据判断
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean contains(T value) {
        return this.seekByValue(value) != null;
    }


    // 内部功能
    private boolean isOverflow(int index) {
        return index < 0 || index > size;
    }
    private Node seekByIndex(int index) {
        Node currentNode = dummyHead;
        for(int i = 0; i < index + 1; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    private Node seekByValue(T value) {
        Node currentNode = dummyHead.next;
        while(currentNode != null) {
            if (currentNode.value.equals(value)) {
                return currentNode;
            } else {
                currentNode = currentNode.next;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder dataString = new StringBuilder();
        Node currentNode = dummyHead.next;
        while(currentNode != null) {
            dataString.append(currentNode.value).append(" -> ");
            currentNode = currentNode.next;
        }
        dataString.append("NULL");

        return dataString.toString();
    }
}
