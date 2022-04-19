package leetcode.editor.cn;//有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城
//市 fromi 开始，以价格 pricei 抵达 toi。 
//
// 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便
//宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//输出: 200
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。 
//
// 示例 2： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 0
//输出: 500
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= flights.length <= (n * (n - 1) / 2) 
// flights[i].length == 3 
// 0 <= fromi, toi < n 
// fromi != toi 
// 1 <= pricei <= 104 
// 航班没有重复，且不存在自环 
// 0 <= src, dst, k < n 
// src != dst 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 动态规划 最短路 堆（优先队列） 
// 👍 470 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class FindCheapestPriceSolution {
    int[][] memo;
    HashMap<Integer,LinkedList<FlightInfo>> cityFlightMap;
    int src, dst;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // A->BC,B->D,C->BDE ,E;
        src = src;
        dst = dst;
        k++;
        cityFlightMap = new HashMap<>();
        for(int[] flight:flights){
            LinkedList<FlightInfo> flightList=cityFlightMap.getOrDefault(flight[1],new LinkedList<>());
            flightList.add(new FlightInfo(flight[0],flight[1],flight[2]));
            cityFlightMap.put(flight[1],flightList);
        }
        memo = new int[n][k+1];
        for(int[] row:memo){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        //memo[src][dst] = srcToXPrice + memo[x][dst];
        int price=dp(dst,k);
        return price == Integer.MAX_VALUE?-1:price;
    }
    int dp(int s, int k) {
        // base case
        if (s == src) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        // 查备忘录，防止冗余计算
        if (memo[s][k] != Integer.MAX_VALUE) {
            return memo[s][k];
        }

        // 初始化为最大值，方便等会取最小值
        int res = Integer.MAX_VALUE;
        if (cityFlightMap.containsKey(s)) {
            // 当 s 有入度节点时，分解为子问题
            for (FlightInfo flightInfo : cityFlightMap.get(s)) {
                int from = flightInfo.from;
                int price = flightInfo.price;
                // 从 src 到达相邻的入度节点所需的最短路径权重
                int subProblem = dp(from, k - 1);
                // 跳过无解的情况
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        // 存入备忘录
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }

//    private int dp(int dst,int k){
//        if(k > k){
//            return Integer.MAX_VALUE;
//        }
//
//        if(!cityFlightMap.containsKey(startSite)){
//            return Integer.MAX_VALUE;
//        }
//        if(memo[startSite][dst]!=Integer.MAX_VALUE){
//            return memo[startSite][dst];
//        }
//        LinkedList<FlightInfo> flightList=cityFlightMap.get(startSite);
//        int res = Integer.MAX_VALUE;
//        isVisited[startSite] = true;
//        for(FlightInfo flight:flightList){
//            if(isVisited[flight.to]){
//                continue;
//            }
//            if(transfersNum == k && flight.to!=dst){
//                continue;
//            }
//            if(transfersNum == k){
//                int minPriceSum = dst==flight.to?0:Integer.MAX_VALUE;
//                if(minPriceSum == Integer.MAX_VALUE){
//                    continue;
//                }
//                res = Math.min(res,minPriceSum+flight.price);
//            }else{
//                int minPriceSum =dst==flight.to?0:dp(dst,flight.to,transfersNum+1,k,isVisited);
//                if(minPriceSum == Integer.MAX_VALUE){
//                    continue;
//                }
//                res = Math.min(res,minPriceSum+flight.price);
//            }
//
//
//        }
//        memo[startSite][dst] = res;
//        isVisited[startSite] = false;
//        return res;
//    }
    class FlightInfo{

        int from;

        int to;

        int price;

        public FlightInfo(int from,int to,int price){
            this.from = from;
            this.to = to;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        int[][]flights= {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        FindCheapestPriceSolution solution = new FindCheapestPriceSolution();
        solution.findCheapestPrice(5,flights,0,2,2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
