package letto.offer.leetcode;

public class leetcode696 {

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("10101"));
    }
    public static int countBinarySubstrings(String s) {
        int count0 = 0;
        int count1 = 0;
        int index = 0;
        int res = 0;
        while(index<s.length()){
            if(count0==0 && count1==0){
                if(s.charAt(index)=='1') count1++;
                if(s.charAt(index)=='0') count0++;
                index++;
                continue;
            }
            if(s.charAt(index)=='0'){
                if(count1==0) {
                    count0++;
                    index++;
                }
                else{
                    count0=1;
                    res++;
                    while(index+1<s.length()&&s.charAt(index+1)=='0'){
                        count0++;
                        if(count0<=count1) res++;
                        index++;
                    }
                    index++;

                }
            }
            else if(s.charAt(index)=='1'){
                if(count0==0) {
                    count1++;
                    index++;
                }
                else{
                    count1=1;
                    res++;
                    while(index+1<s.length()&&s.charAt(index+1)=='1'){
                        count1++;
                        if(count1<=count0) res++;
                        index++;
                    }
                    index++;

                }
            }

        }
        return res;

    }
}
