package leetcode.code;

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。
 * 题意解读：
 * 题意：这是一个二维数组，grid[i][j]表示在坐标(i, j)上有grid[i][j]个正方体。
 * 比如例子：[[1, 2], [3, 4]]， grid[0][0] = 1，表示坐标(0, 0)上有1个正方体。grid[1,1] = 4，表示坐标(1, 1)上有4个正方体。
 * 这么多个正方体叠放在一起，求它们的表面积。可以直接数完一共有多少个正方体，直接乘以6，然后减去接触面的个数乘以2（一个接触面会耗损2个单位面积）
 * 思路：
 * 首先，一个柱体一个柱体的看，每个柱体是由：2个底面（上表面/下表面）+ 所有的正方体都贡献了4个侧表面积。
 * 然后，把柱体贴合在一起之后，我们需要把贴合的表面积给减掉，两个柱体贴合的表面积就是 两个柱体高的最小值*2。
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/3/24 23:03
 */
public class Problems20200325 {

    public static int surfaceArea(int[][] grid) {
        int result = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                result+= grid[i][j]*6;
                if(grid[i][j]>1){
                    result-=(grid[i][j]-1)*2;
                }
                if (i >= 1) {
                    result -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                }
                if (j >= 1){
                    result -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{2}};
        System.out.println(surfaceArea(grid));
    }
}
