package letto.offer.mianshizhinan;
import java.util.Scanner;


public class kuohao {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(iskuohao(str)){
            System.out.println("YES");
        }
        else System.out.println("NO");

    }

    private static boolean iskuohao(String str){
        int flag=0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '(') flag++;
            else if(str.charAt(i) == ')'){
                flag--;
                if(flag < 0) return false;
            }
            else return false;
        }
        return flag==0;
    }

}
