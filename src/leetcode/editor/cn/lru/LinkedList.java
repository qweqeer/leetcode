package leetcode.editor.cn.lru;

import java.util.NoSuchElementException;

/**
 * @author:treey
 * @create:2022/4/9
 **/
public class LinkedList<T> {

    /**
     * 双向链表需要实现的方法
     * 1、写入值 addFirst、addLast、addIndex;
     * 2、移除值 removeFirst、removeLast、removeObj、removeIndex
     * 3、获取节点长度
     * 4、初始化
     */

    private int size;
    /**
     * 头节点
     */
    private Node<T> head;
    /**
     * 尾节点
     */
    private Node<T> tail;

    public LinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public LinkedList(T... values) {
        this();
        addAll(values);
    }

    public void addAll(T... values){
        Node<T> p = head;
        Node<T> q = tail;
        for (T value:values){
            Node<T> node = new Node<>(value);
            if(p == null){
                head = p = node;
            }
            if(q == null){
                tail = q = node;
            }else{
                q.next = node;
                node.pre = q;
                q = q.next;
            }
            tail = q;
            size++;
        }
    }

    public void addFirst(T value){
        Node<T> p = head,q = tail;
        Node<T> node = new Node<>(value);
        if(p == null){
            head = p = node;
        }else{
            node.next = p;
        }
        if(q == null){
            tail = q = node;
        }
        node.next = head;
        head.pre = node;
        head = node;

        size++;
    }

    public void addLast(T value){
        Node<T> p = head,q = tail;
        Node<T> node = new Node<>(value);
        if(p == null){
            head = p = node;
        }
        if(q == null){
            tail = q = node;
        }else{
            node.pre = q;
            q.next = node;
            tail = node;
        }
        size++;
    }

    public void add(int index,T value){
        if(index>size){
            throw new IndexOutOfBoundsException("超出当前最大长度");
        }
        if(index == size){
            addLast(value);
            return;
        }
        Node<T> p = head;
        while (--index != 0){
            p = p.next;
        }
        Node<T> node = new Node<>(value);
        node.next = p.next;
        p.next.pre = node;
        p.next = node;
        node.pre = p;
        size++;
    }

    public T removeFirst(){
        Node<T> first = head;
        if(null ==first){
            throw new NoSuchElementException();
        }
        head = head.next;
        if(null == head){
            tail = null;
        }
        size--;
        return first.value;
    }

    public T removeLast(){
        Node<T> last = tail;
        if(null ==last){
            throw new NoSuchElementException();
        }
        if(null == last.pre){
            head = null;
            tail = null;
        }else{
            tail = last.pre;
            tail.next = null;
            last.pre = null;
        }
        size--;
        return last.value;
    }

    public T remove(T value){
        Node<T> temp = head;
        while (temp!=null && temp.value != value){
            temp = temp.next;
        }
        if(temp == null){
            return null;
        }
        if(temp.pre!=null){
            temp.pre.next = temp.next;
            temp.pre=null;
        }else{
            head = temp.next;
        }
        if(temp.next!=null){
            temp.next.pre = temp.pre;
            temp.next=null;
        }else{
            tail = temp.pre;
        }
        size--;
        return  temp.value;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return  size;
    }


    /**
     * 链表节点对象
     * @param <T>
     */
    class Node<T>{
        private T value;
        /**
         * 上一个节点
         */
        private Node pre;
        /**
         * 后一个节点
         */
        private Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node pre, Node next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(1,2,4);
        list.add(2,3);
        list.add(4,5);
        list.addFirst(-1);
        list.addFirst(-2);
        list.addLast(6);
        System.out.println(8 == list.size);
        System.out.println(-2 == list.removeFirst());
        System.out.println(6 == list.removeLast());
        System.out.println(6 == list.size);
    }
}
