package top.woohoo.queue;

/**
 * 基于单向链表实现队列，head为队首（出队），tail为队尾（入队）。
 * 由于需要tail属性，该类内将重写原有的SinglyLinkedList逻辑。
 * @see top.woohoo.list.SinglyLinkedList
 */
public class LinkedListQueue<T> implements Queue<T> {
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

    private Node head = null, tail = null;
    private int size = 0;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T value) {
        if (tail == null) {
            tail = new Node(value);
            head = tail;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Queue is empty, dequeue failed.");
        } else {
            Node node = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            node.next = null;
            size--;
            return node.value;
        }
    }

    @Override
    public T getFront() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        } else {
            return head.value;
        }
    }


    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Queue is empty";
        } else {
            StringBuilder dataString = new StringBuilder();
            Node currentNode = head;
            while (currentNode != null) {
                dataString.append(currentNode.value).append(" -> ");
                currentNode = currentNode.next;
            }
            dataString.append("NULL");
            return "Queue data: [ " + dataString + " ]";
        }
    }
}
