package top.woohoo.map;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key, V value) {
            this(key, value, null);
        }
        public Node(K key) {
            this(key, null, null);
        }
        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }


    private final Node dummyHead;
    private int size;


    // Construct
    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }


    @Override
    public void add(K key, V value) {
        Node node = this.getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public void set(K key, V value) {
        Node node = this.getNode(key);
        if (node != null) {
            node.value = value;
        } else {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
    }

    @Override
    public V get(K key) {
        Node node = this.getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public V remove(K key) {
        Node previousNode = dummyHead;
        while (previousNode.next != null) {
            if (key.equals(previousNode.next.key)) {
                Node targetNode = previousNode.next;
                previousNode.next = targetNode.next;
                targetNode.next = null;
                return targetNode.value;
            } else {
                previousNode = previousNode.next;
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return this.getNode(key) != null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private Node getNode(K key) {
        Node node = dummyHead.next;
        while (node != null) {
            if (key.equals(node.key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
