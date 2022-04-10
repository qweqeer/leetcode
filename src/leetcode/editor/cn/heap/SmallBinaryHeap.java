package leetcode.editor.cn.heap;

/**
 * 最小堆
 *
 * @author:treey
 * @create:2022/4/10
 **/
public class SmallBinaryHeap<Key extends Comparable<Key>> extends BinaryStack<Key> {
    public SmallBinaryHeap(int cap) {
        super(cap);
    }

    @Override
    public void insert(Key e) {
        size++;
        pq[size] = e;
        swim(size);
    }

    @Override
    public Key delMax() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("");
    }

    @Override
    public Key delMin() {
        Key min = pq[1];
        exch(1, size);
        pq[size] = null;
        size--;
        sink(1);
        return min;
    }

    /**
     * 元素上浮
     *
     * @param k
     */
    @Override
    protected void swim(int k) {
        while (k>1 && less(k,parent(k))){
            exch(k,parent(k));
            k = parent(k);
        }
    }

    /**
     * 元素下沉
     *
     * @param k
     */
    @Override
    protected void sink(int k) {
        while (left(k) <= size) {
            int lessIndex = left(k);
            if (right(k) <= size && less(right(k), lessIndex)) {
                lessIndex = right(k);
            }
            if (less(k, lessIndex)) break;
            exch(k, lessIndex);
            k = lessIndex;
        }
    }

    public static void main(String[] args) {
        SmallBinaryHeap<Integer> heap = new SmallBinaryHeap<>(100);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(-1);
        heap.insert(-3);
        heap.delMin();
        System.out.println("done");
    }

}
