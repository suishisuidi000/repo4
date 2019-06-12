package JDBCUtils;

/*
 "Zhang biao zhen Shuai zhAng biao fei chang shuai"
 */
public class Test01 {
    public static void main(String[] args) {
        String s = "Zhang biao zhen Shuai zhAng biao fei chang shuai";
        String[] sp = s.split(" ");
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < sp.length; i++) {
            String s1 = sp[i].toLowerCase();
            char c = (char)(s1.charAt(0) - 32);
            ss.append(c).append(s1.substring(1)).append(" ");
        }
        String s1 = ss.toString();
        System.out.println(s1);
    }
}
