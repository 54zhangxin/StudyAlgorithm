package 字符串;

import java.util.Stack;

/**
 * 题目详情：https://leetcode-cn.com/problems/valid-parentheses/
 * 题目：(easy)
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class 有效的括号 {

    public boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        if (stack.empty())
            return true;
        return false;
    }

    /**
     *  距离： (){[]}
     *   栈 放入） 栈pop弹出） 因为想等不会返回false
     *  栈 放入{  然后放入【
     */
}
