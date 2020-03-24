package leetcode.code;

import java.util.Arrays;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * 实例：
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/3/22 22:34
 */
public class Problems20200323 {
    int[] a = new int[]{3,2,1,2,1,7};

    /**
     * 排序
     * @param a
     * @return
     */
    public int solutionA(int[] a){
        Arrays.sort(a);
        int move = 0;
        for(int i = 1;i<a.length;i++){
            if(a[i]<=a[i-1]){
                int pre = a[i];
                a[i] = a[i-1]+1;
                move += a[i]-pre;
            }
        }
        return move;
    }

    public int solutionB(int[] a){
        // counter数组统计每个数字的个数。
        //（这里为了防止下面遍历counter的时候每次都走到40000，所以设置了一个max，这个数据量不设也行，再额外设置min也行）
        int[] counter = new int[40001];
        int max = -1;
        for (int num: a) {
            counter[num]++;
            max = Math.max(max, num);
        }

        // 遍历counter数组，若当前数字的个数cnt大于1个，则只留下1个，其他的cnt-1个后移
        int move = 0;
        for (int num = 0; num <= max; num++) {
            if (counter[num] > 1) {
                int d = counter[num] - 1;
                move += d;
                counter[num + 1] += d;
            }
        }
        // 最后, counter[max+1]里可能会有从counter[max]后移过来的，counter[max+1]里只留下1个，其它的d个后移。
        // 设 max+1 = x，那么后面的d个数就是[x+1,x+2,x+3,...,x+d],
        // 因此操作次数是[1,2,3,...,d],用求和公式求和。
        int d = counter[max + 1] - 1;
        move += (1 + d) * d / 2;
        return move;

    }

    public int solutionC(int[] a){
        int[] pos = new int [80000];
        // -1表示空位
        Arrays.fill(pos, -1);
        int move = 0;
        // 遍历每个数字a对其寻地址得到位置b, b比a的增量就是操作数。
        for (int i: a) {
            int b = findPos(i);
            move += b - i;
        }
        return move;

    }
    /**
     * 线性探测寻址（含路径压缩)
     */
    private int findPos(int a) {
        int[] pos = new int [80000];
        int b = pos[a];
        // 如果a对应的位置pos[a]是空位，直接放入即可。
        if (b == -1) {
            pos[a] = a;
            return a;
        }
        // 否则向后寻址
        // 因为pos[a]中标记了上次寻址得到的空位，因此从pos[a]+1开始寻址就行了（不需要从a+1开始）。
        b = findPos(b + 1);
        // 寻址后的新空位要重新赋值给pos[a]哦，路径压缩就是体现在这里。
        pos[a] = b;
        return b;
    }
}
