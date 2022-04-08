package leetcode.editor.cn.uf;

/**
 * @author:treey
 * @create:2022/4/8
 **/
public class UnionFind {


    //构建树 下标为当前节点，值为父节点
    int[] parent;
    //表示根节点的个数，默认为节点数，如果两个节点根相同，则根节点数减一
    int count;

    public UnionFind(int n){
        parent = new int[n];
        count = n;
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    /**
     * 连接两个根节点
     */
    public void union(int x,int y){
        int xRoot = find(x);
        int yRoot = find(y);
        if(xRoot == yRoot){
            return;
        }
        parent[xRoot] = yRoot;
        count--;
    }

    public int find(int x){
        //如果当前节点不是根节点，遍历到根节点
        while(parent[x]!=x){
            x = parent[x];
        }
        return parent[x];
    }

    /**
     * 判断两个节点是否连通
     */
    public boolean connected(int x,int y){
        return find(x) == find(y);
    }

    /**
     * 获取当前根节点数
     */
    public int getCount(){
        return count;
    }
}
