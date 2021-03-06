package letto.offer;

/**
 *请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */

public class Q02_replaceSpace {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello world");
        System.out.println(replaceSpace(str));
    }
    private static String replaceSpace(StringBuffer str){
        if (str==null){
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) ==' '){
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            }
            else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
}
