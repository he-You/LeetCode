package leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/7/11 23:55
 */
public class LeetCode315 {
    public static List<Integer> countSmaller(int[] nums) {
        Integer[] ret = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = 0;
        }
        List<Integer> list = new ArrayList<>();
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, new TreeNode(nums[i]), ret, i);
        }
        return Arrays.asList(ret);
    }

    public static TreeNode insert(TreeNode root, TreeNode node, Integer[] ret, int i) {
        if (root == null) {
            root = node;
            return root;
        }
        // 注意小于等于插入到左子树，防止多加1
        if (root.val >= node.val) {
            root.count++;
            root.left = insert(root.left, node, ret, i);
        } else {
            ret[i] += root.count + 1;
            root.right = insert(root.right, node, ret, i);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,2,6,1};
        List<Integer> integers = countSmaller(array);
        System.out.println(integers);
    }
}

class TreeNode {
    int val;
    int count;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
        count = 0;
    }
}
