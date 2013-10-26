package io.github.seekerlee.algopieces;

/**
 * User: seeker
 * Date: 10/23/13
 * Time: 9:00 PM
 */
public class QSort {

    public static int[] sort(int[] arr, int left, int right) {
        if(right - left <= 1) return arr;
        int pValue = arr[right];
        int storeIndex = left;
        for(int i = left; i < right; i ++) {
            if (arr[i] <= pValue)  {
                swap(arr, i, storeIndex);
                storeIndex ++;
            }
        }
        swap(arr, right, storeIndex);
        sort(arr, left, storeIndex - 1);
        sort(arr, storeIndex + 1, right);
        return arr;
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] a) {
        int[] arr = {10, 7, 2, 9, 0};
        sort3(arr, 0, arr.length - 1);
        for(int ii : arr) {
            System.out.println(ii);
        }
    }

    public static void sort2(int[] arr, int begin, int end) {
        if(end - begin < 2) return;

        final int pValue = arr[end];
        int storeIndex = 0;
        for(int i = 0; i < end; i ++) {
            if(arr[i] <= pValue) {
                swap(arr, i, storeIndex);
                storeIndex ++;
            }
        }
        swap(arr, end, storeIndex);
        sort2(arr, begin, storeIndex - 1);
        sort2(arr, storeIndex + 1, end);
    }

    public static void sort3(int arr[], int left, int right) {
        if(right <= left) return;

        int pValue = arr[right];

        int leftIndex = left;
        int rightIndex = right;
        while(true) {
            if (leftIndex == rightIndex) break;
            while(true) {
                if(leftIndex == rightIndex) break;
                if(arr[leftIndex] <= pValue) {
                    leftIndex ++;
                } else {
                    break;
                }
            }
            while(true) {
                if (leftIndex == rightIndex) break;
                if (arr[rightIndex] >= pValue) {
                    rightIndex --;
                } else {
                    break;
                }
            }
            swap(arr, leftIndex, rightIndex);
        }
        swap(arr, leftIndex, right);

        sort3(arr, left, rightIndex - 1);
        sort3(arr, rightIndex + 1, right);
    }
}
