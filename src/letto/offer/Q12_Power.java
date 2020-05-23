package letto.offer;

public class Q12_Power {
    public double Power(double base, int n) {
        double res = 1, curr = base;
        int exponent;
        if (n>0){
            exponent=n;
        }
        else if (n<0){
            if (base==0)
                throw  new RuntimeException("底数不能为0");
            exponent = -n;
        }
        else return 1; //n=0时
        while (exponent!=0){
            if ((exponent&1)==1) res = res*curr;
            curr = curr*curr;
            exponent>>=1; // 右移一位
        }
        return n>0?res:(1/res);
    }
}
