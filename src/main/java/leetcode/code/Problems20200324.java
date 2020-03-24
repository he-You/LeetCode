package leetcode.code;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，
 * 因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * 示例 1：
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * <p>
 * 示例 2：
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * <p>
 * 示例 3：
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 *
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/3/24 23:03
 */
public class Problems20200324 {

    public static int massage(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            int c = Math.max(b, a + num);
            a = b;
            b = c;
        }
        System.out.println(b);
        return b;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 4, 5, 3, 1, 1, 3};
        massage(nums);
    }
}
