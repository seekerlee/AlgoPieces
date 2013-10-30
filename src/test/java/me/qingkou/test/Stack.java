package me.qingkou.test;

/**
 * User: seeker
 * Date: 10/28/13
 * Time: 9:26 PM
 */
public class Stack<T>{
    private int top = -1;
    private T[] arr = null;

    public void put(T element) {
        arr[top + 1] = element;
        top ++;
    }

    public T pop(){
        if(top == -1) return null;
        T r = arr[top];
        arr[top] = null;
        top --;
        return r;
    }

    public Stack(int capacity) {
        this.arr = (T[])new Object[capacity];
    }

    public static void main(String[] adsd) {
        Stack<Integer> s = new Stack<Integer>(10);
        s.put(12);
        s.put(13);
        s.put(14);
        int h = s.pop();
        System.out.println(h);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
