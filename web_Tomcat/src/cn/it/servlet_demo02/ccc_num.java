package cn.it.servlet_demo02;

import java.util.HashMap;
import java.util.Map;

public class ccc_num {
    public static void main(String[] args) {
      String s = "adfcadfsdvgsgsdgda";
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        int sum = 0 ;
        /*for (char aChar : chars) {
            if(map.containsKey(aChar)){
                sum++;
                map.put(aChar, sum);
            }
        }*/
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)){
                Integer a = map.get(c);
                map.put(c,(++a));
            }else {
                map.put(c,1);
            }

        }
        System.out.println(map);
    }
}
