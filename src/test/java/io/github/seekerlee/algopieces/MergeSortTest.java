package io.github.seekerlee.algopieces;

import io.github.seekerlee.MergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * User: seeker
 * Date: 7/7/13
 * Time: 3:03 PM
 */
public class MergeSortTest {
    public static void main(String[] args) throws IOException {
        InputStream in = MergeSortTest.class.getClassLoader().getResourceAsStream("IntegerArray.txt");
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String line;
        int[] input = new int[100000];
        int index = 0;
        while ((line = br.readLine()) != null) {
            input[index] = Integer.valueOf(line);
            index ++;
        }
        br.close();
        System.out.println(input);
        MergeSort ms = new MergeSort(input);
        System.out.println("done");
        System.out.println(Arrays.toString(ms.getArr()));
        System.out.println(ms.getInversions());
    }
}
