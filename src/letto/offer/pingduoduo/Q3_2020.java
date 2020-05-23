package letto.offer.pingduoduo;
//字典序

import java.math.BigDecimal;
import java.util.Scanner;


public class Q3_2020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //N个a
        int N = sc.nextInt();
        //M个b
        int M = sc.nextInt();
        //第K个单词
        double K = sc.nextDouble();

//        System.out.println(dic(N,M,K));
        System.out.println(cal(37,38));
        System.out.println(cal(37,37));
        System.out.println(dic(5,5,cal(5,5)));

    }
    //N个a,M个b
//    public static String dic(int N, int M, long K){
//        BigDecimal index = BigDecimal.valueOf(0);
//        StringBuilder s = new StringBuilder();
//        int num_a = N;
//        int num_b = M;
//        while (BigDecimal.valueOf(K).compareTo(index) > 0 && num_a!=0 && num_b!=0){
//            if (BigDecimal.valueOf(K).compareTo(index.add(cal(num_a - 1, num_b)).add(BigDecimal.valueOf(2))) > 0){
//                s.append("b");
//                index = index.add(cal(num_a - 1, num_b)).add(BigDecimal.valueOf(2));
//                num_b--;
//            }
//            else if (BigDecimal.valueOf(K).compareTo(index.add(cal(num_a - 1, num_b)).add(BigDecimal.valueOf(2))) == 0){
//                s.append("b");
//                return s.toString();
//            }
//            else {
//                s.append("a");
//                index = index.add(BigDecimal.valueOf(1));
//                num_a--;
//            }
//        }
//        if (num_a==0){
//            for (long i =0;i<K-index.longValue(); i++){
//                s.append("b");
//            }
//        }
//        if (num_b==0){
//            for (long i =0;i<K-index.longValue(); i++){
//                s.append("a");
//            }
//        }
//
//        return s.toString();
//
//    }
//
//    //解决 x个a和y个b有多少种排列方式
//    public static BigDecimal cal(int x, int y){
//        BigDecimal res = BigDecimal.valueOf(0);
//        int min = Math.min(x,y);
//        int max = Math.max(x,y);
//        for (int i=1; i<=min; i++){
//            res = res.add(new BigDecimal(2).pow(i));
//        }
//        for (int i = min+1; i<=x+y; i++){
//            BigDecimal e = BigDecimal.valueOf(0);
//            for (int j = min ;j>=i-max;j--){
//                e = e.add(doFactorial(i).divide((doFactorial(j).multiply(doFactorial(i - j))), 2));
//            }
//            res  = res.add(e);
//        }
//        return res;
//    }
//
//    public static BigDecimal doFactorial(int n){
//        if(n<0){
//            return BigDecimal.valueOf(-1);//传入的数据不合法
//        }
//        if(n==0){
//            return BigDecimal.valueOf(1);
//        }else if(n==1){//递归结束的条件
//            return BigDecimal.valueOf(1);
//        }else{
//            return BigDecimal.valueOf(n).multiply(doFactorial(n-1));
//        }
//    }
    public static String dic(int N, int M, double K){
        double index = 0;
        StringBuilder s = new StringBuilder();
        int num_a = N;
        int num_b = M;
        while (K>index && num_a!=0 && num_b!=0){
            if (cal(num_a-1,num_b)+2 <K){
                s.append("b");
                index += cal(num_a-1,num_b)+2;
                num_b--;
            }
            else if (cal(num_a-1,num_b)+2 == K){
                s.append("b");
                return s.toString();
            }
            else {
                s.append("a");
                index ++;
                num_a--;
            }
        }
        if (num_a==0){
            for (long i =0;i<K-index; i++){
                s.append("b");
            }
        }
        if (num_b==0){
            for (long i =0;i<K-index; i++){
                s.append("a");
            }
        }

        return s.toString();

    }

    //解决 x个a和y个b有多少种排列方式
    public static double cal(int x, int y){
        double res = 0;
        int min = Math.min(x,y);
        int max = Math.max(x,y);
        for (int i=1; i<=min; i++){
            res = res+Math.pow(2,i);
        }
        for (int i = min+1; i<=x+y; i++){
            double e = 0;
            for (int j = min ;j>=i-max;j--){
                e += doFactorial(i)/(doFactorial(j)*doFactorial(i - j));
            }
            res +=e;
        }
        return res;
    }

    public static double doFactorial(int n){
        if(n<0){
            return -1;//传入的数据不合法
        }
        if(n==0){
            return 1;
        }else if(n==1){//递归结束的条件
            return 1;
        }else{
            return n*doFactorial(n-1);
        }
    }
}
