package leetcode.editor.cn.uf;

/**
 * @author:treey
 * @create:2022/4/8
 **/
public class PointRelation {

    public int from;
    public int to;
    public int weight;

    public PointRelation(int a, int b, int len){
        this.from = a;
        this.to = b;
        this.weight = len;
    }

    public int getWeight(){
        return this.weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
