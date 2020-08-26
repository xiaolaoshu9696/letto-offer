package letto.offer.leetcode;

public class leetcode459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int index = 0;
        while(index<len/2){
            if(s.charAt(index) == s.charAt(len-1) && s.charAt(index+1)==s.charAt(0)){
                //判断长度是否符合要求
                if(len%(index+1)==0){
                    if(isvali(s,index)){
                        return true;
                    }
                }
            }
            index++;
        }
        return false;
    }

    public boolean isvali(String s, int index){
        int cnt = s.length()/(index+1);
        for(int i = 0; i<=index; i++){
            char cur = s.charAt(i);
            for(int j = 1; j<cnt; j++){
                char compare = s.charAt(j*(index+1) + i);
                if(compare!=cur) return false;
            }
        }
        return true;
    }

}
