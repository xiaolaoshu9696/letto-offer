package letto.offer.leetcode;

import java.util.*;

/**
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 * 示例 1:
 *
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class leetcode336_hard {

    //暴力法 超时
//    public List<List<Integer>> palindromePairs(String[] words) {
//        List<List<Integer>> res = new ArrayList();
//        int len = words.length;
//        for(int i = 0; i<len; i++){
//            for(int j = 0; j<len; j++){
//                if(i!=j){
//                    if(ishuiwen(words[i],words[j])){
//                        List<Integer> list = new ArrayList();
//                        list.add(i);
//                        list.add(j);
//                        res.add(list);
//                    }
//                }
//
//            }
//        }
//        return res;
//    }
//
//    public boolean ishuiwen(String s1, String s2){
//        String s = s1+s2;
//        int l = s.length();
//        for(int i = 0; i<l/2; i++){
//            if(s.charAt(i)!=s.charAt(l-1-i)) return false;
//        }
//        return true;
//    }

    List<String> wordsRev = new ArrayList<String>();
    //保存反转的字符串
    Map<String, Integer> indices = new HashMap<String, Integer>();

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        for (String word: words) {
            wordsRev.add(new StringBuffer(word).reverse().toString());
        }
        for (int i = 0; i < n; ++i) {
            indices.put(wordsRev.get(i), i);
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = words[i].length();
            if (m == 0) {
                continue;
            }

            for (int j = 0; j <= m; j++) {
                //判断是不是回文
                //右边
                if (isPalindrome(word, j, m - 1)) {
                    int leftId = findWord(word, 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                //左边
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int rightId = findWord(word, j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        return indices.getOrDefault(s.substring(left, right + 1), -1);
    }
}
