package leetcode.editor.cn.trie;

/**
 * @author:treey
 * @create:2022/4/10
 **/
public class TrieNode<T> {

    /**
     * 节点保存值
     */
    private T value;
    /**
     * 使用频率
     */
    private int freq;
    /**
     * 节点的深度
     */
    private int depth;
    /**
     * 子节点数
     */
    private TrieNode[] childs;

    public TrieNode(T value,int len,int freq,int depth) {
        this.value = value;
        this.freq = freq;
        this.childs = new TrieNode[len];
        this.depth = depth;
    }

    public TrieNode(T value,int len, int depth) {
        this(null,len,0,depth);
    }

    public TrieNode(int len, int freq, int depth) {
        this(null,len,freq,depth);
    }

    public T getValue() {
        return value;
    }

    public TrieNode[] getChilds() {
        return childs;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setChilds(TrieNode[] childs) {
        this.childs = childs;
    }

    public int getFreq() {
        return freq;
    }

    public int getDepth() {
        return depth;
    }
}
