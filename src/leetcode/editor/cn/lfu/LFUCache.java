package leetcode.editor.cn.lfu;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author:treey
 * @create:2022/4/10
 **/
public class LFUCache {
    //缓存支持的节点数
    private int capacity;
    //已使用大小
    private int size;
    //kv键值对
    private HashMap<Integer,Integer> keyAndValueMap;
    //key的使用次数
    private HashMap<Integer,Integer> keyFreqMap;
    //相同次数下的key列表
    private HashMap<Integer, LinkedList<Integer>> freqAndKeysMap;
    //最少访问次数
    private int minFreq;

    public LFUCache(int capacity) {
        this.keyAndValueMap = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size=0;
        this.freqAndKeysMap = new HashMap<>();
        this.minFreq = 1;
        this.keyFreqMap = new HashMap<>();
    }

    public int get(int key) {
        if(!keyAndValueMap.containsKey(key)){
            return -1;
        }
        int value = keyAndValueMap.get(key);
        incrementKeyFreq(key);
        return value;
    }

    /**
     * 更新key的访问频率
     * @param key
     */
    private void incrementKeyFreq(int key){
        int oldFreq  = keyFreqMap.get(key);
        LinkedList<Integer> oldList= freqAndKeysMap.get(oldFreq);
        oldList.remove((Integer) key);

        int newFreq = oldFreq+1;

        LinkedList<Integer> newList= freqAndKeysMap.getOrDefault(newFreq,new LinkedList());
        newList.addFirst(key);
        keyFreqMap.put(key,newFreq);
        freqAndKeysMap.put(newFreq,newList);
        // 如果最小访问次数对应的key列表为空，则访问次数+1
        if(oldList.isEmpty()){
            if(oldFreq == this.minFreq){
                this.minFreq++;
            }else{
                minFreq = Math.min(newFreq,minFreq);
            }
        }
    }

    /**
     * 移除访问频率最低的key，如果存在多个，移除最远访问的key
     */
    private void removeLeaseFreqKey(){
        if(size<capacity){
            return;
        }
        LinkedList<Integer> minFreqKeyList= freqAndKeysMap.getOrDefault(minFreq,new LinkedList<>());
        if(minFreqKeyList.isEmpty()){
            return;
        }
        int key=minFreqKeyList.removeLast();
        if(minFreqKeyList.isEmpty()){
            freqAndKeysMap.remove(minFreq);
        }
        keyAndValueMap.remove(key);
        int visited = keyFreqMap.remove(key);
        size--;
    }

    public void put(int key, int value) {
        if(capacity<=0){
            return;
        }
        if(!keyAndValueMap.containsKey(key)){
            removeLeaseFreqKey();
            int visited = 1;
            keyAndValueMap.put(key,value);
            keyFreqMap.put(key,visited);
            LinkedList<Integer> newList= freqAndKeysMap.getOrDefault(visited,new LinkedList<>());
            newList.addFirst(key);
            freqAndKeysMap.put(visited,newList);
            size++;
            minFreq=1;
        }else{
            keyAndValueMap.put(key,value);
            incrementKeyFreq(key);

        }
    }

    public static void main(String[] args) {
        /**
         * ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
         * [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
         */
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        lfuCache.get(1);
        lfuCache.put(3,3);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.put(4,4);
        lfuCache.get(1);
        lfuCache.get(3);
        lfuCache.get(4);
    }
}
