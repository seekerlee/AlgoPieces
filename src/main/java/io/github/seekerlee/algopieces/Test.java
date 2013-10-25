package io.github.seekerlee.algopieces;

/**
 * User: seeker
 * Date: 10/24/13
 * Time: 7:58 PM
 */
public class Test {
    public static boolean checkUniq(String s) {
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i ++) {
            for(int j = i + 1; j < c.length; j++) {
                if(c[j] == c[i]) return false;
            }
        }
        return true;
    }

    public static void main(String[] asds) {
        System.out.println(isUniqueChars2("dsadsadsa"));
        System.out.println(isUniqueChars2("asdhui"));
        System.out.println(isUniqueChars2("aa"));
        System.out.println(isUniqueChars2("huiogstre"));
        System.out.println(isUniqueChars2("dsajkluio890"));
    }
    public static boolean isUniqueChars2(String str) {
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }
}
