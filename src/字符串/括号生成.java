package 字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 回溯法
 */
public class 括号生成 {

    List<String> ans = new ArrayList<>();
    String[] str;
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        // 左右括号
        str = new String[]{"(", ")"};
        // n单个括号的个数 left左括号的个数 right右括号的个数
        // sb存储当前生成的括号组合
        backTract(n, 0, 0, sb);
        return ans;
    }
    public void backTract(int n, int left, int right, StringBuilder sb){
        // 不满足的情况
        if(left > n || right > n || left < right) return;
        // 找到了一个满足的情况
        if(left == n && right == n){
            ans.add(new String(sb));
        }
        // 先加左括号 回溯
        sb.append(str[0]);
        backTract(n, left + 1, right, sb);
        sb.deleteCharAt(sb.length() - 1);
        // 再加右括号 回溯
        sb.append(str[1]);
        backTract(n, left, right + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
