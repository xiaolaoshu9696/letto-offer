package letto.offer.vivo2020chunzhao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q3_chailiwu {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr);
        System.out.println(output);
    }

    private static int solution(String str) {

        // TODO Write your code here
        if(str.length()==0) return 0;
        int res = 0;
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c=='{') res++;
            if(c=='}') res--;
            if(c=='0') break;
        }
        return res;

    }

}
