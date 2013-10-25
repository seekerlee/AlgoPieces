package io.github.seekerlee.algopieces;

/**
 * User: seeker
 * Date: 10/24/13
 * Time: 10:16 PM
 */
public class MSort {
    public static void sort(int[] arr, int begin, int end){
        if(end == begin) return;
        final int halfLength = (end - begin + 1) / 2;
        final int leftEnd = begin + halfLength - 1;
        final int rightBegin = begin + halfLength;
        // sort left and right
        sort(arr, begin, leftEnd);
        sort(arr, rightBegin, end);
        //merge
        int[] sortedArr = new int[end - begin + 1];
        int lIndex = begin;
        int rIndex = rightBegin;
        for(int i = 0; i < sortedArr.length; i ++) {
            if(lIndex >= rightBegin && rIndex <= end) {
                sortedArr[i] = arr[rIndex];
                rIndex ++;
                continue;
            }
            if(rIndex > end && lIndex <= rightBegin) {
                sortedArr[i] = arr[lIndex];
                lIndex ++;
                continue;
            }
            if(rIndex <= end && lIndex <= rightBegin) {
                if(arr[lIndex] <= arr[rIndex]) {
                    sortedArr[i] = arr[lIndex];
                    lIndex ++;
                } else {
                    sortedArr[i] = arr[rIndex];
                    rIndex ++;
                }
            }
        }
        for(int i = 0; i < sortedArr.length; i++) {
            arr[begin + i] = sortedArr[i];
        }
    }
    public static void main(String[] a) {
        int[] arr = {10, 7, 6, 3, 5, 8, 2, 9, 0};
        sort(arr, 0, arr.length - 1);
        for(int ii : arr) {
            System.out.println(ii);
        }
    }
}
