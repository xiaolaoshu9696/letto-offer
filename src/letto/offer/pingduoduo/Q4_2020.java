package letto.offer.pingduoduo;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Q4_2020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] X = new int[num];
        for (int i=0; i<num; i++){
            X[i] = sc.nextInt();
        }
        DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        String p=decimalFormat.format(qiwang(X));//format 返回的是字符串

        System.out.println(p);
    }
    public static double qiwang(int[] x){
        int len = x.length;
        double n=1;
        for (int value : x) {
            n = n*value;
        }
        Arrays.sort(x);
        double qiwang = 0;
        while (x[len-1]!=1){
            double a = 1;;
            for (int i = 0; i<len-1;i++){
                a = a*x[i];
            }
            qiwang += a*x[len-1];
            x[len-1] -=1;
            Arrays.sort(x);
        }
        qiwang +=1;
        return qiwang/n;
    }


}