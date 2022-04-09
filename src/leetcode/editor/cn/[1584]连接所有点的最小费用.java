//给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
//
// 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 
//val 的绝对值。 
//
// 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//输出：20
//解释：
//
//我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
//注意到任意两个点之间只有唯一一条路径互相到达。
// 
//
// 示例 2： 
//
// 
//输入：points = [[3,12],[-2,5],[-4,1]]
//输出：18
// 
//
// 示例 3： 
//
// 
//输入：points = [[0,0],[1,1],[1,0],[-1,1]]
//输出：4
// 
//
// 示例 4： 
//
// 
//输入：points = [[-1000000,-1000000],[1000000,1000000]]
//输出：4000000
// 
//
// 示例 5： 
//
// 
//输入：points = [[0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 1000 
// -106 <= xi, yi <= 106 
// 所有点 (xi, yi) 两两不同。 
// 
// Related Topics 并查集 数组 最小生成树 
// 👍 193 👎 0

package leetcode.editor.cn;
import leetcode.editor.cn.uf.PointRelation;
import leetcode.editor.cn.uf.UnionFind;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class MinCostToConnectAllPointsSolution {
    public int minCostConnectPoints(int[][] points) {
        List<PointRelation> nodeWeight = new LinkedList<>();

        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int weight = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                nodeWeight.add(new PointRelation(i,j,weight));
            }
        }
        nodeWeight.sort(Comparator.comparing(PointRelation::getWeight));
        UnionFind uf = new UnionFind(points.length);
        int sumWeight = 0;
        for(PointRelation conn: nodeWeight){
            if(uf.connected(conn.from,conn.to)){
                continue;
            }
            uf.union(conn.from,conn.to);
            sumWeight+= conn.getWeight();
        }
        return uf.getCount()==1?sumWeight:0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
