package letto.offer.leetcode.字节常见题.字符串;

/**
 * @author hkc
 * @date 2020/9/2 10:16
 */
public class sw20 {
    public static void main(String[] args) {
        sw20 s = new sw20();
        System.out.println(s.isNumber(". 1"));
    }

    private int index = 0;
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length()==0) return false;
        if(s.charAt(s.length()-1) == 'e') return false;
        char[] str = s.toCharArray();
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
