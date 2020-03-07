package letto.offer;

/**
 *在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 */

public class Q34_FirstNotRepeatingChar {
    //利用hashmap的思想来存储出现的次数；
    public int FirstNotRepeatingChar(String str) {
        int[] word = new int[58];
        for (int i=0; i<str.length(); i++){
            word[(int) str.charAt(i)-65] +=1;
        }
        for (int i = 0; i<str.length(); i++){
            if (word[(int) str.charAt(i) -65] ==1){
                return i;
            }
        }
        return -1;
    }
}
