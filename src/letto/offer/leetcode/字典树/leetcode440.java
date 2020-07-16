package letto.offer.leetcode.字典树;

public class leetcode440 {

    int count = 0;
    int res = 0;
    boolean isFound = false;

    public static void main(String[] args) {
        leetcode440 s = new leetcode440();
        System.out.println(s.findKthNumber(681692778,
                351251360));
    }


    //利用递归的解法
    public int findKthNumber(int n, int k) {
        //十叉树先序遍历
        lexicalOrderdfs(n,0,0,k);
        return res;
    }
    public void lexicalOrderdfs(int maxvalue, int num, int flag,int k){
        if(num>maxvalue || isFound) return;
        if(num>0){
            count++;
            if(count==k){
                isFound = true;
                res = num;
            }
        }
        //第一层只能选择1~9，后面可以选择0~9
        for(int i=flag>0?0:1; i<=9; i++){
            lexicalOrderdfs(maxvalue,num*10+i,1,k);
        }
    }
}
