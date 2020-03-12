package letto.offer;

/**
 *
 * 将一个字符串转换成一个整数，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 *
 */

public class Q49_StrToInt {
    public int StrToInt(String str) {
        if (str == null) return 0;
        int result = 0;
        boolean negative = false; //是否负数
        int i = 0, len = str.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len>0){
            char firstChar = str.charAt(0);
            if (firstChar < '0'){
                if (firstChar == '-'){
                    negative = true;
                    limit = Integer.MIN_VALUE;
                }
                else if (firstChar!='+') return 0;
                if (len==1) return 0;
                i++;
            }
            multmin = limit/10;
            while (i<len){
                digit = str.charAt(i++) - '0'; //利用char转int特性
                if (digit<0 || digit>9) return 0;
                if (result < multmin)   return 0;
                result *=10;
                if (result< limit +digit) return 0;
                result = result-digit;
            }
        } else return 0;
        return negative ? result:-result;

    }
}
