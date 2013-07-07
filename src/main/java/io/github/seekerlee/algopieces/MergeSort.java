package io.github.seekerlee;

import java.util.Arrays;

/**
 * User: seeker
 * Date: 7/6/13
 * Time: 9:48 PM
 */
public class MergeSort {

    private final int[] arr;
    private long inversions = 0L;
    public MergeSort(int[] arr) {
        this.arr = arr;
        mergeSort(0, arr.length);
    }

    public void mergeSort(final int startI, final int len) {
        if(len == 1) {
            return;
        }
        mergeSort(startI, len / 2);
        mergeSort(startI + len / 2, len - len / 2);
        //merge
        int[] temp = new int[len];
        int i = startI, j = startI + len / 2;
        for(int ti = 0; ti < len; ti ++) {
            if(i < startI + len / 2 && (j >= startI + len || lessThan(arr[i], arr[j], len / 2 - (i - startI)))) {
                temp[ti] = arr[i];
                i ++;
            } else if(j < startI + len) {
                temp[ti] = arr[j];
                j ++;
            }
        }
        for(int ti = 0; ti < len; ti ++) {
            arr[startI + ti] = temp[ti];
        }
        return;
    }

    private boolean lessThan(int a, int b, int len){
        if(a > b) this.inversions = this.inversions + len;
        return a < b;
    }

    public int[] getArr() {
        return arr;
    }

    public long getInversions() {
        return inversions;
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort(new int[]{3, 6, 1, 2});
        System.out.println(ms.inversions);
    }
}
