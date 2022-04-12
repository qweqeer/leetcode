package leetcode.editor.cn;//设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
//
// 实现 FreqStack 类: 
//
// 
// FreqStack() 构造一个空的堆栈。 
// void push(int val) 将一个整数 val 压入栈顶。 
// int pop() 删除并返回堆栈中出现频率最高的元素。
// 
// 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。 
// 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"
//],
//[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
//输出：[null,null,null,null,null,null,null,5,7,5,4]
//解释：
//FreqStack = new FreqStack();
//freqStack.push (5);//堆栈为 [5]
//freqStack.push (7);//堆栈是 [5,7]
//freqStack.push (5);//堆栈是 [5,7,5]
//freqStack.push (7);//堆栈是 [5,7,5,7]
//freqStack.push (4);//堆栈是 [5,7,5,7,4]
//freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
//freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
//freqStack.pop ();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
//freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
//freqStack.pop ();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。 
//
// 
//
// 提示： 
//
// 
// 0 <= val <= 109 
// push 和 pop 的操作数不大于 2 * 104。 
// 输入保证在调用 pop 之前堆栈中至少有一个元素。 
// 
// Related Topics 栈 设计 哈希表 有序集合 
// 👍 223 👎 0


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class FreqStack {
    /**
     * 需要保证时间的先后顺序
     * 1、所有元素的频率都是有小到大，由于从最高频率开始出栈，只需要保证同一频率元素时间顺序即可
     */

    HashMap<Integer, Stack<Integer>> freqMap;

    HashMap<Integer,Integer> valueFreq;

    int maxFreq = 0;
    public FreqStack() {
        maxFreq = 0;
        freqMap = new HashMap<>();
        valueFreq = new HashMap<>();
    }
    
    public void push(int val) {

        int freq = valueFreq.getOrDefault(val, 0) + 1;
        freqMap.putIfAbsent(freq,new Stack<>());
        freqMap.get(freq).push(val);
        valueFreq.put(val,freq);
        maxFreq = Math.max(maxFreq,freq);
    }
    
    public int pop() {
        Stack<Integer> freqStack=freqMap.get(maxFreq);
       int val=freqStack.pop();
       valueFreq.put(val,valueFreq.getOrDefault(val,0)-1);
       if(freqStack.isEmpty()){
           maxFreq--;
       }
       return val;
    }



    public static void main(String[] args) {
        /**
         * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"]
         * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
         */
        FreqStack stack = new FreqStack();
        stack.push(1);
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
//leetcode submit region end(Prohibit modification and deletion)
