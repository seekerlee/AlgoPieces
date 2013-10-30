package me.qingkou.testp;

/**
 * User: seeker
 * Date: 10/30/13
 * Time: 10:48 PM
 */
public class Dosth {
    public static void main(String[] sda) {
        Integer ii = new Action<String, Integer>().act("ddsds", new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
        System.out.print(ii);
    }
}
class Action<S, T> {
    public T act(S s, Function<S, T> f) {
        return f.apply(s);
    }
}
