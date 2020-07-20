package top.woohoo.queue;

public class LoopQueue<T> implements Queue<T> {

    private T[] data;
    private int capacity = 10;
    private int front = 0, tail = 0;

    // Constructors
    public LoopQueue() {
        this.data = (T[])new Object[capacity + 1];
    }
    public LoopQueue(int capacity) {
        this.capacity = capacity;
        this.data = (T[])new Object[capacity + 1];
    }


    @Override
    public int getSize() {
        return front>tail ? tail+capacity-front : tail-front;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }
    public boolean isFull() {
        return front == (tail + 1) % capacity;
    }

    @Override
    public void enqueue(T value) {
        if (this.isFull()) {
            this.expansion();
        }
        this.data[tail % capacity] = value;
        tail++;
    }

    @Override
    public T dequeue() {
        if (!this.isEmpty()) {
            T value = this.data[front];
            this.data[front++] = null;

            if (this.getSize() <= capacity/4 ) {
                this.shrinkage();
            }

            return value;
        } else {
            throw new IllegalArgumentException("Queue is Empty.");
        }
    }

    @Override
    public T getFront() {
        return this.data[front];
    }


    // 扩容与缩容
    private void expansion() {
        if (this.data.length / 2 != 0) {
            this.capacity *= 2;
            // 复制旧data
            int queueSize = this.getSize();
            T[] newData = (T[])new Object[capacity];
            for (int index = 0; index < queueSize; index++) {
                newData[front + index] = this.data[(front + index) % (capacity / 2)];
            }
            this.data = newData;
        }
    }
    private void shrinkage() {
        this.capacity /= 2;
        // 复制旧data
        int queueSize = this.getSize();
        T[] newData = (T[])new Object[capacity];
        for (int index = 0; index < queueSize; index++) {
            newData[(front + index) % capacity] = this.data[(front + index) % (capacity * 2)];
        }
        this.data = newData;
    }


    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Queue is empty";
        } else {
            int queueSize = this.getSize();
            StringBuilder dataString = new StringBuilder();
            for (int index = 0; index < queueSize; index++) {
                dataString.append(this.data[(index + front) % capacity]);
                if (index != queueSize-1) {
                    dataString.append(", ");
                }
            }
            return "Queue capacity: " + this.capacity + ", data: [ " + dataString + " ] -> end";
        }
    }
}
