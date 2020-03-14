package letto.offer;

/**
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */


/**
 * 1. 当模式中第二个字符不是*时， 如果第一个字符匹配则 字符串和模式都向后移动一位，如果不匹配则直接失败
 * 2.当模式中第二个字符是* 时，若第一个字符个模式中第一个字符不匹配则模式后移两个字符继续匹配
 * 若匹配则有3种情况。（1） 模式后移2字符，相当于x*被忽略
 * （2） 字符串后移1个字符，模式后移2个字符
 * （3） 字符串后移1个字符，模式不变，继续匹配字符串下一位
 *
 */
public class Q52_match {
    public boolean match(char[] str, char[] pattern)
    {
        if (str==null || pattern ==null) return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex){
        //同时到了结尾
        if (strIndex == str.length && patternIndex == pattern.length){
            return true;
        }

        if (strIndex != str.length && patternIndex==pattern.length){
            return false;
        }

        // 模式第二个是*， 且字符串第1个跟模式第一个匹配，分3种匹配模式
        // 如不匹配，模式后移两位
        if (patternIndex+1 < pattern.length && pattern[patternIndex+1] == '*'){
            if ((strIndex!=str.length && pattern[patternIndex] == str[strIndex])
            ||pattern[patternIndex] == '.' && strIndex != str.length)
            {
                return matchCore(str,strIndex,pattern,patternIndex+2)
                        || matchCore(str,strIndex+1, pattern,patternIndex+2)
                        || matchCore(str,strIndex+1, pattern, patternIndex);
            }
            else{
                return matchCore(str, strIndex, pattern, patternIndex+2);
            }
        }

        if ((strIndex!=str.length && pattern[patternIndex] == str[strIndex])
                || (pattern[patternIndex]=='.' && strIndex!=str.length)){
            return matchCore(str, strIndex+1, pattern, patternIndex+1);
        }

        return false;
    }

}
