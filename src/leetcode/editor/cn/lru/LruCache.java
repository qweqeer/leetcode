package leetcode.editor.cn.lru;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author:treey
 * @create:2022/4/9
 **/
public class LruCache<K, V> {



    /**
     * Least Recently Used
     *
     * 要求：
     * 1、节点必须以最近访问时间的先后顺序进行排序 ==>双向链表
     * 2、每次访问一个节点后，都需要将该节点前置 ==> 双向链表
     * 3、节点的写入和查找时间复杂度需要在0(1) ==> hashMap
     */

    //缓存允许缓存的KV数
    private int capacity;
    /**
     * 已加入KV数
     */
    private int size = 0;

    /**
     * KV存储地址
     */
    private HashMap<K,V> kvHashMap;

    /**
     * 最近访问时间先后顺序链表
     */
    private java.util.LinkedList<K> keyList = new java.util.LinkedList<>();

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.kvHashMap = new HashMap<>(capacity);
        //初始化
    }

    public V get(K key){
        V value=kvHashMap.get(key);
        if(Objects.isNull(value)){
            return null;
        }
        isUsed(key);
        return value;
    }

    public void put(K key, V value){
        clearLastVisit();
        kvHashMap.put(key,value);
        keyList.addFirst(key);
        size++;
    }

    private void isUsed(K key){
        keyList.remove(key);
        keyList.addFirst(key);
    }

    private void clearLastVisit(){
        if(size == capacity){
           K key=keyList.removeLast();
           kvHashMap.remove(key);
            size--;
        }
    }

    public static void main(String[] args) {
        LruCache<String,Integer> lruCache = new LruCache<>(3);
        lruCache.put("1",1);
        lruCache.put("2",2);
        lruCache.put("3",3);
        lruCache.get("1");
        lruCache.put("4,",4);
        System.out.println("done");

        HashMap map = new HashMap();

    }
}
