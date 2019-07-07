import java.util.ArrayList;
import java.util.List;

public class TriangleShortestPath {
    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle.size() == 0) {
            return 0;
        }
        /*最终状态：从顶层->底层
        * 中间状态：从顶层->中间某层
        * dp[][]保存从顶点到其他层各点的最小距离，最终目的求dp[n-1]*/
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < triangle.size(); i++){
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if(j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + triangle.get(i).get(j), dp[i-1][j] + triangle.get(i).get(j));
                }
            }


        }
        int path = dp[dp.length - 1][0];
        for(int i = 1; i < dp.length; i++) {
            path = Math.min(path, dp[dp.length - 1][i]);
        }

        return path;
    }
}

class TriangleShortestPathTest{
    public void test() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3); list2.add(4);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6); list3.add(5); list3.add(7);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4); list4.add(1); list4.add(8); list4.add(3);

        List<List<Integer>> list = new ArrayList<>();
        list.add(list1); list.add(list2); list.add(list3); list.add(list4);

        TriangleShortestPath triangleShortestPath = new TriangleShortestPath();
        System.out.println(triangleShortestPath.minimumTotal(list));

    }
}