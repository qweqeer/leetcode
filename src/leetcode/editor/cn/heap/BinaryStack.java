package leetcode.editor.cn.heap;

/**
 * 二叉堆
 * @author:treey
 * @create:2022/4/10
 **/
public abstract class BinaryStack<Key extends Comparable<Key>> {

    // 存储元素的数组
    protected Key[] pq;
    // 当前 Priority Queue 中的元素个数
    protected int size = 0;

    protected BinaryStack(int cap) {
        // 索引 0 不用，所以多分配一个空间
        pq = (Key[]) new Comparable[cap + 1];
    }

    /* 返回当前队列中最大元素 */
    public Key max(){
        return null;
    }

    public Key min(){
        return null;
    }

    /* 插入元素 e */
    public abstract void insert(Key e);

    /* 删除并返回当前队列中最大元素 */
    public abstract Key delMax() throws CloneNotSupportedException;

    public abstract Key delMin();

    /* 上浮第 k 个元素，以维护堆性质 */
    protected abstract void swim(int k);

    /* 下沉第 k 个元素，以维护堆性质 */
    protected abstract void sink(int k);

    /* 交换数组的两个元素 */
    protected void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /* pq[i] 是否比 pq[j] 小？ */
    protected boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // 父节点的索引
    protected int parent(int root) {
        return root / 2;
    }
    // 左孩子的索引
    protected int left(int root) {
        return root * 2;
    }
    // 右孩子的索引
    protected int right(int root) {
        return root * 2 + 1;
    }
}
