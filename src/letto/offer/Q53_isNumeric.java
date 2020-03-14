package letto.offer;

import java.sql.PreparedStatement;

/**
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */


public class Q53_isNumeric {
    private int index = 0;
    public boolean isNumeric(char[] str) {
        if (str.length<1) return false;
        boolean flag = scanInteger(str);

        //出现小数部分
        if (index<str.length && str[index] == '.'){
            index++;
            // 防止出现小数没有整数部分或小数部分
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index<str.length && (str[index] == 'E'|| str[index] == 'e')){
            index++;
            // 前面必须有整数字，后面必须有整数
            flag = flag&&scanInteger(str);
        }
        return flag && index==str.length;

    }

    private boolean scanInteger(char[] str) {
        if (index<str.length && (str[index] == '+' || str[index]=='-'))
            index++;
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index<str.length && str[index] >='0' && str[index] <= '9')
            index++;
        return start<index;
    }

}
