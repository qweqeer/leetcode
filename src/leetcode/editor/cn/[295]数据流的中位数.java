package leetcode.editor.cn;//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 
// 👍 669 👎 0


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

    private int size;

    //存放大于中位数的值
    private PriorityQueue<Integer> large;
    //存放小于中位数的值
    private PriorityQueue<Integer> small;

    public MedianFinder() {
        this.large = new PriorityQueue<Integer>();
        this.small = new PriorityQueue<Integer>((a,b)->b-a);
        this.size=0;
    }

    public void addNum(int num) {
        if(small.size() >= large.size()){
            //small队列更长，需要将small队列+当前值中最大的元素添加到large队列
            small.offer(num);
            large.offer(small.poll());
        }else{
            //将large和num最小的元素添加到small
            large.add(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if(small.size() == large.size()){
            return (double) (small.peek()+large.peek())/2;
        }else if(small.size()>large.size()){
            return  small.peek();
        }else {
            return large.peek();
        }
    }

    public static void main(String[] args) {
        /**
         * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
         * [[],[1],[2],[],[3],[]]
         */
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
