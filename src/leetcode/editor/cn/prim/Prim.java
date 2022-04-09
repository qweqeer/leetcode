package leetcode.editor.cn.prim;

import leetcode.editor.cn.uf.PointRelation;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 算法参考文档 https://labuladong.github.io/algo/2/21/53/
 *
 * @author:treey
 * @create:2022/4/9
 **/
public class Prim {
    //优先队
    private PriorityQueue<PointRelation> queue;
    //标记那些节点已经访问过了，类似visited作用
    private boolean[] inMst;
    //记录访问所有节点的最短路径Or最小权重
    private int minWeight;
    //三元数组 {from,to,weight}
    private List<PointRelation>[] graph;

    //构建
    public Prim(List<PointRelation>[] graph) {
        this.graph = graph;
        queue = new PriorityQueue(Comparator.comparing(PointRelation::getWeight));
        inMst = new boolean[graph.length];
        minWeight = 0;

        //从第一个几点开始
        inMst[0] = true;
        cut(0);
        while (!queue.isEmpty()){
            PointRelation edge = queue.poll();
            if(inMst[edge.to]){
                //节点已访问，跳过
                continue;
            }
            minWeight+=edge.weight;
            inMst[edge.to] = true;
            cut(edge.to);
        }
    }

    private void cut(int x){
        for(PointRelation edge:graph[x]){
            if(!inMst[edge.to]){
                queue.offer(edge);
            }
        }
    }

    private int getMinWeight(){
        return  minWeight;
    }

    // 判断最小生成树是否包含图中的所有节点
    public boolean allConnected() {
        for (int i = 0; i < inMst.length; i++) {
            if (!inMst[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][]points=new int[][]{{0,0},{1,1},{1,0},{-1,1}};
        int pointNum = points.length;
        List<PointRelation>[] graph = new LinkedList[pointNum];

        for(int i=0;i<points.length;i++){
            graph[i] = new LinkedList();
            for(int j=0;j<points.length;j++){
                int weight = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                graph[i].add(new PointRelation(i,j,weight));
            }
        }
        Prim prim = new Prim(graph);
        System.out.println(prim.getMinWeight());
    }
}
