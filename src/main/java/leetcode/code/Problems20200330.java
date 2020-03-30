package leetcode.code;

import java.util.Arrays;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/3/24 23:03
 */
public class Problems20200330 {
    /**
     * 约瑟夫环问题：
     * f(N,M)=(f(N−1,M)+M)%n
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for(int i = 2;i<=n;i++){
            ans = (ans+m)%i;
        }
        return ans;
    }
}
