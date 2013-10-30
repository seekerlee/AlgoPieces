package me.qingkou.test;

/**
 * User: seeker
 * Date: 10/27/13
 * Time: 4:15 PM
 */
public class Test {
    public static void main(String[] da) {
        // a is a single-element array of String
        String[] a = new String[1];

        // b is an array of Object
        Object[] b = a;

        // Assign an Integer to b. This would be possible if b really were
        // an array of Object, but since it really is an array of String,
        // we will get a java.lang.ArrayStoreException.
        b[0] = 1;
    }
}
