package leetcode.editor.cn.heap;

/**
 * 最大堆
 *
 * @author:treey
 * @create:2022/4/10
 **/
public class BiggestBinaryHeap<Key extends Comparable<Key>> extends BinaryStack<Key> {
    public BiggestBinaryHeap(int cap) {
        super(cap);
    }


    /* 返回当前队列中最大元素 */
    public Key max() {
        return pq[1];
    }

    /* 插入元素 e */
    public void insert(Key e) {
        size++;
        pq[size] = e;
        swim(size);
    }

    /* 删除并返回当前队列中最大元素 */
    public Key delMax() {
        Key max = pq[1];
        exch(1, size);
        pq[size] = null;
        size--;
        sink(1);
        return max;
    }

    @Override
    public Key delMin() {
        return null;
    }

    /* 上浮第 k 个元素，以维护最大堆性质 */
    protected void swim(int k) {
        while (k > 1 && less(parent(k), k)) {
            exch(parent(k), k);
            k = parent(k);
        }
    }

    /* 下沉第 k 个元素，以维护最大堆性质 */
    protected void sink(int k) {
        while (left(k) <= size) {
            //获取左节点的下标
            int oldIndex = left(k);
            //比较左右节点的大小,如果右节点大于左节点替换为右节点
            if (right(k) <= size && less(oldIndex, right(k))) {
                oldIndex = right(k);
            }
            if (less(oldIndex, k)) {
                break;
            }
            exch(oldIndex, k);
            k = oldIndex;
        }
    }
}
