package heap;

public class Heap {

    private int[] array;
    private int size;

    public Heap(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public int getLeftChild(int i) {
        return 2 * i + 1;
    }

    public int getRightChild(int i) {
        return 2 * i + 2;
    }

    public int getParent(int i) {
        return (i - 1) / 2;
    }

    public void add(int i) {
        array[size] = i;
        sifUp(size);
        size++;
    }

    public int pop() {
        int value = array[0];
        array[0] = array[size-1];
        size--;
        sifDown();
        return value;
    }

    public void sifDown() {
        int idx = 0, left, right;
        while((getLeftChild(idx) < size && array[idx] > array[getLeftChild(idx)]) ||
                getRightChild(idx) < size && array[idx] > array[getRightChild(idx)]) {
            left = getLeftChild(idx);
            right = getRightChild(idx);
            if(left < size && right < size) {
                // zamiana z mniejszym
                if(array[left] < array[right]) {
                    swap(idx, left);
                    idx = left;
                } else {
                    swap(idx, right);
                    idx = right;
                }
            }
            else if(right >= size) {
                swap(idx, left);
                idx = left;
            }
        }
    }

    public void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void sifUp(int index) {
        int tmp, parentIndex;
        while(index > 0 && array[index] < array[getParent(index)]) {
            parentIndex = getParent(index);
            tmp = array[index];
            array[index] = array[parentIndex];
            array[parentIndex] = tmp;
            index = parentIndex;
        }
    }

    public void printOut() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }
}
