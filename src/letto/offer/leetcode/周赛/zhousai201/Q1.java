package letto.offer.leetcode.周赛.zhousai201;

public class Q1 {

    public static void main(String[] args) {
        System.out.println(makeGood("s"));
    }

    public static String makeGood(String s) {

        String nexts = onesetp(s);
        while (!check(nexts)){
            nexts = onesetp(nexts);
        }
        return nexts;

    }

    public static  String onesetp(String s){
        int gap = 'a' - 'A';
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index<s.length()){

            if (index==s.length()-1){
                sb.append(s.charAt(index));
                break;
            }

            if (s.charAt(index)!=s.charAt(index+1)-gap && s.charAt(index)!= s.charAt(index+1)+gap){
                sb.append(s.charAt(index));
                index++;
            }
            else{
                index+=2;
            }
        }
        return sb.toString();
    }

    public static boolean check(String s){
        int gap = 'a' - 'A';
        for (int i = 0; i<s.length()-1;i++){
            if (s.charAt(i)==s.charAt(i+1)-gap || s.charAt(i)== s.charAt(i+1)+gap) return false;
        }
        return true;

    }

}
