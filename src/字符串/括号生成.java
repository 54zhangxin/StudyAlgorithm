package 字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/generate-parentheses/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 中等
 * 回溯法  深度优先遍历
 */
public class 括号生成 {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    /**
     *
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param curStr 当前递归得到的结果
     */
    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }
        // 剪枝
        if (left > right) {
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }
}
