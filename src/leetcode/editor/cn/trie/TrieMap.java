package leetcode.editor.cn.trie;

import javax.swing.tree.TreeNode;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 字典表
 * @author:treey
 * @create:2022/4/10
 **/
public class TrieMap<T> {

    private int size;

    /**
     * 允许的子节点数
     */
    private int nodeChildNum;

    private TrieNode<T>[] nodes;

    public TrieMap(int nodeChildNum) {
        this.nodeChildNum = nodeChildNum;
        this.nodes = new TrieNode[nodeChildNum];
        this.size = 0;
    }

    public void put(String key,T value){
        if(!containKey(key)){
            size++;
        }
        TrieNode temp = nodes[key.charAt(0)];
        for (int i = 1; i < key.length(); i++) {
            int charIndex = key.charAt(i)-'a';
            TrieNode node = temp.getChilds()[charIndex];
            if(null == node){
                node = new TrieNode(value,nodeChildNum,temp.getDepth()+1);
                temp.getChilds()[charIndex] = node;
            }
            temp = node;
        }
        temp.setFreq(temp.getFreq()+1);
    }

    public boolean containKey(String key){
        TrieNode matchNode=find(key);
        if(null == matchNode){
            return false;
        }
        return matchNode.getFreq()<=0;
    }

    private TrieNode find(String word){
        TrieNode temp = nodes[word.charAt(0)];
        for (int i = 1; i < word.length(); i++) {
            int charIndex = word.charAt(i)-'a';
            TrieNode node = temp.getChilds()[charIndex];
            if(null == node){
                return null;
            }
            temp = node;
        }


        return temp;
    }

    private boolean containKeyByPattern(TrieNode node,String word,int start){
        if(null == node){
            return false;
        }
        if(start == word.length()){
            return node.getFreq()>0;
        }
        char c = word.charAt(start);
        if('.' == c ){
            for(TrieNode child:node.getChilds()){
                if(containKeyByPattern(child,word,start+1)){
                    return true;
                }
            }
        }else{
            int charIndex = word.charAt(start)-'a';
            TrieNode childNode = node.getChilds()[charIndex];
            return containKeyByPattern(childNode,word,start+1);
        }
        return false;
    }

    public void removeKey(String key){
        TrieNode node = find(key);
        if(node.getFreq()>0){
            size--;
            node.setValue(null);
            node.setFreq(node.getFreq()-1);
        }
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b)->b-a);
//        queue.offer(queue.peek())
    }
}
