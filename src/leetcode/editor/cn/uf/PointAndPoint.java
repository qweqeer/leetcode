package leetcode.editor.cn.uf;

/**
 * @author:treey
 * @create:2022/4/8
 **/
public class PointAndPoint {

    public int pointIdA;
    public int pointIdB;
    public int weight;

    public PointAndPoint(int a,int b, int len){
        this.pointIdA = a;
        this.pointIdB = b;
        this.weight = len;
    }

    public int getWeight(){
        return this.weight;
    }
}
