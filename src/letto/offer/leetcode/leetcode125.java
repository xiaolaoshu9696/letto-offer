package letto.offer.leetcode;

public class leetcode125 {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len-1;
        while (left < right) {
            while (!Character.isLetter(s.charAt(left))&& !Character.isDigit(s.charAt(left))){
                left++;
            }
            char c1 = s.charAt(left);
            c1 = Character.toLowerCase(c1);

            while (!Character.isLetter(s.charAt(right))&& !Character.isDigit(s.charAt(right))){
                right--;
            }
            char c2 = s.charAt(right);
            c2 = Character.toLowerCase(c2);

            if (c1!=c2) return false;
        }
        return true;

    }
}
