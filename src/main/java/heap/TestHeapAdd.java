package heap;

public class TestHeapAdd {

    public static void main(String[] args) {
        Heap heap = new Heap(100);
        heap.add(2);
        heap.add(3);
        heap.add(-1);
        heap.add(0);
        heap.add(10);
        heap.add(5);
        heap.add(4);
        heap.add(-100);
        heap.printOut();
    }
}
