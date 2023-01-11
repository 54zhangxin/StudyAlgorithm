package 字符串;


import java.util.HashMap;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * medium
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 滑动窗口  通过双指针
 */
public class 无重复字符的最长子串 {
    /**
     * 解法一
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/475125
     * 1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
     * 此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；
     * <p>
     * 2、如果当前字符 ch 包含在 map中，此时有2类情况：
     *  1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
     * 那么此时更新 left 为 map.get(a)+1 = 1，当前有效子段更新为 bca；
     *  2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
     * 而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
     * 随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
     * 应该不变，left始终为2，子段变成 ba才对。
     * <p>
     * 为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
     * 另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
     * 因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
     */
    public static int lengthOfLongestSubString(String s) {

        if (s.length() == 0) return 0;
        //key ：存储字符  value  字符在string 的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;//最长子串长度
        int left = 0;//滑动窗口左下标，i相当于滑动窗口右下标
        for (int i = 0; i < s.length(); i++) {

            //charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
            if (map.containsKey(s.charAt(i))) {
                //此处必须取最大值，否则容易出现abba 的情况
                //+1 是为了将left 切到最新的位置
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);// 此处加一 是因为计算机取值从0 开始 要给转上来

        }
        return max;
    }


    /**
     * 左程云
     * 解法2
     * 1、 当前字符上一次出现的位置
     * 2、 i-1 位置向左推的 距离
     *
     *  a s k b c b a
     *  0 1 2 3 4 5 6
     *  条件1  a上次出现的位置是0 距离是7
     *  条件2  b向左的距离只能到3 所以5-3 是2
     *  此时最长距离就是  c b a  条件2 的基础上需要加1
     *
     */
    public static int lengthOfLongestSubString2(String s) {

        if (s == null || "".equals(s)) {
            return  0;
        }
        char[] chars = s.toCharArray();

        int length = s.length();
        //map[i] =v  i这个ascii码的字符,上次出现在v位置
        int[] map = new int[256];
        // 初始化map，每个字符上一次出现的下标为-1
        for (int i = 1; i < 256; i++) {
            map[i] =-1;
        }
        map[chars[0]] = 0;
        int pre = 1; //上一个位置 最长无重复子串 向左推了多长
        int ans = 1;
        for (int i = 1; i < length; i++) {
            int p1 = i - map[chars[i]];// 条件1
            int p2 = pre + 1 ; // 条件2
            int cur = Math.min(p1, p2); // 2者小值是最长无重复子串
            ans = Math.max(cur, ans);
            pre = cur;
            map[chars[i]] = i;

        }

        return ans;

    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString("abba"));
    }






}
