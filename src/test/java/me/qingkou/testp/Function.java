package me.qingkou.testp;

/**
 * User: seeker
 * Date: 10/30/13
 * Time: 10:47 PM
 */
public interface Function<S, T> {
    public T apply(S s);
}
