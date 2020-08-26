package letto.offer.vivo2020chunzhao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2_baoshu {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static String solution(int[] input) {

        // TODO Write your code here
        int n = input[0];
        int m = input[1];
        ArrayList<Integer> list = new ArrayList();
        int[] array = new int[n];
        int i = -1, step = 0, count =n;
        while(count>0){
            i++;
            if(i>=n) i=0;
            if(array[i]==-1) continue;
            step++;
            if(step == m){
                list.add(i+1);
                array[i]=-1;
                step = 0;
                count--;

            }
        }
        StringBuilder s = new StringBuilder();
        for (int j=0; j<list.size();j++){
            if (j==0) s.append(list.get(0));
            else{
                s.append(" ");
                s.append(list.get(j));
            }
        }
        return s.toString();
    }
}
