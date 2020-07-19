package top.woohoo.array;

public class Array<T> {
    private int capacity;
    private int size = 0;
    private T[] data;

    // Constructors
    public Array() {
        this.capacity = 10;
        this.data = (T[])new Object[capacity];
    }
    public Array(int capacity) {
        this.capacity = capacity;
        this.data = (T[])new Object[capacity];
    }

    // getters & setters
    public int getCapacity() {
        return capacity;
    }
    public int getSize() {
        return size;
    }

    // 判断数据
    public boolean isEmpty() {
        return size <= 0;
    }
    public boolean isFull() {
        return size >= capacity;
    }
    public boolean isOverflow(int index) {
        return index<0 || index>=size;
    }

    // 获取数据
    public T get(int index) {
        if(this.isOverflow(index)) {
            throw new IllegalArgumentException("Index overflow, get failed.");
        } else {
            return data[index];
        }
    }
    public T getLast() {
        return data[this.size-1];
    }
    public void show() {
        System.out.println(this.toString());;
    }

    // 插入数据
    public void add(T value) {
        if (this.isFull()) {
            this.expansion();
        }
        this.data[size++] = value;
    }
    public void add(int index, T value) {
        if (index<0 || index>size){
            throw new IllegalArgumentException("Index overflow, add failed.");
        }
        if (this.isFull()) {
            this.expansion();
        }
        // 插入位置之后的元素往后挪一位
        for(int i = size-1; i >= index; i--) {
            this.data[i+1] = data[i];
        }
        this.data[index] = value;
        size++;
    }
    public void addBatch(T[] values) {
        for (T value : values) {
            this.add(value);
        }
    }
    public void addBatch(int index, T[] values) {
        for (T value : values) {
            this.add(index++, value);
        }
    }

    // 修改数据
    public void set(int index, T value) {
        if (this.isOverflow(index)) {
            throw new IllegalArgumentException("Index overflow, set failed.");
        } else {
            this.data[index] = value;
        }
    }

    // 删除数据
    public T removeByIndex(int index) {
        if (this.isOverflow(index)) {
            throw new IllegalArgumentException("Index overflow, remove failed.");
        }
        // 备份被删除值，并将其后面的位向前挪
        T temp = this.data[index];
        if (this.size == index + 1) {
            this.data[index] = null;
        } else {
            System.arraycopy(this.data, index + 1, this.data, index, size - index + 1);
        }

        // 判断是否有缩容需求，并返回被删除数值
        if(--size <= capacity/4) {
            this.shrinkage();
        }
        return temp;
    }
    public void removeByValue(T value) {
        int isExist = this.find(value);
        while(isExist >= 0) {
            this.removeByIndex(isExist);
            isExist = this.find(value);
        }
        // 判断是否有缩容需求
        if(--size <= capacity/4) {
            this.shrinkage();
        }
    }
    public T removeLast() {
        return this.removeByIndex(this.size-1);
    }
    public void removeAll() {
        this.data = (T[])new Object[capacity];
        this.size = 0;
    }

    // 搜索数据
    public int find(T value) {
        if (!this.isEmpty()) {
            for (int index = 0; index < size; index++) {
                if (value.equals(this.data[index])) {
                    return index;
                }
            }
        }
        return -1;
    }

    // 扩容与缩容
    private void expansion() {
        if (this.data.length / 2 != 0) {
            this.capacity *= 2;
            // 复制旧data
            T[] newData = (T[])new Object[capacity];
            for (int index=0; index<size; index++) {
                newData[index] = this.data[index];
            }
            this.data = newData;
        }
    }
    private void shrinkage() {
        this.capacity /= 2;
        // 复制旧data
        T[] newData = (T[])new Object[capacity];
        System.arraycopy(this.data, 0, newData, 0, size);
        this.data = newData;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Array is empty";
        } else {
            // 拼接数组内的数据为字符串
            StringBuilder dataString = new StringBuilder();
            for (int index = 0; index < size; index++) {
                dataString.append(this.data[index]);
                if (index != size-1) {
                    dataString.append(", ");
                }
            }
            return "Array info: capacity: " + this.capacity
                    + ", size: " + this.size
                    + ", data: [ " + dataString + " ]";
        }
    }
}
