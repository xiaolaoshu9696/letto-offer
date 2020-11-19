package letto.offer.leetcode.周赛.zhousai205;

/**
 * @author hkc
 * @date 2020/9/6 10:34
 */
public class Q1 {
    public static void main(String[] args) {
        System.out.println(modifyString("j?qg??b"));
    }

    public static String modifyString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<s.length(); i++){

            char cur = s.charAt(i);
            if (cur=='?'){
                if (i==0){
                    char next = i+1<s.length()?s.charAt(i+1):'#';
                    for (int j=0; j<26;j++){
                        char ap = (char)('a'+j);
                        if (ap!=next){
                            sb.append(ap);
                            break;
                        }
                    }
                }
                else if (i==s.length()-1){
                    char pre = sb.charAt(sb.length()-1);
                    for (int j=0; j<26;j++){
                        char ap = (char)('a'+j);
                        if (ap!=pre){
                            sb.append(ap);
                            break;
                        }
                    }
                }else{
                    char pre = sb.charAt(sb.length()-1);
                    char next = i+1<s.length()?s.charAt(i+1):'#';
                    for (int j=0; j<26;j++){
                        char ap = (char)('a'+j);
                        if (ap!=pre&& ap!=next){
                            sb.append(ap);
                            break;
                        }
                    }

                }
            }
            else{
                sb.append(cur);
            }

        }

        return sb.toString();
    }

}
