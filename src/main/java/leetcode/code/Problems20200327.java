package leetcode.code;

import java.util.Arrays;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/3/24 23:03
 */
public class Problems20200327 {

    public boolean hasGroupsSizeX(int[] deck) {
        int[] counter = new int[10000];
        for(int num:deck){
            // 记录每个数字出现的次数
            counter[num]++;
        }
        return Arrays.stream(counter).reduce(this::gcd).getAsInt()>1;
    }

    /**
     * 辗转相除法：
     * 辗转相除法的基本原理是：两个数的最大公约数等于它们中较小的数和两数之差的最大公约数。
     * 例如，252和105的最大公约数是21（252 = 21 × 12；105 = 21 × 5）；因为252 − 105 = 147，
     * 所以147和105的最大公约数也是21。在这个过程中，较大的数缩小了，
     * 所以继续进行同样的计算可以不断缩小这两个数直至其中一个变成零。
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] deck = new int[]{1,2,3,4,4,3,2,1};
        Problems20200327 problems20200327 = new Problems20200327();
        System.out.println(problems20200327.hasGroupsSizeX(deck));
    }
}
