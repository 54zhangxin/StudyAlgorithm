package 动态规划;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/word-break/
 * medium
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 *
 */
public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        //dp[i] 表示 s 都前i位可以用wordDict中的单词表示
        boolean[] dp = new boolean[length + 1];
        Arrays.fill(dp, false);// 把数组dp 全部赋值false
        dp[0] = true;//空字符可以被表示。
        for (int i = 0; i < length; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                if (word.length() + i <= s.length() && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[length];
    }
}
